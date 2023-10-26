import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Node");
        list.add("C/C++");
        System.out.println(list);
        list.stream()
                .filter(i -> i.length() > 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
