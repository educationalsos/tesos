package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Constituent;

/**
 * SosDao
 */
public interface ConstituentDao {

    public void save(Constituent entity);

    public void update(Constituent entity);

    public void delete(Long id);

    public Constituent findById(Long id);

    public List<Constituent> findAll();
}
