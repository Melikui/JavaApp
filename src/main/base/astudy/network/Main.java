package astudy.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        String ip = address.getHostAddress();
        String name = address.getHostName();
        System.out.println("ip: " + ip);
        System.out.println("name: " + name);
    }
}
