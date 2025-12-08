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

    public static int CatalanTab(int n) {
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

    public static void main(String[] args) {
        int n = 5;
        System.out.println(CatalanRec(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(CatalanMemo(n, dp));
        System.out.println(CatalanTab(n));
    }
}
