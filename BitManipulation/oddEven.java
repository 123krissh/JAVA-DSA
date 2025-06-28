public class oddEven {
    public static void oddEven(int n) {
        int mask = 1; // Mask to check the least significant bit
        // If the least significant bit is 1, then the number is odd
        // If the least significant bit is 0, then the number is even
        if ((n & mask) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
    public static void main(String[] args) {
        oddEven(5);
        oddEven(10); 
        oddEven(0); 
        oddEven(-3); 
    }

}
