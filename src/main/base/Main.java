import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        print("Java", "Python", "Node");
    }

    public static void print(String... args) {
        System.out.println(Arrays.toString(args));
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
