public class costClimbingStairs {
    // 746 Min cost to climbing stairs
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        // int ans = Math.min(solveTD(cost, n-1, dp), solveTD(cost, n-2, dp));
        // return ans;
        return solveBU(cost, n, dp);
    }
    // Bottum Up ->
    public static int solveBU(int[] cost, int n, int[] dp){
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    // Top Down ->
    public int solveTD(int[] cost, int n, int[] dp) {
        if (n==0 || n==1) return cost[n];
        if(dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(solveTD(cost, n-1, dp), solveTD(cost, n-2, dp));
        return dp[n];
    }

    // no. of ways to climb stairs 
    //recursive approach - O(2^n)
    public static int countWays(int n) { 
        if(n == 0){
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }
    //Memoization approach - O(n)
    public static int countWaysMemo(int n, int[] dp) { 
        if(n == 0){
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        if(dp[n] != 0) return dp[n];
        dp[n] = countWaysMemo(n-1, dp) + countWaysMemo(n-2, dp);
        return dp[n];
    }
    // tabulation approach - O(n)
    public static int countWaysTab(int n, int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("min cost to climb stairs: "+minCostClimbingStairs(cost));
        
        int n = 5;
        int[] dp = new int[n+1];
        System.out.println("no. of ways to climb stairs: " + countWaysMemo(n, dp));
        System.out.println(countWaysTab(n, dp));
    }
}
