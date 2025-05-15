public class LongestSubarray {
    public static int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  // Handle edge case for empty array
        }

        int maxLen = 1;
        int increasingLen = 1;
        int decreasingLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasingLen++;  // Continue the increasing subarray
                System.out.println(increasingLen);
                decreasingLen = 1;  // Reset the decreasing subarray length
            } else if (nums[i] < nums[i - 1]) {
                decreasingLen++;  // Continue the decreasing subarray
                increasingLen = 1;  // Reset the increasing subarray length
            } else {
                increasingLen = 1;  // Reset both lengths if the current element equals the previous one
                decreasingLen = 1;
            }

            // Update the maximum length found
            maxLen = Math.max(maxLen, Math.max(increasingLen, decreasingLen));
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        System.out.println("Length of longest subarray: " + longestSubarray(nums));
    }
}
