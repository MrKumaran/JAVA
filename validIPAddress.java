package Learning;

import java.util.ArrayList;

public class validIPAddress {

    static boolean isValid(String s) {
        int n = s.length();
        if (n == 1)
            return true;

        int val = Integer.parseInt(s);
        if (s.charAt(0) == '0' || val > 255)
            return false;

        return true;
    }

    static void generateIpRec(String s, int index, String curr, int cnt, ArrayList<String> res) {
        String temp = "";

        if (index >= s.length())
            return;

        if (cnt == 3) {
            temp = s.substring(index);
            System.out.println(temp + " temp " + curr + cnt);
            if (temp.length() <= 3 && isValid(temp))
                res.add(curr + temp);
            return;
        }

        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            temp += s.charAt(i);

            if (isValid(temp)) {
                generateIpRec(s, i + 1, curr + temp + ".", cnt + 1, res);
            }
        }
    }

    static ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        generateIpRec(s, 0, "", 0, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "255678166";
        ArrayList<String> res = generateIp(s);

        for (String ip : res)
            System.out.println(ip);
    }
}
