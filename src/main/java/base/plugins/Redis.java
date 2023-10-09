package base.plugins;

import redis.clients.jedis.Jedis;

public class Redis {
    private static final String ip = "127.0.0.1";
    private static final Integer port = 6379;

    // 获取连接
    public Jedis connection() throws Exception {
        return new Jedis(ip, port);
    }

    // 为 String添加元素
    public void set(String key, String value) throws Exception {
        Jedis jedis = connection();
        jedis.set(key, value);
        jedis.close();
    }

    // 获取 String
    public String get(String key) throws Exception {
        Jedis jedis = connection();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }
}
