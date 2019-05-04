package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Sos;

/**
 * SosDao
 */
public interface SosDao {

    public void save(Sos entity);	
    
    public void update(Sos entity);
	
	public void delete(Long id);
	
    public Sos findById(Long id);
    
    public List<Sos> findAll();
}