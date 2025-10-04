import java.util.ArrayList;
import java.util.List;

public class permutations {
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, result, 0);
        return result;
    }

    public static void permutation(int[] nums, List<List<Integer>> result, int start){
        if(start == nums.length){
           List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, start, i);
            permutation(nums, result, start+1);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }

// next permutation ---->
    // Pseudo logic:
    // 1. Start from the right, find first decreasing pair nums[i] < nums[i+1]
    // 2. If found:
    //    - Find smallest number > nums[i] to the right
    //    - Swap them
    // 3. Reverse the subarray nums[i+1..end]
    // 4. Done

    public static void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>pivot; i--){
            if(nums[i] > nums[pivot]){
                swap(nums, i, pivot);
                break;
            }
        }

        reverse(nums, pivot+1, n-1);
    }
    public static void reverse(int[] nums, int i, int j){
        while(i<=j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
        nextPermutation(nums);
        for(int n: nums){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
