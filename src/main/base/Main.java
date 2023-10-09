import util.FileUtil;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/likui/Desktop/Java/file/text/bilibili.txt";
        String content = FileUtil.fileRead(path);
        System.out.println(content);
    }
}
