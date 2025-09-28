public class gridWays {
    
    public static int gridWays(int i, int j, int n, int m){ //O(2^(n+m))
        //  base case
        if (i == n-1 && j == m-1) {
            return 1;
        } else if (i == n || j == n) {
            return 0;
        }

        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1+w2;
    }
    // if we solve this problem in linear time then use permutation method, 
    // find permutation of total ways as a D(down) - n-1 D & R(right) - m-1 R
    // so total charactors = n-1 + m-1
    // repeating - (n-1)D & (m-1)R
    // formula - (n-1+m-1)! / (n-1)!(m-1)!
    // It solve in O(n+m) time complexity.

    // find permutations of string--->
    public static void findPermutation(String str, String ans){
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }
    }

    public static void findSubsets(String str, String ans, int i){
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println(null);
            } else {
                System.out.println(ans);
            }
            return;
        }
        // yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        // no choice
        findSubsets(str, ans, i+1);
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println("total grid ways from top left to bottom right: " + gridWays(0, 0, n, m));

        String str = "abc";
        findPermutation(str, "");
        findSubsets(str, "", 0);
    }
}
