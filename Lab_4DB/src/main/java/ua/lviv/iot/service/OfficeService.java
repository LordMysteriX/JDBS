package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.OfficeDAOimp;
import ua.lviv.iot.models.OfficeEntity;

import java.sql.SQLException;
import java.util.List;

public class OfficeService {
    public List<OfficeEntity> findAll() throws SQLException {
        return new OfficeDAOimp().findAll();
    }

    public OfficeEntity findById(final Integer id) throws SQLException {
        return new OfficeDAOimp().findById(id);
    }

    public int create(final OfficeEntity entity) throws SQLException {
        return new OfficeDAOimp().create(entity);
    }

    public int update(final OfficeEntity entity) throws SQLException {
        return new OfficeDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new OfficeDAOimp().delete(id);
    }
}