package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.StuffDAOimp;
import ua.lviv.iot.models.StuffEntity;

import java.sql.SQLException;
import java.util.List;

public class StuffService {
    public List<StuffEntity> findAll() throws SQLException {
        return new StuffDAOimp().findAll();
    }

    public StuffEntity findById(final Integer id) throws SQLException {
        return new StuffDAOimp().findById(id);
    }

    public int create(final StuffEntity entity) throws SQLException {
        return new StuffDAOimp().create(entity);
    }

    public int update(final StuffEntity entity) throws SQLException {
        return new StuffDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new StuffDAOimp().delete(id);
    }
}