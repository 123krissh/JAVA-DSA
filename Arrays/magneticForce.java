import java.util.Arrays;

public class magneticForce {

    public static int maxDistance(int[] position, int m) {
        int n = position.length;
        int answer = 0;
        Arrays.sort(position);

        int low = 1;
        int high = position[n-1] - position[0];

        while(low <= high){
            int mid = (low + high)/2;
            if(canPlace(position, m, mid)){
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    public static boolean canPlace(int[] position, int m, int dist){
        int count = 1;
        int lastPlaced = position[0];

        for(int i =1; i<position.length; i++){
            if((position[i] - lastPlaced) >= dist){
                count++;
                lastPlaced = position[i];

                if(count == m){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position, m));
    }
}
