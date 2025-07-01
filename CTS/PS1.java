package Learning.CTS;

import java.util.Scanner;

public class PS1 {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int n = 5;//sc.nextInt();
        int m = 9;//sc.nextInt();
        int[][] solar = {
                {1,2,3,4,5,6,7,8,9},
                {10,27,35,41,215,36,32,42,3},
                {61,27,30,48,55,36,17,82,93},
                {106,267,356,4561,2615,366,362,42,3},
                {16,26,35,48,57,69,70,82,91}
        };
        countMoon(solar, n, m);
    }

    static void countMoon(int[][] solar, int n, int m){
        int maxMoon = 0;
        int maxMoonInSolar = 0;
        for (int i = 0; i<n; i++){
            int moons = 0;
            int max = 0;
            for (int j = 0; j<n; j++){
                moons += solar[i][j];
                if (max < solar[i][j]) max = solar[i][j];
            }
            if (maxMoon<moons){
                maxMoon = moons;
                maxMoonInSolar = max;
            }
        }
        System.out.println(maxMoonInSolar);

    }

}
