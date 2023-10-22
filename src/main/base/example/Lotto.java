package example;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        // 1,生成中奖号码
        int[] arr = createNumber();
        // 2,用户输入彩票号码（红球 + 蓝球）
        int[] userInputArr = userInputNumber();
        // 3,判断用户的中奖情况
        // 红球 蓝球
        int redCount = 0;
        int blueCount = 0;
        // 判断红球
        for (int redNumber : userInputArr) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (redNumber == arr[j]) {
                    redCount++;
                    // 如果找到了，那么后面的数字就没有必要继续比较了
                    // 跳出内循环，继续判断在一个红球号码是否中奖
                    break;
                }
            }
        }
        // 判断蓝球
        int blueNumber = userInputArr[userInputArr.length - 1];
        if (blueNumber == arr[arr.length - 1]) {
            blueCount++;
        }
        System.out.println(redCount);
        System.out.println(blueCount);

        // 根据红球的个数及蓝球的个数来判断中奖情况
        if (redCount == 6 && blueCount == 1) {
            System.out.println("恭喜你，中奖1000万");
        } else if (redCount == 6) {
            System.out.println("恭喜你，中奖500万");
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("恭喜你，中奖3000");
        } else if (redCount == 5 || redCount == 4 && blueCount == 1) {
            System.out.println("恭喜你，中奖200");
        } else if (redCount == 4 || redCount == 3 && blueCount == 1) {
            System.out.println("恭喜你，中奖200");
        } else if ((redCount == 2 && blueCount == 1) || (redCount == 1 && blueCount == 1) || (redCount == 0 && blueCount == 1)) {
            System.out.println("恭喜你，中奖5");
        } else {
            System.out.println("谢谢参与！");
        }

    }

    public static int[] userInputNumber() {
        // 1,创建数组用于添加用户购买的彩票号码
        // 6个红球，1个蓝球，数组长度7
        int[] arr = new int[7];
        // 2,利用键盘录入让用户输入
        Scanner scanner = new Scanner(System.in);
        // 让用户输入红球号码
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码");
            int redNumber = scanner.nextInt();
            // redNumber 在1～33 唯一不重复
            if (redNumber >= 1 && redNumber <= 33) {
                boolean flag = contains(arr, redNumber);
                if (!flag) {
                    // 有效的，可以添加到数组中
                    arr[i] = redNumber;
                    i++;
                } else {
                    System.out.println("当前红球号码已经存在，请重新输入");
                }
            } else {
                System.out.println("当前红球号码超出范围");
            }
        }
        // 让用户输入蓝球号码
        System.out.println("请输入蓝球号码");
        // 1~16
        while (true) {
            int blueNumber = scanner.nextInt();
            if (blueNumber >= 1 && blueNumber <= 16) {
                arr[arr.length - 1] = blueNumber;
                break;
            } else {
                System.out.println("当前蓝球号码超出范围");
            }
        }
        return arr;
    }

    public static int[] createNumber() {
        // 1,创建数组用于添加中奖号码
        // 6个红球，1个蓝球，数组长度7
        int[] arr = new int[7];
        // 2,随机生成号码并添加到数组当中
        // 红球：不能重复的
        // 蓝球：可以跟红球号码重复
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            // 获取红球号码
            int redNumber = r.nextInt(33) + 1;
            boolean flag = contains(arr, redNumber);
            if (!flag) {
                // 把红球号码添加到数组
                arr[i] = redNumber;
                i++;
            }
        }
        // 生成蓝球号码并添加到数组当中
        int blueNumber = r.nextInt(16) + 1;
        arr[arr.length - 1] = blueNumber;
        return arr;
    }

    // 用户判断数字在数组中是否存在
    public static boolean contains(int[] arr, int number) {
        for (int j : arr) {
            if (j == number) {
                return true;
            }
        }
        return false;
    }
}
