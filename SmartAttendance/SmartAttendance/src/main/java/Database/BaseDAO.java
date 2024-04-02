package Database;

//import jdk.internal.misc.Unsafe;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDAO {
    protected Connection connection;

    public BaseDAO(Connection connection) {
        this.connection = connection;
    }

    public BaseDAO() throws SQLException {
        this(DatabaseConnectionManager.getConnection());
    }

    public abstract void insert(Object obj) throws SQLException;

    public abstract void update(Object obj) throws SQLException;

    public abstract void delete(Object obj) throws SQLException;

    public abstract Object findById(int id) throws SQLException;

    public static void closeConnection(Connection conn) {
//        Connection conn= baseDAO.connection;
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

