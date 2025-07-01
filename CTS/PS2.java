package Learning.CTS;

import java.util.Scanner;
import java.util.Vector;

public class PS2 {

    public static int getTotalXorOfSubarrayXors(Vector<Integer> arr, int N) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            int freq = (i + 1) * (N - i);
            if (freq % 2 == 1)
                res ^= arr.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Vector<Integer> arr = new Vector<>(N);
        for (int i = 0; i < N; i++) {
            arr.add(scanner.nextInt());
        }
        System.out.println(getTotalXorOfSubarrayXors(arr, N));
        scanner.close();
    }
}
