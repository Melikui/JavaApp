import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    public static int factorial(int n) {
        return n <= 1 ? n : n * factorial(n - 1);
    }

    public static ArrayList<Integer> fib(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (i < n) {
            list.add(i);
            int temp = i;
            i = j;
            j = i + temp;
        }
        return list;
    }
}
