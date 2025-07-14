package Learning.GroundZero;

import java.util.HashMap;
import java.util.Map;

public class testOverFlow {
    public static void main(String[] args) {
        romanToInt("LVIII");
    }

    static void romanToInt(String s) {
        // embed logic into switch case for faster execution
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("L", 50);
        map.put("X", 10);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        int l = s.length();
        int num = 0;
        for(int i = 0; i< l; i++){
            int temp;
            if (i+1 < l){
                temp = map.getOrDefault(s.substring(i, i+2), -1);
            }
            else temp = -1;
            if(temp != -1){
                num += temp;
                i++;
            }
            else {
                num += map.get(s.substring(i, i+ 1));
            }
        }
        System.out.println(num);
    }

    static void numPalindrome(int x){
        if(x<0) return;
        if(x == 0) return;
        long reverse = 0;
        int holder = x;
        while(x > 0){
            int temp = x%10;
            reverse = reverse * 10 + temp;
            x = x/10;
        }
        System.out.println( holder == reverse );
    }
}
