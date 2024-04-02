package Database;

import basicClass.face.FaceInformation;

import java.sql.*;


public class FaceInformationDAO extends BaseDAO {

    public FaceInformationDAO(Connection connection)  {
        super(connection);
    }
    public FaceInformationDAO() throws SQLException {
        this(DatabaseConnectionManager.getConnection());
    }

    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof FaceInformation) {
            FaceInformation faceData = (FaceInformation) obj;
            String query = "INSERT INTO FaceInformation (PhotoPath) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, faceData.getPhotoPath());
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    faceData.setId(rs.getInt(1));
                }
            }
        } else {
            throw new IllegalArgumentException("Object is not an instance of FaceData");
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        if (obj instanceof FaceInformation) {
            FaceInformation faceData = (FaceInformation) obj;
            String query = "UPDATE FaceInformation SET PhotoPath = ? WHERE Id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, faceData.getPhotoPath());
                statement.setInt(2, faceData.getId());
                statement.executeUpdate();
            }
        } else {
            throw new IllegalArgumentException("Object is not an instance of FaceData");
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        if (obj instanceof FaceInformation) {
            FaceInformation faceData = (FaceInformation) obj;
            String query = "DELETE FROM FaceInformation WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, faceData.getId());
                statement.executeUpdate();
            }
        } else {
            throw new IllegalArgumentException("Object is not an instance of FaceData");
        }
    }

    @Override
    public FaceInformation findById(int id) throws SQLException {
        String query = "SELECT * FROM FaceInformation WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int foundId = resultSet.getInt("Id");
                    String photoPath = resultSet.getString("PhotoPath");
                    return new FaceInformation(foundId, photoPath);
                }
            }
        }
        return null;
    }
}