package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.EmployerPhoneDAO;
import ua.lviv.iot.models.EmployerPhoneEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployerPhoneDAOimp implements EmployerPhoneDAO {
    private static final String FIND_ALL = "SELECT * FROM Employer phone";
    private static final String DELETE = "DELETE FROM Employer phone WHERE id=?";
    private static final String CREATE = "INSERT INTO Employer phone (id, Employer phone, Employer Id) VALUES(?,?, ?)";
    private static final String UPDATE = "UPDATE Employer phone SET Employer phone=?, Employer Id=?,  WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Employer phone phone WHERE id=?";

    @Override
    public ArrayList<EmployerPhoneEntity> findAll() throws SQLException {
        ArrayList<EmployerPhoneEntity> employersPhones = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    employersPhones.add((EmployerPhoneEntity) new Transformer(EmployerPhoneEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return employersPhones;
    }

    @Override
    public EmployerPhoneEntity findById(final Integer id) throws SQLException {
        EmployerPhoneEntity employerPhoneEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    employerPhoneEntity = (EmployerPhoneEntity) new Transformer(EmployerPhoneEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return employerPhoneEntity;
    }

    @Override
    public int create(final EmployerPhoneEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getEmployerPhone());
            ps.setInt(3, entity.getEmployerId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final EmployerPhoneEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getEmployerPhone());
            ps.setInt(3, entity.getEmployerId());
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