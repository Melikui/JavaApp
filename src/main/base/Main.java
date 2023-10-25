import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 35, 4, 2, 3};
        ArrayList<Object> list = new ArrayList<>();
        list.add("A");
        list.add(10);
        list.add(arr);
        System.out.println(((int[])list.get(2))[2]);
        list.forEach(i -> System.out.println("---" + i));
    }
}
