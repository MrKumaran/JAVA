package Learning.GroundZero;

import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {

        //Scanner s = new Scanner(System.in);
        //s.close();
//        String s1 = "abc *&%$b@a";
//        boolean result = staticMethods.palindrome(s1);
//        System.out.println(result);
//        int[] array = {3,6,5,4,2,1,7,0,9,8};
//        int number = staticMethods.missingNnumber(array);
//        System.out.println(number); // 7
        //System.out.println(staticMethods.longestSubstring("abcabcdAa"));
        // char firstUnique = staticMethods.firstUniqueChar("a@*&%^@*&abbssdd");
        // if (firstUnique != ' ') System.out.println(firstUnique);
        // else System.out.println(-1);
        // staticMethods.numPatternPrinting(10);
        // staticMethods.leadersInArray(new int[]{254,1,31,54,7});
    }
}

class staticMethods {

    /*
    1
    2 6
    3 7 10
    4 8 11 13
    5 9 12 14 15
     */
    public static void numPatternPrinting(int n){
        for (int i = 1; i<=n; i++){
            int temp = i;
            for (int j = 1; j<=i; j++){
                System.out.print(temp + " ");
                temp += n-j;
            }
            System.out.println();
        }
    }

    public static void leadersInArray(int[] arr){
        int size = arr.length;
        if (size<=1) return;
        int currLeader = arr[size-1];
        StringBuilder sb = new StringBuilder();
        sb.insert(0, currLeader + " ");
        for (int i = size-2; i>0; i--){
            if (arr[i] > currLeader){
                sb.insert(0, arr[i] + " ");
                currLeader = arr[i];
            }
        }
        System.out.println(sb);
    }

