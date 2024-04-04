package Database;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    /**
     * 声明数据源，用于配置数据库的链接信息
     */
    private static BasicDataSource dataSource;

    static {
        Properties prop = new Properties();
        InputStream ips = DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //加载配置文件
            prop.load(ips);
            //获取我们在配置文件中配置的driver等信息
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            //创建数据源
            dataSource = new BasicDataSource();
            //设置数据库的连接信息:
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            //设置初始连接数量
            dataSource.setInitialSize(3);
            //设置最大连接数量
            dataSource.setMaxActive(3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                ips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConn() throws SQLException {
        // 从连接池中获取连接
        Connection conn = dataSource.getConnection();
        return conn;
    }

    public static void close(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stat != null) {
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                //打开自动提交
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


