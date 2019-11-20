package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.EmployerDAOimp;
import ua.lviv.iot.models.EmployerEntity;

import java.sql.SQLException;
import java.util.List;

public class EmployerService {
    public List<EmployerEntity> findAll() throws SQLException {
        return new EmployerDAOimp().findAll();
    }

    public EmployerEntity findById(final Integer id) throws SQLException {
        return new EmployerDAOimp().findById(id);
    }

    public int create(final EmployerEntity entity) throws SQLException {
        return new EmployerDAOimp().create(entity);
    }

    public int update(final EmployerEntity entity) throws SQLException {
        return new EmployerDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new EmployerDAOimp().delete(id);
    }
}