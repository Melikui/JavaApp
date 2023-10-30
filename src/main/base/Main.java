import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file/text/bilibili.txt"));
        String data;
        StringBuilder content = new StringBuilder();
        while ((data = br.readLine()) != null) {
            data = data + "\n";
            content.append(data);
        }
        br.close();
        System.out.println(content);
    }
}
