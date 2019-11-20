package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.EmployerDAO;
import ua.lviv.iot.models.EmployerEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployerDAOimp implements EmployerDAO {
    private static final String FIND_ALL = "SELECT * FROM Employer";
    private static final String DELETE = "DELETE FROM Employer WHERE id=?";
    private static final String CREATE = "INSERT INTO employer (id, Employer name, Employer post) VALUES(?,?, ?)";
    private static final String UPDATE = "UPDATE Employer SET Employer name=?, Employer post=?,  WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Employer WHERE id=?";

    @Override
    public ArrayList<EmployerEntity> findAll() throws SQLException {
        ArrayList<EmployerEntity> employers = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    employers.add((EmployerEntity) new Transformer(EmployerEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return employers;
    }

    @Override
    public EmployerEntity findById(final Integer id) throws SQLException {
        EmployerEntity employerEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    employerEntity = (EmployerEntity) new Transformer(EmployerEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return employerEntity;
    }

    @Override
    public int create(final EmployerEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getEmployerName());
            ps.setString(3, entity.getEmployerPost());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final EmployerEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getEmployerName());
            ps.setString(3, entity.getEmployerPost());
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