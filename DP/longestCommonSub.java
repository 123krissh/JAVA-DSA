public class longestCommonSub {
    // top down Memoization - O(n*m)
    public static int lcs(String str1, String str2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return lcs(str1, str2, n-1, m-1) + 1;
        } else {
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        } 
    }

    // bottom up Tabulation - O(n*m)
    public static int lcsTab(String str1, String str2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    // Longest palindromic subString
    public static String longestPalindrome(String s) {
        int max = 0, start = 0, end = 0;
        Boolean[][] dp = new Boolean[1001][1001];
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                if(isPalindrom(s, i, j, dp)){
                    if((j-i+1) > max) {
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
    public static boolean isPalindrom(String s, int i, int j, Boolean[][] dp) {
        if(i >= j) {
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindrom(s, i+1, j-1, dp);
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "abcfed";
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsTab(str1, str2, str1.length(), str2.length()));
        System.out.println(longestPalindrome("ababcaca"));
    }
}
