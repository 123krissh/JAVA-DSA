import java.util.Arrays;

public class longestCommonSub {
    // top down Memoization - O(n*m)
    public static int lcs(String str1, String str2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return 0;
        }
        if(dp[n][m] != -1) return dp[n][m];

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = lcs(str1, str2, n-1, m-1, dp) + 1;
        } else {
            int ans1 = lcs(str1, str2, n-1, m, dp);
            int ans2 = lcs(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
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

    // length of longest common Substring
    public static int lcSubString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        // initialize dp array
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        // bottom up
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }  
            }
        }
        return ans;
    }

    // longest increasing subsequence
    public static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // WildCard Matching pattern
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < m+1; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            } // else false which is by default false in java boolean array
        }

        // Bottom up
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
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
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int[] d1 : dp) {
            for (int d2 : d1) {
                Arrays.fill(d1, -1);
            }
        }
        System.out.println(lcs(str1, str2, str1.length(), str2.length(), dp));
        System.out.println(lcsTab(str1, str2, str1.length(), str2.length()));
        System.out.println(longestPalindrome("ababcaca"));
        System.out.println(lcSubString(str1, str2));

        int arr[] = {50, 3, 1, 1, 1, 40, 80};
        System.out.println(lis(arr));

        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(isMatch(s, p));
    }
}
