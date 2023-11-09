package example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static util.FileUtil.fileWrite;

public class Bootcdn {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(null, (x509Certificates, s) -> true)
                .build();
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setSSLContext(sslContext)
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        // 创建GET请求
        HttpGet httpGet = new HttpGet("https://www.bootcdn.cn/all/");
        httpGet.setHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
        // 获取响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            String html = EntityUtils.toString(response.getEntity(), "UTF-8");
            // 创建Document对象
            Document document = Jsoup.parse(html);
            System.out.println(document);
            // 获取列表
            Elements elements = document.getElementsByClass("list-group-item");
            StringBuilder content = new StringBuilder();
            for (Element element : elements) {
                String title = element.getElementsByClass("package-name").text();
                String description = element.getElementsByClass("package-description").text();
                String itemValue = title + "---" + description + "\n";
                System.out.println(itemValue);
                content.append(itemValue);
            }
            fileWrite("file/text/bootcdn.txt", content.toString(),true);
        }
        httpClient.close();
        response.close();
    }
}
