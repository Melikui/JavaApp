package plugins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
    static String driver = "com.mysql.cj.jdbc.Driver"; // MySQL 驱动
    String url = "jdbc:mysql://localhost:3306/likui"; // 数据库链接地址
    String username = "root"; // 用户名
    String password = "melikui"; // 用户密码
    Connection connection; // 连接对象
    Statement statement; // 执行语句

    public MySQL() {
    }

    public MySQL(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void dbConnection() throws SQLException {
        // 1,创建连接
        this.connection = DriverManager.getConnection(url, username, password);
        // 2,创建 Statement: 执行SQL
        this.statement = connection.createStatement();
    }

    public void dbQuery() throws SQLException {
        this.dbConnection();
        String sql = "select * from github";
        ResultSet resultSet = this.statement.executeQuery(sql);
        // 遍历结果
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String value = resultSet.getString(2);
            String brief = resultSet.getString(3);
            System.out.println(id + "---" + value + "---" + brief);
        }
        resultSet.close();
        this.dbClose();
    }

    public void dbClose() throws SQLException {
        this.statement.close();
        this.connection.close();
    }

    public static void main(String[] args) throws SQLException {
        MySQL mysql = new MySQL("jdbc:mysql://localhost:3306/likui", "root", "melikui");
        mysql.dbQuery();
    }

}

