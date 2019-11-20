package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.LocationDAOimp;
import ua.lviv.iot.models.LocationEntity;

import java.sql.SQLException;
import java.util.List;

public class LocationService {
    public List<LocationEntity> findAll() throws SQLException {
        return new LocationDAOimp().findAll();
    }

    public LocationEntity findById(final Integer id) throws SQLException {
        return new LocationDAOimp().findById(id);
    }

    public int create(final LocationEntity entity) throws SQLException {
        return new LocationDAOimp().create(entity);
    }

    public int update(final LocationEntity entity) throws SQLException {
        return new LocationDAOimp().update(entity);
    }

    public int delete(final Integer id) throws SQLException {
        return new LocationDAOimp().delete(id);
    }
}