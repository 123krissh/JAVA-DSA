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

    // Minimized Maximum of Products distribute to any store ---->
    public static int minimizedMaximum(int n, int[] quantities) {
        // Arrays.sort(quantities);
        int L = 1;
        int H = 0;
        
        for (int q : quantities) {
            H = Math.max(H, q);
        }
      
        while(L <= H){
            int mid = (L+H)/2;
            if(canDistribute(n, quantities, mid)){
                H = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    public static boolean canDistribute(int n, int[] quantities, int x) {
        int store = 0;
        for(int q: quantities){
            store += (q + x - 1) / x; 
        }
        return store <= n;
    }

    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position, m));
        int[] quantities = {1,2,3,4,7};
        int n = 3;
        System.out.println(minimizedMaximum(n, quantities));
    }
}
