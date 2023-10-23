package example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class GithubUser {
    public static void main(String[] args) throws IOException, ParseException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建GET请求
        HttpGet httpGet = new HttpGet("https://api.github.com/search/users?q=likui");
        // 获取响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String responseJson = EntityUtils.toString(entity, "UTF-8");
            org.json.JSONArray users =(JSONArray) ((new org.json.JSONObject(responseJson)).get("items"));
            System.out.println(users);
            for (Object user : users) {
                org.json.JSONObject userMap = (JSONObject)user;
                System.out.println(userMap.get("login"));
                System.out.println(userMap.get("url"));
                System.out.println(userMap.get("avatar_url"));
            }
        }
        httpClient.close();
        response.close();
    }
}
