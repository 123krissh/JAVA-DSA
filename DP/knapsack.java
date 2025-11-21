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
        print(dp);
        return dp[n][w];
    }
    // unbounded knapsack 
    public static int UnboundedKnapsackTab(int[] wt, int[] val, int w){
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
                    int include = v + dp[i][j-W];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i-1][j]; //invalide and exclude case
                }
            }
        }
        print(dp);
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

    // Target sum Subset Exist or not - O(n*sum)
    public static boolean targetSumSubset(int[] arr, int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // 1st row is contains false value which is already by default false in java when initialize boolean array.
        // and 1st col contain true value.
        for(int i=0; i<n+1; i++) {
            dp[i][0] = true;
        }
        // i=items & j = target sum
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                int v = arr[i-1];
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                } else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        printT(dp);
        return dp[n][sum];
    }
    public static void printT (boolean dp[][]){
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
        print(dp);
        System.out.println("tabulation DP array: ");
        System.out.println(KnapsackTab(wt, val, w));
        System.out.println(UnboundedKnapsackTab(wt, val, w));
        
        int[] arr = {4,2,7,1,3};
        int sum = 10;
        System.out.println(targetSumSubset(arr, sum));
    }
}
