import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        // 获取迭代器
        Iterator<String> it = sites.iterator();
        // 输出集合中的第一个元素
        System.out.println("-----");
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
