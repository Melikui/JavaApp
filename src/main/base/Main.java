import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("C/C++");
        list.add("Java");
        list.add("Python");
        list.add("Node");
        list.add("HTML/CSS");
        Collections.reverse(list);
        Collections.shuffle(list);
        Collections.sort(list);
        Collections.swap(list, 2, 4);
        System.out.println(list);
    }
}

