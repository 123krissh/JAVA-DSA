import java.util.Arrays;

public class binarySearchQ {
    
    // Longest Subsequence With Limited Sum
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        
        for(int i=1; i<nums.length; i++){
            nums[i]=nums[i]+nums[i-1];
        }

        for(int i=0; i<queries.length; i++){
            int idx = BinarySearch(nums, queries[i]);
            ans[i] = idx;
        }
        return ans;
    }

    public static int BinarySearch(int[] nums, int target){
        int l = 0, h = nums.length-1;
        while(l <= h){
            int mid = (l + h)/2;
            if(nums[mid] <= target) l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }

    // Successful Pairs of Spells and Potions
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        
        // int k = 0;
        // for(int i=0; i<n; i++){
        //     int count = 0;
        //     for(int j=0; j<m; j++){
        //         if(spells[i] * potions[j] >= success) count++;
        //     }
        //     pairs[k++] = count;
        // }

        for(int i=0; i<n; i++){
            long required = (success + spells[i] - 1)/spells[i];
            int idx = lowerIdx(potions, required);
            pairs[i] = m - idx;
        }
        return pairs;
    }
    public static int lowerIdx(int[] potions, long target){
        int low = 0, high = potions.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(potions[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }


    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {8,2,4,1,5};
        long success = 7;
        int[] result = successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(result));

        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        int[] ans = answerQueries(nums, queries);
        System.out.println(Arrays.toString(ans));

    }
}
