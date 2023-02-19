package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Stakeholder;

/**
 * SatkeholdersDao
 */
public interface StakeholderDao {

    public void save(Stakeholder entity);

    public void update(Stakeholder entity);

    public void delete(Long id);

    public Stakeholder findById(Long id);

    public List<Stakeholder> findAll();

}