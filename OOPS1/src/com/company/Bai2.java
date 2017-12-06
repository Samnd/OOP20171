package com.company;

public class Bai2 {

    public static void main(String[] args) {
        int n = 15;
        for (int i = 1; i <= (n - 1)/2 ; i++) {
            for (int j = 1;j<=n; j++) {
                if((j >= (n + 1)/2 - i +1)&&(j <=(n + 1)/2 + i -1)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("\n\n\nNguyễn Văn Cường - 20155218");
    }
}
