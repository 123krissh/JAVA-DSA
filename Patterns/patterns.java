package Patterns;

import java.util.Scanner;

public class patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){ 
            for(int j=1;j<=n;j++){
                System.out.print(j+" ");

                // same no. print in same rwo
                // System.out.print(i+" ");

                // print pattern of alphabet
                // System.out.print((char)(j+64)+" ");

                // System.out.print((char)(i+64)+" ");
            }
            System.out.println();
        }

    }
}
