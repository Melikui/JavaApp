package example;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

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
            JSONArray users = JSONObject.parseObject(responseJson).getJSONArray("items");
            for (Object user : users) {
                System.out.println(new JSONParser(user.toString()).parseObject().get("avatar_url"));
                System.out.println(JSONObject.parseObject(user.toString()).get("gists_url"));
            }
        }
        httpClient.close();
        response.close();
    }
}
