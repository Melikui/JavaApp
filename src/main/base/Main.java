import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    // -----------------------------------
    public static void main(String[] args) throws IOException {
        StringBuilder content = new StringBuilder();
        FileInputStream fis = new FileInputStream("file/mysql/mysql.sql");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            content.append(new String(bytes, 0, len));
        }
        System.out.println(content);
        fis.close();
    }
    // -----------------------------------
}
