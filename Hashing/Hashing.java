package Learning.Hashing;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


public class Hashing {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        uUID();
        //Scanner sc = new Scanner(System.in);
        String str = "heelo";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        System.out.println(digest[i]);
//        System.out.println((digest[i] & 0xff));
//        System.out.println(Integer.toBinaryString(digest[i]));
//        System.out.println(0xff);
//        System.out.println(Integer.toBinaryString(0xff));
//        System.out.println((digest[i] & 0xff) + 0x100);
//        System.out.println(Integer.toString((digest[i] & 0xff) + 0x100, 16));
        for (byte b : digest) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println(sb.toString());
        System.out.println("304ef4cdda3463b24bf53f9cdd69ad3ecdab0842e7e70e2f3cfbb9f14e1c4ae6");
//        String str2 = generateRandomString(10);
//        System.out.println(str2);
//        str += str2;
//        System.out.println(str);
//        md.update(str2.getBytes());
//        byte[] digest2 = md.digest();
//        StringBuilder sb1 = new StringBuilder();
//        for (byte b : digest2) {
//            sb1.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
//        }
//        System.out.println(sb1.toString());
//        System.out.println("rvmvehmdah");
//        str = "heelo";
//        str += "rvmvehmdah";
//        System.out.println(str);
//        md.update(str.getBytes());
//        byte[] digest3 = md.digest();
//        StringBuilder sb2 = new StringBuilder();
//        for (byte b : digest3) {
//            sb2.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
//        }
//        System.out.println(sb2.toString()); // adf281b3cf688b25cc876092e2444b2a6465af485b81426c8c5ac62eddd00bd7
//        System.out.println(sb2.length());
    }
    static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        while (sb.length() < length) {
            sb.append((char) (rand.nextInt(26) + 'a'));
        }
        return sb.toString();
    }

    static void uUID() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString().length());
    }
}
