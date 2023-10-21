import util.FileUtil;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String path = "/Users/likui/Desktop/Java/file/text/foo.txt";
        FileUtil.fileWrite(path, """
                Java 是一个非常好的语言。
                是的，的确非常好!!
                """);
        System.out.println(FileUtil.fileRead(path));
    }
}
