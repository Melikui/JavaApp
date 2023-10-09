package base.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Terminal {
    public static void run() throws IOException, InterruptedException {
        String[] command = {"ls", "-a"};
        Process process = Runtime.getRuntime().exec(command);
        // 读取命令执行结果
        InputStream inputStream = process.getInputStream();
        System.out.println(inputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        // 等待命令执行完毕
        process.waitFor();
        // 关闭资源
        reader.close();
        inputStream.close();
    }
}
