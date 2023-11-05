package example;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Example {
    /**
     * 回文检测
     */
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

    /**
     * 打印水仙花数
     */
    public static void shuiXianHua() {
        for (int i = 100; i < 1000; i++) {
            int a = i / 10 / 10, b = i / 10 % 10, c = i % 10;
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println("" + a + b + c);
            }
        }
    }

    /**
     * 生成字母
     */
    public static void generateLetters() {
        // A-Z:65-90, a-z:97-122
        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        String[] arr = new String[26];
        for (int i = 65; i <= 90; i++) {
            arr1[i - 65] = (char) i;
            arr2[i - 65] = (char) (i + 32);
            arr[i - 65] = String.valueOf((char) i) + (char) (i + 32);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 打印目录结构
     */
    static void showDir(int indent, File file) throws IOException {
        for (int i = 0; i < indent; i++) {
            System.out.print('-');
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File value : files) showDir(indent + 4, value);
            }
        }
    }

    /**
     * 遍历目录
     */
    public static void visitAllDirsAndFiles(File dir) {
        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            if (children != null) {
                for (String child : children) {
                    visitAllDirsAndFiles(new File(dir, child));
                }
            }
        }
    }

    /**
     * 获取本机ip地址及主机名
     */
    public static void getLocalIP() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String address = addr.getHostAddress();
        String name = addr.getHostName();
        System.out.println("Local HostAddress:" + address);
        System.out.println("Local host name: " + name);
    }

    /**
     * 获取指定域名IP
     */
    public static void getIP() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostName() + "=" + address.getHostAddress());
    }

    /**
     * 查看端口是否被占用
     */
    public static void checkPort() throws IOException {
        Socket Skt = null;
        String host = "localhost";
        for (int i = 0; i < 1024; i++) {
            try {
                System.out.println("查看 " + i);
                Skt = new Socket(host, i);
                System.out.println("端口 " + i + " 已被使用");
            } catch (UnknownHostException e) {
                System.out.println("Exception occured" + e);
                break;
            } catch (IOException ignored) {
            } finally {
                if (Skt != null) {
                    Skt.close();
                }
            }
        }
    }

    /**
     * 求斐波那契数列
     */
    public static ArrayList<Integer> fib(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (i < n) {
            list.add(i);
            int temp = i;
            i = j;
            j = j + temp;
        }
        return list;
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
     * 杨辉三角
     *
     * @param n 打印函数
     */
    public static void printTriangle(int n) {
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 每行的第一个和最后一个数字都是1
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                // 其他数字是上一行的两个数字之和
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        // 打印杨辉三角
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
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
    public static int factorial(int num) {
        System.out.println(num);
        return num <= 1 ? num : num * factorial(num - 1);
    }

    /**
     * 打印九九乘法表
     */
    public void multiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(j + "*" + i + "=" + (j * i) + "\t");
            }
            System.out.println();
        }
    }
}
