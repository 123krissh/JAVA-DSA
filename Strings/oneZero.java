public class oneZero {
    
    public static int findMaxForm(String[] strs, int m, int n) {
        Integer DP[][][] = new Integer[strs.length + 1][m+1][n+1];
        return helper(strs, 0, m, n, DP);
    }

    public static int helper(String[] strs, int i, int m, int n, Integer DP[][][]){
        if(i >= strs.length){
            return 0;
        }
        if(DP[i][m][n] != null){
            return DP[i][m][n];
        }
        String s = strs[i];
        int one = 0, zero = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') one++;
            if(c == '0') zero++;
        }
        int picked = 0;
        if(one <= n && zero <= m) {
            picked = 1 + helper(strs, i+1, m-zero, n-one, DP);
        }
        int notPicked = helper(strs, i+1, m, n, DP);
        int result = Math.max(picked, notPicked);
        DP[i][m][n] = result;
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs,m,n));
    }
}
