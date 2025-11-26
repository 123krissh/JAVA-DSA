import java.util.Arrays;

public class ways {
    // grid ways with sum divisible by k
    public static int gridWays(int[][] grid, int i, int j, int rem, int k, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        //  base case
        if (i == n-1 && j == m-1 && rem == 0) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        if(dp[i][j][rem] != -1) {
            return dp[i][j][rem];
        }
        long count = 0;
        if(i+1 < n ){
            count += gridWays(grid, i+1, j, (rem + grid[i+1][j]) % k, k, dp);
        }
        if(j+1 < m) {
            count += gridWays(grid, i, j+1, (rem + grid[i][j+1]) % k, k, dp);
        }
        dp[i][j][rem] = (int)(count % 1000000007);
        return dp[i][j][rem];
    }

    // Coin change (similor to unbounded knapsack)
    public static int coinChangeWaysTab(int[] coin, int sum){
        int n = coin.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++){
            for (int j=1; j<=sum; j++) {
                if(coin[i-1] <= j){ // valid case
                    int include = dp[i][j-coin[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = include + exclude;
                } else {
                    dp[i][j] = dp[i-1][j]; //invalide and exclude case
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[][] grid = {{5,2,4},{3,0,5},{0,7,2}};
        int k = 3;

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k];
        for(int[][] d1 : dp) {
            for(int[] d2 : d1){
                Arrays.fill(d2, -1);
            }
        }
    
        System.out.println(gridWays(grid, 0, 0, grid[0][0]%k, k, dp));

        int[] coin = {2,3,5,6};
        int sum = 10;
        System.out.println(coinChangeWaysTab(coin, sum));
    }
}
