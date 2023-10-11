package example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Runoot {
    public static void main(String[] args) throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建GET请求
        HttpGet httpGet = new HttpGet("https://www.runoob.com");
        httpGet.setHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
        // 获取响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            String html = EntityUtils.toString(response.getEntity(), "UTF-8");
            // 创建Document对象
            Document document = Jsoup.parse(html);
            // 获取列表
            Elements elements = document.getElementsByClass("codelist-desktop");
            for (Element element : elements) {
                String title = element.getElementsByTag("h2").text();
                Elements alist = element.getElementsByClass("item-top");
                for (Element aitem : alist) {
                    String header = aitem.getElementsByTag("h4").text();
                    String brief = aitem.getElementsByTag("strong").text();
                    String link = aitem.getElementsByTag("a").attr("href");
                    System.out.println(title + header + brief + link);
                }
            }
        }
        httpClient.close();
        response.close();
    }
}

