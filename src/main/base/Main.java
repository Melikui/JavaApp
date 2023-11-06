import plugins.MongoDB;

import java.util.Scanner;

public class Main {
    // -----------------------------------------------
    public static void main(String[] args) {
        MongoDB mongodb = new MongoDB();
        mongodb.query();
    }
    // -----------------------------------------------

    public static void isPalindrome() {
        System.out.print("请输入内容：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int len = str.length(), left = 0, right = len - 1;
        boolean flag = true;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                flag = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(flag);
    }
}
