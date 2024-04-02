package Database;

import basicClass.ClassRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRoomDAO extends BaseDAO {

    public ClassRoomDAO(Connection connection) {
        super(connection);
    }
    public ClassRoomDAO() throws SQLException {super();}

    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof ClassRoom) {
            ClassRoom classRoom = (ClassRoom) obj;
            String query = "INSERT INTO ClassRoom (id,place) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1,classRoom.getId());
                statement.setString(2, classRoom.getPlace());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        if (obj instanceof ClassRoom) {
            ClassRoom classRoom = (ClassRoom) obj;
            String query = "UPDATE ClassRoom SET place = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, classRoom.getPlace());
                statement.setInt(2, classRoom.getId());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        if (obj instanceof ClassRoom) {
            ClassRoom classRoom = (ClassRoom) obj;
            String query = "DELETE FROM ClassRoom WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, classRoom.getId());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public Object findById(int id) throws SQLException {
        ClassRoom classRoom = null;
        String query = "SELECT * FROM ClassRoom WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    classRoom = new ClassRoom();
                    classRoom.setId(resultSet.getInt("id"));
                    classRoom.setPlace(resultSet.getString("place"));
                }
            }
        }

        return classRoom;
    }
}