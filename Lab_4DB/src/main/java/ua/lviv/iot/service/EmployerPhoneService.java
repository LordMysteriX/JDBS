package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.EmployerPhoneDAOimp;
import ua.lviv.iot.models.EmployerPhoneEntity;

import java.sql.SQLException;
import java.util.List;

public class EmployerPhoneService {
    public List<EmployerPhoneEntity> findAll() throws SQLException {
        return new EmployerPhoneDAOimp().findAll();
    }

    public EmployerPhoneEntity findById(final Integer id) throws SQLException {
        return new EmployerPhoneDAOimp().findById(id);
    }

    public int create(final EmployerPhoneEntity entity) throws SQLException {
        return new EmployerPhoneDAOimp().create(entity);
    }

    public int update(final EmployerPhoneEntity entity) throws SQLException {
        return new EmployerPhoneDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new EmployerPhoneDAOimp().delete(id);
    }
}