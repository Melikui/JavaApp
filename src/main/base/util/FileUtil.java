package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件操作类
 * /Users/likui/Desktop/Java/file/
 * /Users/likui/Desktop/Java/file/text/foo.txt
 */

public class FileUtil {
    public static void fileInfo(String path) {
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.getParent());
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            boolean deleteResult = file.delete();
            System.out.println(deleteResult + "文件已经删除");
        }
    }

    public static void createFile(String path) throws IOException {
        File file = new File(path);
        boolean createResult = file.createNewFile();
        System.out.println(createResult + "文件已经创建");
    }

    public static String fileStreamRead(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            content.append(new String(bytes, 0, len));
        }
        System.out.println(content);
        fis.close();
        return content.toString();
    }

    public static void fileStreamWrite(String path, String content) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        byte[] bytes = content.getBytes();
        fos.write(bytes);
        fos.close();
    }

    public static String fileRead(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(path);
        int len;
        while ((len = fr.read()) != -1) {
            char ch = (char) len;
            content.append(ch);
        }
        fr.close();
        return content.toString();
    }

    public static void fileWrite(String path, String content, boolean append) throws IOException {
        FileWriter fw = new FileWriter(path, append);
        fw.write(content);
        fw.close();
    }

    public static String bufferedRead(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String data;
        while ((data = br.readLine()) != null) {
            data = data + "\n";
            content.append(data);
        }
        br.close();
        fr.close();
        return content.toString();
    }

    public static void bufferedWrite(String path, String content, boolean append) throws IOException {
        FileWriter fw = new FileWriter(path, append);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
        fw.close();
    }
}
