import java.util.Arrays;

public class min {
    
    // partioning of a subarray sum difference is minimum variation of 01Knapshack
    public static int minPartion(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int a : arr) {
            sum += a;
        }

        int w = sum/2;

        int[][] dp = new int[n+1][w+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<w+1; j++) { 
                if(arr[i-1] <= j) { // valid
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j - arr[i-1]], dp[i-1][j]);
                } else { // invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }
    // OR previous Q. also solve with same logic 1D dp array 
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int e : nums) sum += e;

        int w = sum / 2;
        int[] dp = new int[w + 1];

        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }

        int sum1 = dp[w];
        int sum2 = sum - sum1;
        if(sum1 == sum2) {
            return true;
        }
        return false;
    }

    // Minimum Array Jumps
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1]  = 0;

        for(int i=n-1; i>=0; i--) {
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1; j<=i+steps && j<n; j++) {
                if(dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if(ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        return dp[0];
    }
    // check reached at end or not
    public static boolean canJump(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(i>index) return false;
            index=Math.max(index,i+nums[i]);
        }
        return true;
    }    

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(minPartion(arr));
        System.out.println(canPartition(arr));

        System.out.println(canJump(arr));
        System.out.println(minJumps(arr));
    }
} 
