public class GCD {
    public static int gcdOfOddEvenSums(int n) {
        int sumOdd = n*n;
        int sumEven = n*(n+1);
        int gcd = gcd(sumOdd, sumEven);
        return gcd;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int gcd = gcd(5, 75);
        int gcd2 = gcdOfOddEvenSums(4);

        System.out.println("GCD: " + gcd);
        System.out.println("GCD of odd & even no.'s sum: "+ gcd2);
    }
}
