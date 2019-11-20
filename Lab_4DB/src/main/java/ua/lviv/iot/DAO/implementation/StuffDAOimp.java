package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.StuffDAO;
import ua.lviv.iot.models.StuffEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StuffDAOimp implements StuffDAO {
    private static final String FIND_ALL = "SELECT * FROM Stuff";
    private static final String DELETE = "DELETE FROM Stuff WHERE id=?";
    private static final String CREATE = "INSERT INTO Stuff (id, Post name, Stuff name, Office id) VALUES(?,?,?, ?)";
    private static final String UPDATE = "UPDATE Stuff SET  Post name=?, Stuff name=?, Office id=?, WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Stuff WHERE id=?";

    @Override
    public ArrayList<StuffEntity> findAll() throws SQLException {
        ArrayList<StuffEntity> stuffs = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    stuffs.add((StuffEntity) new Transformer(StuffEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return stuffs;
    }

    @Override
    public StuffEntity findById(final Integer id) throws SQLException {
        StuffEntity stuffsEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    stuffsEntity = (StuffEntity) new Transformer(StuffEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return stuffsEntity;
    }

    @Override
    public int create(final StuffEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getPostName());
            ps.setString(3, entity.getStuffName());
            ps.setInt(4, entity.getOfficeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final StuffEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getPostName());
            ps.setString(3, entity.getStuffName());
            ps.setInt(4, entity.getOfficeId());
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