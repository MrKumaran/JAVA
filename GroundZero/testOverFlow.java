package Learning.GroundZero;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class testOverFlow {
    public static void main(String[] args) {

    }
}

class testes{

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0 && m == 0) return;
        int i = m-1;
        int j = n-1;
        int index = nums1.length-1;
        while(i >= 0 && j >= 0){
            if (nums1[i]>nums2[j]){
                nums1[index--] = nums1[i--];
            }
            else {
                nums1[index--] = nums2[j--];
            }
        }
        while(j >= 0){
            nums1[index--] = nums2[j--];
        }
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for(int i = 2; i<n; i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }

    public int lengthOfLastWord(String s) {
        return s.split(" ")[s.split(" ").length-1].length();
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left <= right){
            mid = (left+right)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (left > right) return left;
        else return right;
    }

    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (!stack.isEmpty()){
                if (c == ')' && stack.peek() == '(') stack.pop();
                else if (c == ']' && stack.peek() == '[') stack.pop();
                else if ('}' == c && stack.peek() == '{') stack.pop();
                else return false;
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        int length = nums.length;
        if (length == 0 || (length == 1 && nums[0] == val)) return 0;
        if (length == 1 && nums[0] != val) return 1;
        int left = 0;
        for (int i = 0; i<length; i++){
            if (nums[i] != val){
                nums[left++] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;

    }

    public int getMinSqrt(int value){
        int left = 1;
        int right = value/2;
        int sqrt = 1;
        while(left <= right){
            int mid = (left+right)/2;
            long temp = (long) mid *mid;
            if (temp <= value){
                sqrt = mid;
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        return sqrt;
    }

    public void longestCommonPrefix(String[] strs) {
        if (strs.length == 0) System.out.println(0);
        else {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int commonIndex = 0;
                for (int j = 0; j < strs[i].length(); j++){
                    if (!prefix.isEmpty() && prefix.length() > j && prefix.charAt(j) == strs[i].charAt(j)){
                        commonIndex++;
                    }
                    else break;
                }
                prefix = prefix.substring(0, commonIndex);
            }
            System.out.println(prefix);
        }
    }

    public void romanToInt(String s) {
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

    public void numPalindrome(int x){
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