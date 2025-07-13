package Learning.GroundZero;

import java.util.Scanner;

public class hackerrank {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // String s = scan.nextLine();
        System.out.println(myAtoi("-123143"));
    }

    static int myAtoi(String s){
        s = s.trim();
        int length = s.length();
        if (length == 0){
            return 0;
        }
        char start = s.charAt(0);
        if(length == 1 && (start == '+' || start == '-')) return 0;
        if (Character.isAlphabetic(start)) return 0;
        StringBuilder num = new StringBuilder();
        for (int i = 1; i< length; i++){
            if (
                    s.charAt(i) == '-' ||
                    s.charAt(i) == '+' ||
                    Character.isAlphabetic(s.charAt(i))
            ) break;
            else {
                num.append(s.charAt(i));
            }
        }
        if(num.length() == 1 && (num.charAt(0) == '+' || num.charAt(0) == '-')) return 0;
        return Integer.parseInt(num.insert(0,start).toString());
    }
}
