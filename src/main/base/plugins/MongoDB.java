package plugins;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoDB {
    private String url = "mongodb://127.0.0.1:27017";
    private String database = "spider";
    private String collectionName = "user";
    private MongoClient mongoClient;

    public MongoDB() {
    }

    public MongoDB(String database, String collection) {
        this.database = database;
        this.collectionName = collection;
    }

    public MongoDB(String url, String database, String collection) {
        this.url = url;
        this.database = database;
        this.collectionName = collection;
    }

    /**
     * 连接到 mongodb 服务
     * <a href="https://zhuanlan.zhihu.com/p/622185505"></a>
     */
    public void connection() {
        try {
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(this.url))
                    .build();
            this.mongoClient = MongoClients.create(mongoClientSettings);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 查询
     */
    public void query() {
        this.connection();
        MongoDatabase mongoDatabase = this.mongoClient.getDatabase(this.database);
        MongoCollection<Document> collection = mongoDatabase.getCollection(this.collectionName);
        for (Document document : collection.find()) {
            System.out.println(document);
        }
        this.close();
    }

    /**
     * 关闭数据库
     */
    public void close() {
        this.mongoClient.close();
    }

    public static void main(String[] args) {
        MongoDB mongodb = new MongoDB();
        mongodb.query();
    }
}
