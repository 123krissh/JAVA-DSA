import java.util.Scanner;
public class countDigits {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System .in);
        // int n = sc.nextInt();
        // int count = 0;
        // if(n==0) count++;
        // while(n!=0){
        //     n/=10;
        //     count++;
        // }
        // System.out.println(count);


       // sum of digits
    //    Scanner sc = new Scanner(System .in);
    //    int n = sc.nextInt();
    //    int sum = 0;
    //    while (n!=0) {
    //     int lastDigit = n%10;
    //     sum += lastDigit;
    //     n/=10;
    //    }
    //    System.out.println(sum);


    // reverse of a digit
    Scanner sc = new Scanner(System .in);
    int n = sc.nextInt();
    int rev = 0;
    while (n!=0) {
        int lastDigit = n%10;
        rev*=10;
        rev += lastDigit;
        n/=10;
    }
    System.out.println(rev);


    }
}