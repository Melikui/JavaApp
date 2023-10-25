import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(fib(1000));
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
