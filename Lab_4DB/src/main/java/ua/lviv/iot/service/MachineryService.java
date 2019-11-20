package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.MachineryDAOimp;
import ua.lviv.iot.models.MachineryEntity;

import java.sql.SQLException;
import java.util.List;

public class MachineryService {
    public List<MachineryEntity> findAll() throws SQLException {
        return new MachineryDAOimp().findAll();
    }

    public MachineryEntity findById(final Integer id) throws SQLException {
        return new MachineryDAOimp().findById(id);
    }

    public int create(final MachineryEntity entity) throws SQLException {
        return new MachineryDAOimp().create(entity);
    }

    public int update(final MachineryEntity entity) throws SQLException {
        return new MachineryDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new MachineryDAOimp().delete(id);
    }
}