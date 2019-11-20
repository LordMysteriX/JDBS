package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.OfficeDAO;
import ua.lviv.iot.models.OfficeEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfficeDAOimp implements OfficeDAO {
    private static final String FIND_ALL = "SELECT * FROM Office";
    private static final String DELETE = "DELETE FROM Office WHERE id=?";
    private static final String CREATE = "INSERT INTO Office (id, Office name, Count of Workspace, Count of Computers, Count of Laptops, Count of Routers, Count of Printers) VALUES(?,?,?,?,?,?, ?)";
    private static final String UPDATE = "UPDATE Office SET Office name=?, Count of Workspace=?,  Count of Computers=?, Count of laptops=?, Count of routers=?, Count of printers=?,  WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Office WHERE id=?";

    @Override
    public ArrayList<OfficeEntity> findAll() throws SQLException {
        ArrayList<OfficeEntity> offices = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    offices.add((OfficeEntity) new Transformer(OfficeEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return offices;
    }

    @Override
    public OfficeEntity findById(final Integer id) throws SQLException {
        OfficeEntity officesEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    officesEntity = (OfficeEntity) new Transformer(OfficeEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return officesEntity;
    }

    @Override
    public int create(final OfficeEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getOfficeName());
            ps.setInt(3, entity.getCountOfWorkspace());
            ps.setInt(4, entity.getCountOfComputers());
            ps.setInt(5, entity.getCountOfLaptops());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final OfficeEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getOfficeName());
            ps.setInt(3, entity.getCountOfWorkspace());
            ps.setInt(4, entity.getCountOfComputers());
            ps.setInt(5, entity.getCountOfLaptops());;
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