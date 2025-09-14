import java.lang.reflect.Array;
import java.util.ArrayList;

public class IthBit {
    public static int getIthBit(int n, int i) {
        // Create a mask with the ith bit set
        int mask = 1 << i;
        // Use bitwise AND to isolate the ith bit
        return (n & mask) != 0 ? 1 : 0; // Return 1 if the ith bit is set, otherwise return 0
    }

    public static int setIthBit(int n, int i) {
        // Create a mask with the ith bit set
        int mask = 1 << i;
        // Use bitwise OR to set the ith bit
        n |= mask;
        return n; // Return the modified number with the ith bit set
    }   

    public static int clearIthBit(int n, int i) {
        // Create a mask with the ith bit cleared
        int mask = ~(1 << i);
        // Use bitwise AND to clear the ith bit
        n &= mask;
        return n; // Return the modified number with the ith bit cleared
    }

    public static int updateIthBit(int n, int i, int newbit) {
        // if (newbit == 0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n, i); // Clear the ith bit first
        int Bit = newbit << i; // Shift the new bit to the ith position
        n |= Bit; // Set the ith bit to the new bit value
        return n; // Return the modified number with the ith bit updated
    }

    public static int clearLastIthBit(int n, int i) {
        // Create a mask with the last ith bit cleared
        int mask = ((-1)<<i);
        // Use bitwise AND to clear the last ith bits
        return n & mask; // Return the modified number with the last ith bits cleared
    }

    public static int clearIBits(int n, int i, int j) {
        int a = (-1 << j+1);
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask; 
    }

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

    public static void  powerSet(int[] nums){
        int totalSubsets = 1 << nums.length; // 2^n subsets
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i < totalSubsets; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // Check if jth bit in i is set
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            powerSet.add(subset);
        }
        System.out.println(powerSet);
    }

     public static void main(String[] args) {
        System.out.println(getIthBit(5, 0)); 
        System.out.println(setIthBit(10, 2)); 
        System.out.println(clearIthBit(10, 1)); 
        System.out.println(updateIthBit(10, 2, 1));
        System.out.println(clearLastIthBit(10, 2));
        System.out.println(clearIBits(10, 2, 4));

        oddEven(10); 
        oddEven(0); 
        oddEven(-3); 
        powerSet(new int[]{1, 2, 3});
    }
}
