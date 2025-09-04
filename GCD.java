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

    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == divisor) return 1;
        boolean sign = true;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            sign = false;
        }
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int ans = 0;
        while(n >= d){
            int cnt = 0;
            while(n >= (d << (cnt+1))){
                cnt++;
            }
            ans += (1 << cnt);
            n -= (d << cnt);
        }
        return sign ? ans : -ans;
    }

    // Happy Number ----->
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = calSquare(slow);
            fast = calSquare(calSquare(fast));
        } while(slow != fast);

        if(slow == 1){
            return true;
        } else {
            return false;
        }
    }
    public static int calSquare(int num){
       int sq = 0;
        while(num > 0){
            int rem = num % 10;
            sq += rem * rem;
            num /= 10;
        }
        return sq;
    }

    public static void main(String[] args) {
        int gcd = gcd(5, 75);
        int gcd2 = gcdOfOddEvenSums(4);

        System.out.println("GCD: " + gcd);
        System.out.println("GCD of odd & even no.'s sum: "+ gcd2);

        int div = divide(-2147483648, -1);
        System.out.println("Division: " + div);

        boolean happy = isHappy(19);
        System.out.println("Number is happy: " + happy);
    }
}
