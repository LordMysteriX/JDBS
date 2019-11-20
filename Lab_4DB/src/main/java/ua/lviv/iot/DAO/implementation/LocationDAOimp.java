package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.LocationDAO;
import ua.lviv.iot.models.LocationEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDAOimp implements LocationDAO {
    private static final String FIND_ALL = "SELECT * FROM Employer phone";
    private static final String DELETE = "DELETE FROM Employer phone WHERE id=?";
    private static final String CREATE = "INSERT INTO Employer phone (id, Country, City, Street, Office Id) VALUES(?,?,?,?, ?)";
    private static final String UPDATE = "UPDATE Employer phone SET Country=?, City=?,Street=?, Office Id=?, WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Employer phone WHERE id=?";

    @Override
    public ArrayList<LocationEntity> findAll() throws SQLException {
        ArrayList<LocationEntity> locations = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    locations.add((LocationEntity) new Transformer(LocationEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return locations;
    }

    @Override
    public LocationEntity findById(final Integer id) throws SQLException {
        LocationEntity locationEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    locationEntity = (LocationEntity) new Transformer(LocationEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return locationEntity;
    }

    @Override
    public int create(final LocationEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getCountry());
            ps.setString(3, entity.getCity());
            ps.setString(4, entity.getStreet());
            ps.setInt(5, entity.getOfficeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final LocationEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getCountry());
            ps.setString(3, entity.getCity());
            ps.setString(4, entity.getStreet());
            ps.setInt(5, entity.getOfficeId());
            return ps.executeUpdate();
        }
    }


    @Override
    public int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}