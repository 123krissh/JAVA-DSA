// print all binary strings of size n without consecutive 1s (Paytm)

public class binaryString {
    public static void printBinaryStrings(int n, int lastPlace, String str){
        // Base case
        if(n==0){
            System.out.println(str);
            return;
        }

        // Recursive case 
        // if(lastPlace == 0) {
        //     // sit 0 on chair n
        //     printBinaryStrings(n-1, 0, str.append("0"));
        //     // sit 1 on chair n
        //     printBinaryStrings(n-1, 1, str.append("1"));
        // } else {
        //     printBinaryStrings(n-1, 0, str.append("0"));
        // }

        printBinaryStrings(n-1, 0, str+"0");
        if(lastPlace == 0) {
            printBinaryStrings(n-1, 1, str+"1");
        }
    }

    public static void main(String[] args) {
        printBinaryStrings(3, 0, "");
    }
}
