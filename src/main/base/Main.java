import example.Bilibili;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Bilibili.getDirectory();
    }

    public static void print(String... args) {
        System.out.println(Arrays.toString(args));
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public static void shuiXianHua() {
        for (int i = 100; i < 1000; i++) {
            int a = i / 10 / 10, b = i / 10 % 10, c = i % 10;
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println("" + a + b + c);
            }
        }
    }
}
