import util.FileUtil;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/likui/Desktop/Java/file/text/bilibili.txt";
//        String content = FileUtil.fileRead(path);
//        System.out.println(content);
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.getParent());
    }
}
