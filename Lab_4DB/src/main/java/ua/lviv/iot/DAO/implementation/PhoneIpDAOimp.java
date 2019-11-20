package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.PhoneIpDAO;
import ua.lviv.iot.models.PhoneIpEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneIpDAOimp implements PhoneIpDAO {
    private static final String FIND_ALL = "SELECT * FROM Phone Ip";
    private static final String DELETE = "DELETE FROM Phone Ip WHERE id=?";
    private static final String CREATE = "INSERT INTO Phone Ip (id, Phone Ip, Machinery id) VALUES(?,?, ?)";
    private static final String UPDATE = "UPDATE Phone Ip SET Phone ip=?, Machinery Id=?, WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Phone Ip WHERE id=?";

    @Override
    public ArrayList<PhoneIpEntity> findAll() throws SQLException {
        ArrayList<PhoneIpEntity> phonesIp = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    phonesIp.add((PhoneIpEntity) new Transformer(PhoneIpEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return phonesIp;
    }

    @Override
    public PhoneIpEntity findById(final Integer id) throws SQLException {
        PhoneIpEntity phonesIpEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    phonesIpEntity = (PhoneIpEntity) new Transformer(PhoneIpEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return phonesIpEntity;
    }

    @Override
    public int create(final PhoneIpEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getPhoneIp());
            ps.setInt(3, entity.getMachineryId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final PhoneIpEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getPhoneIp());
            ps.setInt(3, entity.getMachineryId());
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