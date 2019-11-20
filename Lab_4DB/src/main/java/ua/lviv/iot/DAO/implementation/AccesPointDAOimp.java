package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.AccesPointDAO;
import ua.lviv.iot.models.AccesPointEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesPointDAOimp implements AccesPointDAO {
    private static final String FIND_ALL = "SELECT * FROM AccesPoint";
    private static final String DELETE = "DELETE FROM AccesPoint WHERE id=?";
    private static final String CREATE = "INSERT INTO AccesPoint (id, Ip adress, Wifi Password, Name, Machinery Ip) VALUES(?,?,?,?, ?)";
    private static final String UPDATE = "UPDATE AccesPoint SET ip adress=?, Wifi Password=?, Name=?, Machinery Ip=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM AccesPoint WHERE id=?";

    @Override
    public ArrayList<AccesPointEntity> findAll() throws SQLException {
        ArrayList<AccesPointEntity> accessPoints = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    accessPoints.add((AccesPointEntity) new Transformer(AccesPointEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return accessPoints;
    }

    @Override
    public AccesPointEntity findById(final Integer id) throws SQLException {
        AccesPointEntity accesPointEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    accesPointEntity = (AccesPointEntity) new Transformer(AccesPointEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return accesPointEntity;
    }

    @Override
    public int create(final AccesPointEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getIpAdress());
            ps.setString(3, entity.getWifiPassword());
            ps.setString(4,entity.getName());
            ps.setInt(5, entity.getMachineryIp());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final AccesPointEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getIpAdress());
            ps.setString(3, entity.getWifiPassword());
            ps.setString(4,entity.getName());
            ps.setInt(5, entity.getMachineryIp());
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