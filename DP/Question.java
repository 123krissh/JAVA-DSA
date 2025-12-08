public class Question {
    
    public static int countBST(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            // C1 -> BST (i node) -> dp[i]
            for(int j=0; j<i; j++) {
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    public static int mountainRanges(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++) {
            // i pairs -> mountain ranges -> Ci
            for(int j=0; j<i; j++) {
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside; // ci = cj*ci-j-1
            }
        } 
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countBST(n));
        System.out.println(mountainRanges(n));
    }
} 
