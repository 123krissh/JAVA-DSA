import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class triangle {
    
    // Top Down DP approch -->
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n]; 
        return solve(triangle, 0, 0, dp);
    }
     public static int solve(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {
        int n = triangle.size();
        if (row == n - 1) {
            return dp[row][col] = triangle.get(row).get(col);
        }

        if (dp[row][col] != null)
            return dp[row][col];

        int down = triangle.get(row).get(col) + solve(triangle, row + 1, col, dp);
        int diag = triangle.get(row).get(col) + solve(triangle, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(down, diag);     
    }
    
    // Bottom Up DP approch --->
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n = triangle.size();
       
    //     int[] dp = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         dp[i] = triangle.get(n - 1).get(i);
    //     }

    //     for (int row = n - 2; row >= 0; row--) {
    //         for (int col = 0; col <= row; col++) {
    //             dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
    //         }
    //     }
    //     return dp[0];
    // }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }
}
