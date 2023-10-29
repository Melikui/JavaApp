package astudy.network.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // TCP 协议，接收数据
        // 1,创建对象 ServerSocket
        ServerSocket ss = new ServerSocket(10000);
        // 2,监听客户端的连接
        Socket socket = ss.accept();
        // 3,从连接通道中获取输入流读取数据
        InputStream is = socket.getInputStream();
        // 解决中文乱码问题
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }
        // 4,释放资源
        socket.close();
        ss.close();
    }
}
