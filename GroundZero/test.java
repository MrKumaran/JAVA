package Learning.GroundZero;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // long n = s.nextLong();
        // Number_crunch_1 NC = new Number_crunch_1();
        // Boolean answer = NC.adamNumber(n);
        // System.out.println(answer);
        // long answer = NC.kDigitReverse(n, s.nextInt());
        // System.out.println(answer);
        // getSmallestAndLargest("welcometojava", 3);
        // System.out.println(isAnagram("anagram", "margana"));
        // splitRegrex("        YES      leading spaces        are valid,    problemsetters are         evillllll");
        // ---- Array ----
        // getArray(s);
        // int d = s.nextInt();
        // int d = 11;
        s.close();
    }

}

class staticMethods {

    public static void getArray(Scanner s) {
        System.out.print("Enter number of element: ");
        int count = s.nextInt();
        int[] array = new int[count];
        System.out.println("Enter element to add:");
        for (int i = 0; i < count; i++) {
            array[i] = s.nextInt();
        }
        // System.out.print("Enter element to add:");
        // int elementToAdd = s.nextInt();
        // System.out.print("Enter position of element:");
        // int position = s.nextInt();
        // insertElementInArray(array, elementToAdd, position);
        System.out.print("Enter position to delete element: ");
        deleteElementInArray(array, s.nextInt());
    }

    public static void deleteElementInArray(int[] array, int position) {
        int[] newArray = new int[array.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 == position) continue;
            newArray[j++] = array[i];
        }
        printArray(newArray);
    }

    public static void insertElementInArray(int[] array, int element, int position) {
        int[] newArray = new int[array.length + 1];
        int j = 0;
        for (int i = 0; i < array.length + 1; i++) {
            if (i + 1 == position) {
                newArray[i] = element;
                continue;
            }
            newArray[i] = array[j++];
        }
        printArray(newArray);

    }

    public static void printArray(int[] array) {
        for (int k : array) {
            System.out.println(k);
        }
    }

    public static void splitRegrex(String s) {
        s = s.trim();
        String[] se = s.split("[!,?._'@\\s+]+");
        System.out.println(se.length);
        for (String i : se) {
            System.out.println(i);
        }
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] c = new int[26];

        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            c[a.charAt(i) - 'a']++;
            c[b.charAt(i) - 'a']--;
        }
        for (int i : c) {
            if (i != 0) return false;
        }
        return true;

    }

    public static void getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        smallest = s.substring(0, k);
        largest = s.substring(0, k);

        for (int i = 1; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, k + i);
            System.out.println(sub);
            if (sub.compareTo(smallest) < 0) {
                smallest = sub;
            } else if (sub.compareTo(largest) > 0) {
                largest = sub;
            }
        }


        System.out.println(smallest + "\n" + largest);
    }

    public static void park() {
        int row, column;
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();

        int size = row * column;

        int[] matrix = new int[size];
        int index;

        for (index = 0; index < size; index++) {
            matrix[index] = sc.nextInt();
        }

        int maxr = -1;
        int max = -1;

        for (int r = 0; r < row; r++) {
            int count = 0;
            for (int i = r * column; i < column + (r * column); i++) {
                count += matrix[i];
            }
            if (count > max) {
                max = count;
                maxr = r;
            }
        }

        System.out.println(maxr + 1);
    }

    public static void party() {
        int[] a = {7, 0, 5, 1, 3};
        int[] b = {1, 2, 1, 3, 4};

        int[] pt = new int[5];
        pt[0] = a[0] - b[0];

        for (int i = 1; i < 5; i++) {
            pt[i] = (pt[i - 1] + a[i]) - b[i];
        }

        System.out.println(Arrays.toString(pt));
        System.out.println(Arrays.stream(pt).max().getAsInt());
    }

}

class Number_crunch_1 {

    public long kDigitReverse(long original, int digit) {
        int originalDigit = 0;
        long temp = original;
        while (temp > 0) {
            originalDigit++;
            temp /= 10;
        }
        if (originalDigit < digit) return -1;
        long toReverse = original % (long) Math.pow(10, digit);
        long reversed = original - toReverse;
        temp = toReverse;
        toReverse = 0;
        while (temp > 0) {
            toReverse *= 10;
            toReverse += temp % 10;
            temp /= 10;
        }
        reversed += toReverse;
        return reversed;
    }

    public boolean adamNumber(long original) {
        long square = original * original;
        long reverse = 0;
        while (original > 0) {
            reverse *= 10;
            reverse += original % 10;
            original /= 10;
        }
        long reverseSquare = reverse * reverse;
        long reverseSquareReverse = 0;
        while (reverseSquare > 0) {
            reverseSquareReverse *= 10;
            reverseSquareReverse += reverseSquare % 10;
            reverseSquare /= 10;
        }
        return reverseSquareReverse == square;
    }

    public boolean magicNumber(long original) {
        long num = 0;
        long temp = original;
        long digitSum = 0;
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }

        long digitSumReversed = 0;
        temp = digitSum;
        while (temp > 0) {
            digitSumReversed *= 10;
            digitSumReversed += temp % 10;
            temp /= 10;
        }
        num = digitSum * digitSumReversed;
        return num == original;
    }

    public boolean numberPalindrom(long original) {
        boolean isPalindrom = true;
        int digit = 0;
        long temp = original;
        while (temp > 0) {
            digit++;
            temp /= 10;
        }
        temp = original;
        for (int i = 0; i < digit / 2; i++) {
            int left = (int) (temp / (long) Math.pow(10, digit - i - 1)) % 10;
            int right = (int) (temp / (long) Math.pow(10, i)) % 10;
            if (left != right) {
                return !isPalindrom;
            }
        }
        return isPalindrom;
    }

    public long reverse(long original) {
        long num = 0;
        while (original > 0) {
            num *= 10;
            num += original % 10;
            original /= 10;
        }
        return num;
    }

    public boolean amstrong(long original) {
        long temp = original;
        int digit = 0;
        long num = 0;
        while (temp > 0) {
            digit++;
            temp /= 10;
        }
        temp = original;
        while (temp > 0) {
            num += (long) Math.pow(temp % 10, digit);
            temp /= 10;
        }
        return num == original;
    }

    public boolean strongNumber(long original) {
        if (original == 0) {
            return false;
        }
        long num = 0;
        long temp = original;
        while (temp > 0) {
            num += fact((int) (temp % 10));
            temp /= 10;
        }

        return num == original;
    }

    private long fact(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

