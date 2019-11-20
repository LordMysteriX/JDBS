package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.MachineryDAO;
import ua.lviv.iot.models.MachineryEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MachineryDAOimp implements MachineryDAO {
    private static final String FIND_ALL = "SELECT * FROM Machinery";
    private static final String DELETE = "DELETE FROM Machinery WHERE id=?";
    private static final String CREATE = "INSERT INTO Machinery (id, Machinery producer, Machinery type, Employer id, Office Id) VALUES(?,?,?,?, ?)";
    private static final String UPDATE = "UPDATE Machinery SET Machinery producer=?, Machinery type=?, Employers id=?, Office Id=?,  WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Machinery WHERE id=?";

    @Override
    public ArrayList<MachineryEntity> findAll() throws SQLException {
        ArrayList<MachineryEntity> machineries = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    machineries.add((MachineryEntity) new Transformer(MachineryEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return machineries;
    }

    @Override
    public MachineryEntity findById(final Integer id) throws SQLException {
        MachineryEntity machineriesEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    machineriesEntity = (MachineryEntity) new Transformer(MachineryEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return machineriesEntity;
    }

    @Override
    public int create(final MachineryEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getMachineryProducer());
            ps.setString(3, entity.getMachineryType());
            ps.setInt(4, entity.getEmployerId());
            ps.setInt(5, entity.getOfficeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final MachineryEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getMachineryProducer());
            ps.setString(3, entity.getMachineryType());
            ps.setInt(4, entity.getEmployerId());
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