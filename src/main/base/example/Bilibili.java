package example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static util.FileUtil.fileRead;
import static util.FileUtil.fileWrite;

public class Bilibili {
    public static void getDirectory(){
        String html = fileRead("/Users/likui/Desktop/Java/file/html/bilibili.html");
        // 创建 Document 对象
        Document document = Jsoup.parse(html);
        // 获取列表
        Elements elements = document.getElementsByClass("clickitem");
        StringBuilder content = new StringBuilder();
        for (Element element : elements) {
            String order = element.select("span[class='page-num']").text();
            String title = element.select("span[class='part']").text();
            String duration = element.select("div[class='duration']").text();
            String itemValue = order + "---" + title + "---" + duration + "\n";
            System.out.println(itemValue);
            content.append(itemValue);
        }
        fileWrite("/Users/likui/Desktop/Java/file/text/bilibili.txt", content.toString());
    }
}
