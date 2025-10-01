public class costClimbingStairs {
    // 746
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
    // public int solveTD(int[] cost, int n, int[] dp) {
    //     if (n==0 || n==1) return cost[n];
    //     if(dp[n] != 0) return dp[n];
    //     dp[n] = cost[n] + Math.min(solveTD(cost, n-1, dp), solveTD(cost, n-2, dp));
    //     return dp[n];
    // }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("min cost to climb stairs: "+minCostClimbingStairs(cost));
    }
}
