package example;

import java.util.Scanner;

public class Example {
    public Example() {
    }

    public void test() {
        System.out.println("test");
    }

    /**
     * 打印星星✨
     */
    public static void getStar() {
        int row = 5;
        for (int i = 1; i <= 5; i++) {
            // 空格数等于最大行数 - 当前行数
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            // 星星数等于(当前行数*2-1)
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            // 每画一行就换一次行
            System.out.println();
        }
    }

    /**
     * 求总数
     */
    public static void totalSum() {
        System.out.println("请输入数字：");
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            count = count + 1;
            sum = sum + x;
        }
        System.out.println(count + "个数的和为" + sum);
        System.out.println(count + "个数的平均值是" + (sum / count));
        scan.close();
    }

    /**
     * 求符合勾股定理100以内的数
     */
    public static void gougudingli() {
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                for (int z = 1; z <= 100; z++) {
                    if (x < y && x * x + y * y == z * z) {
                        System.out.println(x + "," + y + "," + z);
                    }
                }
            }
        }
    }

    /**
     * 递归求阶乘
     */
    public static int recursion(int num) {
        System.out.println(num);
        return num == 1 ? num : num * recursion(num - 1);
    }

    /**
     * 打印九九乘法表
     */
    public void multiplicationTable(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(j + "*" + i + "=" + (j * i) + "\t");
            }
            System.out.println();
        }
    }
}
