// Levenshtein Algorithm Assignment

// Algorithm Explanation:

// The Levenshtein distance algorithm measures the minimum number of edits (insertions, deletions, substitutions) needed to convert one string into another. It builds a matrix where each cell `[i][j]` represents the minimum edit distance between the first `i` characters of the first string and the first `j` characters of the second string.

// Examples:

// 1. Levenshtein vs Lavenstaein: 3 edits needed.
// 2. TryHackMe vs TriHackingMe: 4 edits needed.
// 3. Optimization vs Progressive: 9 edits needed.
// 4. This is easy vs This is easy: 0 edits needed.

public class LevenshteinAlgo {
    public static int EditDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + cost);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println("Levenshtein vs Lavenstaein: " + EditDistance("Levenshtein", "Lavenstaein"));
        System.out.println("TryHackMe vs TriHackingMe: " + EditDistance("TryHackMe", "TriHackingMe"));
        System.out.println("Optimization vs Progressive: " + EditDistance("Optimization", "Progressive"));
        System.out.println("This is easy vs This is easy: " + EditDistance("This is easy", "This is easy"));
    }
}
