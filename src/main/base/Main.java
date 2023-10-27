import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    // -----------------------------------
    public static void main(String[] args) throws IOException {
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader("file/text/bilibili.txt");
        int len;
        while ((len = fr.read()) != -1) {
            char ch = (char) len;
            content.append(ch);
        }
        fr.close();
        System.out.println(content);
    }
    // -----------------------------------
}
