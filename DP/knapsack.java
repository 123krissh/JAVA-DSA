public class knapsack {
    // Recursive approach - O(2^n)
    public static int KnapsackR(int[] wt, int[] val, int w, int n ) {
        if(w == 0 || n == 0){
            return 0;
        }
        if(wt[n-1] <= w){
            int include = val[n-1] + KnapsackR(wt, val, w-wt[n-1], n-1);
            int exclude = KnapsackR(wt, val, w, n-1);
            return Math.max(include, exclude);
        } else {
            return KnapsackR(wt, val, w, n-1);
        }
    }
    // Memoization approach - O(n*w)
    public static int KnapsackMemo(int[] wt, int[] val, int w, int n, int[][] dp) {
        if(w == 0 || n == 0){
            return 0;
        }
        if(dp[n][w] != -1) {
            return dp[n][w];
        }
        if(wt[n-1] <= w){
            int include = val[n-1] + KnapsackMemo(wt, val, w-wt[n-1], n-1, dp);
            int exclude = KnapsackMemo(wt, val, w, n-1, dp);
            dp[n][w] =  Math.max(include, exclude);
            return dp[n][w];
        } else {
            dp[n][w] = KnapsackMemo(wt, val, w, n-1, dp);
            return dp[n][w];
        }
    }
    // Tabulation approach - O(n*w)
    public static int KnapsackTab(int[] wt, int[] val, int w){
        int n = val.length;
        int[][] dp = new int[n+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for (int j=1; j<=w; j++) {
                int v= val[i-1]; // ith item val
                int W = wt[i-1]; //ith item wt
                if(W <= j){ // valid case
                    int include = v + dp[i-1][j-W];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i-1][j]; //invalide and exclude case
                }
            }
        }
        return dp[n][w];
    }

    public static void print (int dp[][]){
        for (int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] wt = {2,5,1,3,4};
        int[] val = {15,14,10,45,30};
        int w = 7;
        int dp[][] = new int[val.length+1][w+1];
        for (int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(KnapsackR(wt, val, w, wt.length));
        System.out.println(KnapsackMemo(wt, val, w, wt.length, dp));
        System.out.println(KnapsackTab(wt, val, w));
        print(dp);
        
    }
}
