package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/smart_attendance?useSSL=false";
    private static final String USER = "test";
    private static final String PASSWORD = "123456";

    // 驱动程序类名
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        // 加载驱动程序
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load JDBC driver");
        }

        // 连接数据库
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;

    }
}