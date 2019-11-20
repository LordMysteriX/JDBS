package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.PcConfigurationDAO;
import ua.lviv.iot.models.PcConfigurationEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PcConfigurationDAOimp implements PcConfigurationDAO {
    private static final String FIND_ALL = "SELECT * FROM Pc configuration";
    private static final String DELETE = "DELETE FROM Pc configuration WHERE id=?";
    private static final String CREATE = "INSERT INTO Pc configuration (id, Operation system, Videocard, Processor, Motherboard, SSD, Power Supply, Machinery Id) VALUES(?,?,?,?,?,?,?, ?)";
    private static final String UPDATE = "UPDATE Pc configuration SET Operation system=?, Videocard=?, Processor=?, Motherboard=?, SSD=?, Power Supply=?, Machinery Id=?, WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Pc configuration WHERE id=?";

    @Override
    public ArrayList<PcConfigurationEntity> findAll() throws SQLException {
        ArrayList<PcConfigurationEntity> pcConfigurations = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    pcConfigurations.add((PcConfigurationEntity) new Transformer(PcConfigurationEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return pcConfigurations;
    }

    @Override
    public PcConfigurationEntity findById(final Integer id) throws SQLException {
        PcConfigurationEntity pcConfigurationsEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    pcConfigurationsEntity = (PcConfigurationEntity) new Transformer(PcConfigurationEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return pcConfigurationsEntity;
    }

    @Override
    public int create(final PcConfigurationEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getOperationSystem());
            ps.setString(3, entity.getVideocard());
            ps.setString(4, entity.getProcessor());
            ps.setString(5, entity.getMotherboard());
            ps.setString(6, entity.getSsd());
            ps.setString(7, entity.getPowerSupply());
            ps.setInt(8, entity.getMachineryId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final PcConfigurationEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getOperationSystem());
            ps.setString(3, entity.getVideocard());
            ps.setString(4, entity.getProcessor());
            ps.setString(5, entity.getMotherboard());
            ps.setString(6, entity.getSsd());
            ps.setString(7, entity.getPowerSupply());
            ps.setInt(8, entity.getMachineryId());
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