public class FastExponentiation {
    public static int FastExpo(int a, int n) {
        int ans = 1;
        while(n > 0) {
            if((n & 1) == 1) {
                ans *= a;
            }
            a *= a;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(FastExpo(3, 3));

        //  add 1 to an integer using bit manipulation
        // -~x is equivalent to x + 1
        int x = 6;
        System.out.println(x + " + " + 1 + " = " + -~x);
        x=-4;
        System.out.println(x + " + " + 1 + " = " + -~x);
        x=0;
        System.out.println(x + " + " + 1 + " = " + -~x);
    }
}
 