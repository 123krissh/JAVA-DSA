package Patterns;

import java.util.Scanner;

public class flipedTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){ 
            for(int j=1;j<=n+1-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }    
    }
     
}
