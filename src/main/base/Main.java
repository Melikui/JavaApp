import plugins.MySQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MySQL mysql = new MySQL();
        mysql.dbQuery();
    }
}
