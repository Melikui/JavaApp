import java.io.File;

public class Main {
    // -----------------------------------
    public static void main(String[] args) {
        String str = "Hello world ,Hello Java";
        int index = str.lastIndexOf("o");
        System.out.println("index： " + index);
        System.out.println(str.replace("H","K"));
        System.out.println(new StringBuffer(str).reverse());
    }
    // -----------------------------------
}
