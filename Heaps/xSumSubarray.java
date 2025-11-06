import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class xSumSubarray {

    // Find X-Sum of All K-Long Subarrays I
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        res[0] = getXSum(freq, x);

        for(int i=k; i<n; i++) {
            int newEle = nums[i];
            int oldEle = nums[i-k];
            freq.put(newEle, freq.getOrDefault(newEle, 0) + 1);
            freq.put(oldEle, freq.getOrDefault(oldEle, 0) - 1);

            if(freq.getOrDefault(oldEle, 0) == 0) {
                freq.remove(oldEle);
            }
            res[i - k + 1] = getXSum(freq, x);
        }
        return res;
    }

    private static int xSum( Map<Integer, Integer> freq, int x) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

        Collections.sort(list, (a,b) -> {
            if(!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return b.getKey() - a.getKey();
        });

        int sum = 0;
        int count = 0;
        for(Map.Entry<Integer, Integer> e : list) {
            if(count >= x){
                break;
            }
            sum += e.getKey() * e.getValue();
            count += 1;
        }
        return sum;
    }

    // with priority Queue 
    private static int getXSum(Map<Integer, Integer> freq, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // minHeap
            if (a[1] != b[1]) return a[1] - b[1]; // smaller freq → weaker
            return a[0] - b[0]; // smaller num → weaker
        });

        for (var entry : freq.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > x) pq.poll(); // remove weakest
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            sum += top[0] * top[1];
        }
        return sum; 
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,2,3};
        int k = 6;
        int x = 2;

        int[] result = findXSum(nums, k, x);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
