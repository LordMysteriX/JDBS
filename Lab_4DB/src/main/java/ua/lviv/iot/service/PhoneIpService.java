package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.PhoneIpDAOimp;
import ua.lviv.iot.models.PhoneIpEntity;

import java.sql.SQLException;
import java.util.List;

public class PhoneIpService {
    public List<PhoneIpEntity> findAll() throws SQLException {
        return new PhoneIpDAOimp().findAll();
    }

    public PhoneIpEntity findById(final Integer id) throws SQLException {
        return new PhoneIpDAOimp().findById(id);
    }

    public int create(final PhoneIpEntity entity) throws SQLException {
        return new PhoneIpDAOimp().create(entity);
    }

    public int update(final PhoneIpEntity entity) throws SQLException {
        return new PhoneIpDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new PhoneIpDAOimp().delete(id);
    }
}