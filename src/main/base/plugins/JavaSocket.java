package plugins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class JavaSocket {
    public static void Client() throws IOException {
        String msg = "";
        while (!Objects.equals(msg, "stop")) {
            Socket socket = new Socket("localhost", 8880);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入发送的内容: ");
            msg = scanner.next();
            out.println(msg);
            String response = br.readLine();
            System.out.println("---Python: " + response);
            out.close();
            br.close();
            socket.close();
        }
    }

    public static void Server() {

    }
}

