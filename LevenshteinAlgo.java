// Levenshtein Algorithm Assignment

// Algorithm Explanation:

// The Levenshtein distance algorithm measures the minimum number of edits (insertions, deletions, Replace) needed to convert one string into another.
// It builds a matrix where each cell `dp[i][j]` represents the minimum edit distance between the first `i` characters of the first string and the first `j` characters of the second string.

// Examples:

// 1. Levenshtein vs Lavenstaein: 3 edits needed.
// 2. TryHackMe vs TriHackingMe: 4 edits needed.
// 3. Optimization vs Progressive: 10 edits needed.
// 4. This is easy vs This is easy: 0 edits needed.

public class LevenshteinAlgo {
    public static int EditDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i<=m; i++) dp[i][0] = i;
        for (int j = 0; j<=n; j++) dp[0][j] = j;

        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println("Levenshtein vs Lavenstaein: " + EditDistance("Levenshtein", "Lavenstaein"));
        System.out.println("TryHackMe vs TriHackingMe: " + EditDistance("TryHackMe", "TriHackingMe"));
        System.out.println("Optimization vs Progressive: " + EditDistance("optimization", "progressive"));
        System.out.println("This is easy vs This is easy: " + EditDistance("This is easy", "This is easy"));
    }
}