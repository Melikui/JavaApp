package astudy.network.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // TCP 协议，发送数据
        // 1,创建 Socket 对象并连接服务器（如果连接不上，代码会报错）
        Socket socket = new Socket("127.0.0.1", 10000);
        // 2,可以从连接通道中获取输出流
        Scanner scanner = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();
        while (true) {
            System.out.print("请输入您要发送的信息: ");
            String msg = scanner.nextLine();
            if ("end".equals(msg)) {
                break;
            }
            // 写出数据
            os.write(msg.getBytes());
        }
        // 3,释放资源
        socket.close();
    }
}
