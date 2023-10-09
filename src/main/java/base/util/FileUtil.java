package base.util;

import java.io.*;

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

    public static void createFile(String path) {
        File file = new File(path);
        try {
            boolean createResult = file.createNewFile();
            System.out.println(createResult + "文件已经创建");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fileStreamRead(String path) {
        File file = new File(path);
        String content;
        try {
            FileInputStream in = new FileInputStream(file);
            byte[] byt = new byte[1024];
            int len = in.read(byt);
            content = new String(byt, 0, len);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static void fileStreamWrite(String path, String content) {
        File file = new File(path);
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] buy = content.getBytes();
            out.write(buy);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fileRead(String path) {
        File file = new File(path);
        StringBuilder content = new StringBuilder();
        try {
            FileReader fr = new FileReader(file);
            int n = fr.read();
            while (n != -1) {
                n = fr.read();
                content.append((char) n);
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public static void fileWrite(String path, String content) {
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String bufferedRead(String path) {
        File file = new File(path);
        StringBuilder content = new StringBuilder();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            System.out.println(line);
            String str = "";
            while ((str = br.readLine()) != null) {
                line = br.readLine();
                str = str + "\n";
                line = line + "\n";
                content.append(str).append(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public static void bufferedWrite(String path, String content) {
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
