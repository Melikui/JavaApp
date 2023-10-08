package com.today.base.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClients {
    public static void getHtml(String[] args) throws InterruptedException, IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = org.apache.http.impl.client.HttpClients.createDefault();
        // 创建GET请求
        HttpGet httpGet = new HttpGet("https://blog.csdn.net/weixin_43347659");
        httpGet.setHeader("use-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
        // 获取响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            String html = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(html);
        }
        httpClient.close();
        response.close();
    }
}
