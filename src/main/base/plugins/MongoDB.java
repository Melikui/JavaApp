package plugins;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;


public class MongoDB {
    public static void main(String[] args) {
        /*
         * https://zhuanlan.zhihu.com/p/622185505
         */
        try {
            // 连接到 mongodb 服务
            String url = "mongodb://127.0.0.1:27017";
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(url))
                    .build();
            MongoClient mongoClient = MongoClients.create(mongoClientSettings);
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("spider");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("user");
            System.out.println("集合 test 选择成功");
            /*
              检索所有文档
              1. 获取迭代器FindIterable<Document>
              2. 获取游标MongoCursor<Document>
              3. 通过游标遍历检索出的文档集合
             */
            FindIterable<Document> findIterable = collection.find();
            for (Document document : findIterable) {
                System.out.println(document);
            }
            mongoClient.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
