public class countSetBit {
    public static int countSetBits(long n){
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1; // Right shift n by 1 to check the next bit
        }
        return count;
    }

    // java built in method fot count set bits : datatype.bitCount(n) -> long.bitCount(n)

    public static int makeTheIntegerZero(int num1, int num2) {
        for(int k=0; k<=60; k++){
            long x = (long) num1 - (long) k * num2;
            
            if(x<k) continue;
            int bits = countSetBits(x);
            if(bits<=k && x>=k) return k;
        }
        return -1;
    } 

    public static void main (String[] args) {
        System.out.println(countSetBits(10));
        System.out.println(makeTheIntegerZero(10, 2));
    }
}
