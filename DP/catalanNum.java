import java.util.*;

public class catalanNum {
    // cn = c0*cn-1 + c1*cn-2 + ------ + cn-1*c0;
    // c3 = c0*c2 + c1*c1 + c2*c0;
    public static int CatalanRec(int n) {
        if(n == 0 || n == 1) return 1;
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += CatalanRec(i) * CatalanRec(n-i-1);
        }
        return ans;
    }

    public static int CatalanMemo(int n, int[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += CatalanMemo(i, dp) * CatalanMemo(n-i-1, dp);
        }
        dp[n] = ans;
        return dp[n];
    }

    public static int CatalanTab(int n) { // O(n^2)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int ans = 0;
            for(int j=0; j<i; j++) {
                ans += dp[j] * dp[i-j-1];
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    // catalan variations: 
    // count BST with n nodes
    // count valid parentheses with n pairs
    // count mountain ranges with n upstrokes

    // countBST
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
    // mountain Ranges
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
        int n = 5;
        System.out.println(CatalanRec(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(CatalanMemo(n, dp));
        System.out.println(CatalanTab(n));

        System.out.println(countBST(n));
        System.out.println(mountainRanges(n));
    }
}
