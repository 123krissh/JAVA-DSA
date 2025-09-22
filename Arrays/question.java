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

    // Count elements with maximum frquency occurrences ----->
    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int totalOccurrences = 0;

        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);

            if (freq > maxFreq) {
                maxFreq = freq;
                totalOccurrences = freq;
            } else if (freq == maxFreq) {
                totalOccurrences += freq;
            }
        }

        return totalOccurrences;

        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i=0; i<nums.length; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        // }

        // int maxFreq = Collections.max(map.values());
        // int totalOccurrences = 0;

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if(entry.getValue() == maxFreq){
        //         totalOccurrences += maxFreq;
        //     }
        // }
        // return totalOccurrences;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
        System.out.println(findMin(arr));

        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
        System.out.println(maxFrequencyElements(arr));
    }
}
