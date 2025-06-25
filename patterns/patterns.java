package Learning.patterns;

import java.util.Scanner;

public class patterns {

    public static void voidDiamond(int d){
        System.out.println("VoidDiamond");
        int k = d/2;
        int l = 0;
        for(int i = 0; i<d; i++) System.out.print("* ");
        System.out.println();
        for (int i = 1; i < d-1; i++){
            for (int j = 0; j<d; j++){
                if (j == k-l || j == k+l){
                    System.out.print("  ");
                }
                else{
                    System.out.print("* ");
                }
            }
            if (i<k){
                l++;
            }
            else{
                l--;
            }
            System.out.println();
        }
        for(int i = 0; i<d; i++) System.out.print("* ");
        System.out.println();
    }

    public static void X(int d){
        System.out.println("X");
        for (int i = 0; i<d;i++){
            for (int j = 0; j<d; j++){
                if (j == i || j == d-i-1){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void sidePyramid(int d){
        System.out.println("Side pyramid");
        for (int i = 0; i<d; i++){
            for (int j = 0; j<i+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = d; i>0; i--){
            for (int j = 0; j<i+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void voidBox(int d) {
        System.out.println("voidBox");
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                if (i == 0 || i == d - 1 || j == 0 || j == d - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void rhombus(int d){
        System.out.println("rhombus");
        for (int i = 0; i < d; i++) {
            for (int j = 0; j<d-i;j++){
                System.out.print("  ");
            }
            for (int j = 0; j < d; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hourClock(int d) {
        System.out.println("Hour clock");
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = d - i + 1; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= d - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void triangle(int s){
        int total = (s*2-1);
        for (int i = 1; i<=s; i++){
            for (int j = 1; j<=total; j++){
                if (i+j <= s) System.out.print("  ");
                else if (j - i >= s) {
                    System.out.print("  ");
                } else System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       triangle(5);
    }
}
