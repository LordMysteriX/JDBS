package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.OfficeHasEmployersDAO;
import ua.lviv.iot.models.OfficeHasEmployersEntity;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfficeHasEmployersDAOimp implements OfficeHasEmployersDAO {
    private static final String FIND_ALL = "SELECT * FROM Office has employers";
    private static final String DELETE = "DELETE FROM Office has employers WHERE id=?";
    private static final String CREATE = "INSERT INTO Office has employers (id, Employers Id) VALUES(?,?)";
    private static final String UPDATE = "UPDATE Office has employers SET Employers Id=?, WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Office has employers WHERE id=?";

    @Override
    public ArrayList<OfficeHasEmployersEntity> findAll() throws SQLException {
        ArrayList<OfficeHasEmployersEntity> officesHasEmployers = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    officesHasEmployers.add((OfficeHasEmployersEntity) new Transformer(OfficeHasEmployersEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return officesHasEmployers;
    }

    @Override
    public OfficeHasEmployersEntity findById(final Integer id) throws SQLException {
        OfficeHasEmployersEntity officesHasEmployersEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    officesHasEmployersEntity = (OfficeHasEmployersEntity) new Transformer(OfficeHasEmployersEntity.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return officesHasEmployersEntity;
    }

    @Override
    public int create(final OfficeHasEmployersEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getEmployerId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(final OfficeHasEmployersEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getEmployerId());
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