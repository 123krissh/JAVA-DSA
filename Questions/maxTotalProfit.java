public class maxTotalProfit {
    
    public static int maximizeDriverEarnings(int[] rideProfits, int requestCount, int x, int y, int z){
        // Consider only the first `requestCount` rides (safe if requestCount > array length)
        int n = Math.min(requestCount, rideProfits.length);

        // dp[i][a][b][c] = max profit starting at index i (0..n),
        // with at most a singles, b pairs, c triples remaining.
        int[][][][] dp = new int[n + 1][x + 1][y + 1][z + 1];

        // Bottom-up: fill from i = n-1 down to 0
        for (int i = n - 1; i >= 0; i--) {
            for (int a = 0; a <= x; a++) {
                for (int b = 0; b <= y; b++) {
                    for (int c = 0; c <= z; c++) {

                        // Option 1: skip this ride
                        int best = dp[i + 1][a][b][c];

                        // Option 2: take single at i
                        if (a > 0) {
                            best = Math.max(best, rideProfits[i] + dp[i + 1][a - 1][b][c]);
                        }

                        // Option 3: take pair (i, i+1)
                        if (b > 0 && i + 1 < n) {
                            best = Math.max(best, rideProfits[i] + rideProfits[i + 1] + dp[i + 2][a][b - 1][c]);
                        }

                        // Option 4: take triple (i, i+1, i+2)
                        if (c > 0 && i + 2 < n) {
                            best = Math.max(best, rideProfits[i] + rideProfits[i + 1] + rideProfits[i + 2] + dp[i + 3][a][b][c - 1]);
                        }

                        dp[i][a][b][c] = best;
                    }
                }
            }
        }

        return dp[0][x][y][z];
    }

    public static void main(String[] args) {
        int[] rideProfits = {3,7,-2,5,4,6};
        int requestCount = 6;
        int x = 1, y = 1, z = 1;
        System.out.println(maximizeDriverEarnings(rideProfits, requestCount, x, y, z));
    }
}
