package Patterns;

import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){ 
            for(int j=1;j<=i;j++){

                // star triangle
                 System.out.print("* ");

                // no. triangle
                // System.out.print(j+" ");

                // char. triangle
                // System.out.print((char)(j+64)+" ");

                // number-char. triangle
                // if (i%2!=0) {
                //     System.out.print(j+" ");
                // } else {
                //     System.out.print((char)(j+64)+" ");
                // } 


                 // 0-1 triangle
                // if (i%2!=0) {
                //     if (j%2!=0) {
                //         System.out.print(1+" ");
                //     } else System.out.print(0+" ");
                // } else{
                //     if (j%2==0) {
                //         System.out.print(1+" ");
                //     } else System.out.print(0+" ");
                // }
                 
                // if (i%2==1 && j%2==1 || i%2==0 && j%2==0) {
                //     System.out.print(1+" ");
                // } else System.out.print(0+" ");

                // if ((i+j)%2==0) {
                //     System.out.print(1+" ");
                // } else System.out.print(0+" ");

                
            }
            
            System.out.println();
        }

        // triangle of continuous number

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter n");
        // int n = sc.nextInt();
        // int a = 1;
        // for(int i = 1;i<=n;i++){  
        //     for(int j=1;j<=i;j++){
        //         System.out.print(a+" ");
        //         a++;
        //     }
        //     System.out.println();
        // }


    } 
}
 