    public static void removeDuplicateLetters(String s) {
        List<Character> stack = new ArrayList<>();
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(stack.contains(c)) continue;
            while(true){
                if((stack.isEmpty()) || (stack.getLast() < c)){
                    stack.add(c);
                    break;
                }
                if(s.indexOf(stack.getLast(), i+1) != -1){
                    stack.removeLast();
                }
                else{
                    stack.add(c);
                    break;
                }
            }
        }
        System.out.println(stack.toString());
    }

    public static char firstUniqueChar(String s){
        if (s.length() == 1) return s.charAt(0);
        if (s.isEmpty()) return ' ';
        Map<Character, Integer> charFrequency = new LinkedHashMap<>();
        char firstUnique = ' ';
        for (char c: s.toCharArray()){
            charFrequency.put(c, charFrequency.getOrDefault(c, 0)+1);
        }
        for (char c: charFrequency.keySet()){
            if (charFrequency.get(c) == 1){
                firstUnique = c;
                break;
            }
        }
        return firstUnique;
    }

    // TODO redo
    public static int longestSubstring(String s){
        int length = s.length();
        if (length <= 1) return length;
        String longSubstring = "";
        for (int i = 0; i< length; i++){
            int nextIndex = s.indexOf(s.charAt(i), i+1);
            if (nextIndex == -1) nextIndex = length;
            String sub = s.substring(i, nextIndex);
            Set<Character> charSet = new HashSet<>();
            for (char c : sub.toCharArray()) {
                charSet.add(c);
            }
            if (sub.length() == charSet.size()) longSubstring = sub;
        }

        return longSubstring.length();
    }

    public static int missingNnumberXor(int[] array) {
        int max = array.length;
        if (max == 0) return 0;

        int xor = 0;
        boolean isZero = false;

        // Single loop: XOR array elements and corresponding expected values
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) isZero = true;
            xor ^= array[i] ^ i; // XOR both at once
        }
        xor ^= max; // Don't forget the last expected value

        // Handle special cases
        if (xor == 0 && isZero) return max + 1;
        else if (!isZero) return 0;
        return xor;
    }

    public static int missingNnumber(int[] array){
        int max = array.length;
        if (max == 0) return 0;
        boolean isZero = false;
        int missingNumber = (max * (max + 1)) /2;
        for (int i:array){
            if (i == 0) isZero = true;
            missingNumber-=i;
        }

        if (missingNumber == 0 && isZero) return max + 1;
        else if (!isZero) return 0;
        return missingNumber;
    }

    public static boolean palindrome(String s){
        int length = s.length();
        s = s.trim().toLowerCase();
        int i = 0;
        int j = length - 1;
        while (i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else if (!(s.charAt(i) <= 'z' && s.charAt(i) >= 'a')){
                i++;
            }
            else if (!(s.charAt(j) <= 'z' && s.charAt(j) >= 'a')){
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void crc(){

        /*
                In this problem, each letter of the alphabet corresponds to a number\s
                using the scheme: a=1, b=2, c=3, ... y=25, z=26. To encode a message,\s
                an encryption key word is added to the message. The key word is the first\s
                word in the message that is five or more characters long. For example,\s
                if the message were:
                "give me liberty or give me death," the key word would be "liberty."\s
                The encrypted message would be: srxj ey kukgwls nd pkaw gd pncyz
                give me liberty or give me death
                libe rt ylibert yl iber ty liber
                ---------------------------------
                srxj ey kukgwls nd pkaw gd pncyz

                a=1, b=2, c=3, d=4, e=5, f=6, g=7, h=8, i=9, j=10, k=11, l=12, m=13, n=14,\s
                o=15, p=16, q=17, r=18, s=19, t=20, u=21, v=22, w=23, x=24, y=25, z=26
                */
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String s = "give me liberty or give me death";
        String key = "";
        String[] p = s.split(" ");
        for(String d:p){
            if (d.length() >= 5){
                key = d;
                break;
            }
        }
        StringBuilder encryptedS = new StringBuilder();
        int i = 0;
        int maxI = key.length();
        for (char c: s.toCharArray()){
            if (c == ' ') encryptedS.append(' ');
            else {
                int originalCharIndex = alpha.indexOf(c) + 1;
                int keyCharIndex = alpha.indexOf(key.charAt(i % maxI));
                int getChatAt = (originalCharIndex + keyCharIndex) % 26;
                encryptedS.append(alpha.charAt(getChatAt));
                i++;
            }
        }
        //String.valueOf(alpha).indexOf();
        System.out.println(encryptedS);
    }

    public static void intToRoman(int num) {

        int[] values =  {1000, 900, 500, 400, 100, 90,  50,  40,  10, 9,   5,  4,  1};
        String[] romans = {"M", "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romans[i]);
                num -= values[i];
            }
        }
        System.out.println(result);
    }

    public static void dupBracket(String s){
        List<Character> stack = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(c == ')'){
                int count = 0;
                while(!stack.isEmpty() && stack.getLast() != '('){
                    count++;
                    stack.removeLast();
                }
                if(!stack.isEmpty()){
                    stack.removeLast();
                }
                else {
                    System.out.println("extra ))))");
                    break;
                }
                if(count == 0){
                    System.out.println("extre");
                    break;
                }
            }
            else {
                stack.add(c);
            }
        }
        System.out.println("No extra");
    }

    public static void sumOfTwoSquares(int number){
        for(int i = 0; i*i <= number; i++){
            int j = number - (i*i);
            int sqJ = (int) Math.sqrt(j);
            if (j == sqJ*sqJ){
                System.out.println("yes");
                break;
            }
            else {
                System.out.println("no");
            }
        }
    }

    public static boolean canWin(int leap, int[] game) {
        long count = Arrays.stream(game)
                .filter(element -> element == 1)
                .count();
        if(count<leap && game[0] == 0){
            return true;
        }
        if(game[0] == 1 && game.length == 1){
            return true;
        }
        int gamelength = game.length;
        for(int i = 0; i<gamelength; i++){
            int step = i;
            while(step < gamelength){
                if(game[step] == 0){
                    step += leap;
                }
                else if(game[step] == 1){
                    break;
                }
            }
            if(step == gamelength - 1){
                return true;
            }
            if(game[step] == 1){
                break;
            }
        }
        return false;
    }

    public static void roomsAndKeys(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) return;
        Map<Integer, Boolean> roomVisited = new HashMap<>();
        roomVisited.put(0, true);
        List<Integer> queue = new ArrayList<>(rooms.getFirst());
        System.out.println(queue);
        while (!queue.isEmpty()){
            roomVisited.put(queue.getFirst(), true);
            rooms.get(queue.getFirst()).iterator().forEachRemaining(integer -> {
                if (!queue.contains(integer) && !roomVisited.getOrDefault(integer, false)) {
                    queue.add(integer);
                    System.out.println(integer);
                }
            });
            queue.remove(queue.getFirst());
        }
        System.out.println(roomVisited.size());
    }

    public static void quering(Scanner s) {
        List<List<Integer>> it = new ArrayList<>();
        List<List<Integer>> query = new ArrayList<>();
        int lines = s.nextInt();
        s.nextLine();
        for (int i = 0; i < lines; i++) {
            it.add(new ArrayList<>(
                    Arrays.stream(s.nextLine().split("\\b \\b"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()))
            );
        }
        int queries = s.nextInt();
        s.nextLine();
        for (int i = 0; i < queries; i++) {
            query.add(
                    new ArrayList<>(
                            Arrays.stream(s.nextLine().split("\\b \\b")).map(Integer::parseInt).collect(Collectors.toList())
                    )
            );
        }
        for (List<Integer> i : query) {
            try {
                int r = i.get(0);
                int c = i.get(1);
                System.out.println(it.get(r - 1).get(c));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }

    public static void regex(List<String> testcases) {
        int validCase = 0;
        final String regexExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}";
        for (String testCase : testcases) {
            if (testCase.matches(regexExpression)) {
                validCase++;
                System.out.println(testCase);
                System.out.println(testCase.length());
            }
        }
        System.out.println(validCase);
    }

    public static void hourClockSumHigh(List<List<Integer>> numList) {

        int maximum = -100;
        for (int j = 0; j < 4; j++) {
            int start = 0;
            int middle = 1;
            int currMax = -100;
            for (int i = 0; i < 4; i++) {
                int currRowMax = 0;
                for (int i1 = start; i1 < start + 3; i1++) {
                    currRowMax += numList.get(j).get(i1);
                }
                currRowMax += numList.get(j + 1).get(middle);
                for (int i1 = start; i1 < start + 3; i1++) {
                    currRowMax += numList.get(j + 2).get(i1);
                }
                start++;
                middle++;
                currMax = Math.max(currMax, currRowMax);
            }
            maximum = Math.max(maximum, currMax);
        }

        System.out.println(maximum);
    }

    public static void alphabetReverse(String original) {
        char[] originalCharArray = original.toCharArray();
        int i = 0;
        int length = originalCharArray.length;
        int j = length - 1;
        int loopVariable = 0;
        while (loopVariable <= length / 2) {
            int iChar = originalCharArray[i];
            int jChar = originalCharArray[j];
            boolean isiChar = (iChar >= 97 && iChar <= 122);
            boolean isjChar = (jChar >= 97 && jChar <= 122);
            if (!isiChar) i++;
            if (!isjChar) j--;
            if (isiChar && isjChar) {
                char temp = originalCharArray[i];
                originalCharArray[i] = originalCharArray[j];
                originalCharArray[j] = temp;
                i++;
                j--;
            }
            loopVariable++;
        }
        System.out.println(originalCharArray);
    }

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
