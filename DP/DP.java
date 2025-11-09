public class DP {
    // DP -> Two ways of solving problems:-
    // 1. memoization approach (top-down) 2. tabulation approach (bottom-up)
    // 7 important Qs or concepts on DP
    // 1. Fibonacci number, 2. 0-1 Kanpsack, 3. Unbounded Kanpsack
    // 4. Longest Common Subsequence (Edit Distance(Levensthein Algorithm)), 5. kadane's Algorithm, 6. Catalan Number, 7. DP on grids(2D array)
    
    // memoization approach (top-down)
    public static int fib(int n, int f[]) { //O(n)
        if (n == 1 || n == 0) return n;

        if(f[n] != 0) { // check if fib(n) is already calculated
            return f[n];
        }
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    // tabulation approach (bottom-up)
    public static int fibTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n + 1];
        System.out.println(fib(n, f));
    }
}
