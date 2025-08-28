import java.util.*;
public class ThreeSum {
    // brute force approch O(n^3) ----->
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        if(!ans.contains(triplet)){
                            ans.add(triplet);
                        }
                    }
                }
            }
        }
        return ans;
    }

    // optimal approch O(n^2) ----->
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                } else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSumOptimal(nums);
        System.out.println(ans);
    }
}
