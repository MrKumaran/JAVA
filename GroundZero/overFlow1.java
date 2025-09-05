package Learning.GroundZero;

public class overFlow1 {
    public static void main(String[] args) {
//        int a = 45;
//        perfectSquare(a);
        int a = 10;
        Integer b = 10;
        System.out.println(a==b);
        System.out.println(b.equals(a));
    }

    static void pattern3(int n){
        int in = n*2 - 1;
        for (int i = 0; i<n; i++){
            int p = i;
            for (int j = 0; j<in; j++){
                if (j >=in/2-i && j<= in/2 + i){
                    System.out.print(p);
                    if (j >= in/2){
                        p++;
                    }
                    else p--;
                }
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        // 1
        // 11
        // 21
        // 1211
        // 111221
        int i = 1;
        System.out.println(1);
        String s = "1";
        while (i<n){
            String newS = "";
            int count = 1;
            char a = s.charAt(0);
            for (int j = 1; j<s.length(); j++){
                if (s.charAt(j) != s.charAt(j-1)){
                    System.out.print(count + "" + a);
                    newS += count + "" + a ;
                    a = s.charAt(j);
                    count = 1;
                }
                else {
                    count++;
                }
            }
            System.out.print(count + "" + a);
            newS += count + "" + a ;
            s = newS;
            System.out.println();
            i++;
        }
    }

    static void pattern(int n){
        for (int i = 0; i< n; i++){
            System.out.print("*");
        }
        System.out.println();
        int mid = n/2;
        int m = 0;
        for (int i = 0; i< n; i++){
            for (int j = 0; j< n; j++){
                if (j == mid + m || j == mid - m) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
            if (i<mid) m += 1;
            else m-=1;
        }

        for (int i = 0; i< n; i++){
            System.out.print("*");
        }
    }

    static void perfectSquare(int a){
        for (int i  = 0; i*i <= a; i++){
            int n = a - i*i;
            for (int j = 0; j*j <= n; j++){
                if (n - j*j == 0){
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
        System.out.println("Not possible");
    }
}
