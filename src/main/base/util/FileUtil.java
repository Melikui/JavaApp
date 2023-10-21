package util;

import java.io.*;

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
        File file = new File(path);
        String content;
        FileInputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = in.read(b);
        content = new String(b, 0, len);
        in.close();
        return content;
    }

    public static void fileStreamWrite(String path, String content) throws IOException {
        File file = new File(path);
        FileOutputStream out = new FileOutputStream(file);
        byte[] b = content.getBytes();
        out.write(b);
        out.close();
    }

    public static String fileRead(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(path);
        int n = fr.read();
        while (n != -1) {
            char ch = (char) n;
            content.append(ch);
            n = fr.read();
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
