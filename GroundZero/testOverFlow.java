package Learning.GroundZero;

public class testOverFlow {
    public static void main(String[] args) {
        numPalindrome(121);
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
