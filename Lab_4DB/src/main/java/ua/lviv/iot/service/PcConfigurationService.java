package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.PcConfigurationDAOimp;
import ua.lviv.iot.models.PcConfigurationEntity;

import java.sql.SQLException;
import java.util.List;

public class PcConfigurationService {
    public List<PcConfigurationEntity> findAll() throws SQLException {
        return new PcConfigurationDAOimp().findAll();
    }

    public PcConfigurationEntity findById(final Integer id) throws SQLException {
        return new PcConfigurationDAOimp().findById(id);
    }

    public int create(final PcConfigurationEntity entity) throws SQLException {
        return new PcConfigurationDAOimp().create(entity);
    }

    public int update(final PcConfigurationEntity entity) throws SQLException {
        return new PcConfigurationDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new PcConfigurationDAOimp().delete(id);
    }
}