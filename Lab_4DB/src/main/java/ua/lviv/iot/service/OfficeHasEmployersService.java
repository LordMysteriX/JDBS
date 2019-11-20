package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.OfficeHasEmployersDAOimp;
import ua.lviv.iot.models.OfficeHasEmployersEntity;

import java.sql.SQLException;
import java.util.List;

public class OfficeHasEmployersService {
    public List<OfficeHasEmployersEntity> findAll() throws SQLException {
        return new OfficeHasEmployersDAOimp().findAll();
    }

    public OfficeHasEmployersEntity findById(final Integer id) throws SQLException {
        return new OfficeHasEmployersDAOimp().findById(id);
    }

    public int create(final OfficeHasEmployersEntity entity) throws SQLException {
        return new OfficeHasEmployersDAOimp().create(entity);
    }

    public int update(final OfficeHasEmployersEntity entity) throws SQLException {
        return new OfficeHasEmployersDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new OfficeHasEmployersDAOimp().delete(id);
    }
}