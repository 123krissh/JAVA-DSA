import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class question {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
           map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        HashSet<Integer> unique = new HashSet<>();
        for(int freq: map.values()){
            if(unique.contains(freq)){
                return false;
            }else{
                unique.add(freq);
            }
        }
        return true;
    }

    // Find Minimum in Rotated Sorted Array I & II ----->
    public static int findMin(int[] arr) {
        //Basic approch
        // Arrays.sort(nums);
        // return nums[0];

        int left=0;
        int right=arr.length-1;
        while(left < right) {
            int mid = (left + right)/2;
            if(arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return arr[left];
    }

    // Maximum Average Pass Ratio ----->
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for(int i=0; i<classes.length; i++){
            int pass = classes[i][0];
            int total = classes[i][1];
            double gain = (double)(pass+1)/(total+1) - (double)pass/total;
            maxHeap.add(new double[]{gain, pass, total});
        }

        while(extraStudents > 0){
            double[] top = maxHeap.poll();
            int pass = (int)top[1] + 1;
            int total = (int)top[2] + 1;
            double newGain = (double)(pass+1)/(total+1) - (double)pass/total;
            maxHeap.add(new double[]{newGain, pass, total});
            extraStudents--;
        }
        
        double result = 0.0;
        while(!maxHeap.isEmpty()){
            double[] top = maxHeap.poll();
            result += top[1]/top[2];
        }
        return result/classes.length;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
        System.out.println(findMin(arr));

        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }
}
