import java.util.Arrays;

public class MCM {
    
    public static int MCMRec(int[] arr, int i, int j) {
        if(i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int cost1 = MCMRec(arr, i, k); // Ai.....Ak => arr[i-1] X arr[k]
            int cost2 = MCMRec(arr, k+1, j); // Ak+1....Aj => arr[k] X arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    } 

    // Memoizaton - O(n^2)
    public static int mcmMemo(int[] arr, int i, int j, int[][] dp) {
        if(i == j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int cost1 = mcmMemo(arr, i, k, dp); // Ai.....Ak => arr[i-1] X arr[k]
            int cost2 = mcmMemo(arr, k+1, j, dp); // Ak+1....Aj => arr[k] X arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    } 

    // Tabulation - O(n^3)
    public static int mcmTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // intialization
        for(int i=0; i<n; i++) {
            dp[i][i] = 0;
        }

        // bottom-up
        for(int len=2; len<=n-1; len++) {
            for(int i=1; i<=n-len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }
    // | 0 0 0 0  0  |    
    // | 0 0 6 18 30 |
    // | 0 0 0 24 48 |
    // | 0 0 0 0  36 |
    // | 0 0 0 0  0  |

    public static void print(int[][] dp) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3}; // 30
        int n = arr.length;
        System.out.println(MCMRec(arr, 1, n-1));

        int[][] dp = new int[n][n];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(mcmMemo(arr, 1, n-1, dp));
        print(dp);

        System.out.println(mcmTab(arr));
    }
}
