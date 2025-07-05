public class tilingProblem {
    
    public static int tilingProblem(int n) {
        // Base cases
        if(n == 0 || n == 1) {
            return 1;
        }
        // Recursive case: place a vertical tile or two horizontal tiles
        int fnm1 = tilingProblem(n-1);
        int fnm2 = tilingProblem(n-2);
        return fnm1 + fnm2;
    }

    public static void main(String[] args) {
        System.out.println("Number of ways to tile a 2xN board: " + tilingProblem(4));
    }
}
