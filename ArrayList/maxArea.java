import java.util.ArrayList;

public class maxArea {

    public static int maxArea(ArrayList<Integer> height) {
        int maxArea = 0;
        // brute force approch time complexity O(n^2)
        for (int i = 0; i < height.size(); i++) {
            for (int j = 0; j < height.size(); j++) {
                int width = j-i;
                int ht = Math.min(height.get(i), height.get(j));
                int currArea = width * ht;
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;

        // optimized approch (two pointer) time complexity O(n)
        int maxArea = 0;
        int left = 0;
        int right = height.size() - 1;
        while (left < right) {
            int width = right - left;
            int ht = Math.min(height.get(left), height.get(right));
            int currArea = width * ht;
            maxArea = Math.max(maxArea, currArea);

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
            // OR
            while(left < right && height.get(left) <= ht) left++;
            while(left < right && height.get(right) <= ht) right--;
        }
        return maxArea;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        int result = maxArea(height);
        System.out.println("Containor with most water: " + result);
    }
}
