import java.util.HashMap;

public class singleNumber {
    
     public static int singleNumber(int[] nums) {
        int index = 0;
        for( int i=0; i<=nums.length-1; i++) {
            index = index ^ nums[i];
        }
        return index;
    }

    // optimized approach ---->
    public static int singleNumber2(int[] nums2) {
        int ones = 0, twos = 0;
        for(int num: nums2){
            ones = (ones ^ num) & ~ twos;
            twos = (twos ^ num) & ~ ones;
        }
        return ones;
    }
    // brute force approach ---->
    // public int singleNumber2(int[] nums) {
    //     HashMap<Integer, Integer> freq = new HashMap<>();
    //     for(int i=0; i<nums.length; i++){
    //         freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
    //     }
    //     for(int key: freq.keySet()){
    //         if (freq.get(key) == 1) {
    //             return key;
    //         }
    //     }
    //     return -1;
    // }

    public static int[] singleNumber3(int[] nums3){
        long xorr = 0;
        for(int num: nums3){
            xorr = xorr ^ num;
        }
        long rightmostSetBit = (xorr & (xorr -1)) ^ xorr;
        int b1 = 0, b2 = 0;
        for(int num: nums3){
            if((num & rightmostSetBit) != 0){
                b1 = b1 ^ num;
            } else {
                b2 = b2 ^ num;
            }
        }
        return new int[]{b1, b2};
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
        int[] nums2 = {2,2,4,2,4,4,3};
        System.out.println(singleNumber2(nums2));
        int[] nums3 = {1,2,1,3,2,5};
        int[] result = singleNumber3(nums3);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }
}
