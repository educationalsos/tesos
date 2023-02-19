package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Services;

/**
 * SatkeholdersDao
 */
public interface ServicesDao {

    public void save(Services entity);

    public void saveAll(List<Services> entities);

    public void update(Services entity);

    public void updateAll(List<Services> entities);

    public void delete(Long id);

    public Services findById(Long id);

    public List<Services> findAll();

}