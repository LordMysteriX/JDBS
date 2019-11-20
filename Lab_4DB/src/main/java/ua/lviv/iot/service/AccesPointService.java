package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.AccesPointDAOimp;
import ua.lviv.iot.models.AccesPointEntity;

import java.sql.SQLException;
import java.util.List;

public class AccesPointService {
    public List<AccesPointEntity> findAll() throws SQLException {
        return new AccesPointDAOimp().findAll();
    }

    public AccesPointEntity findById(final Integer id) throws SQLException {
        return new AccesPointDAOimp().findById(id);
    }

    public int create(final AccesPointEntity entity) throws SQLException {
        return new AccesPointDAOimp().create(entity);
    }

    public int update(final AccesPointEntity entity) throws SQLException {
        return new AccesPointDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new AccesPointDAOimp().delete(id);
    }
}