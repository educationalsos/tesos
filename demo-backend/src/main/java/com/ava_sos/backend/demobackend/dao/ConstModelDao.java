package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.ConstModel;

/**
 * SosDao
 */
public interface ConstModelDao {

    public void save(ConstModel entity);	
    
    public void update(ConstModel entity);
	
	public void delete(Long id);
	
    public ConstModel findById(Long id);
    
    public List<ConstModel> findAll();
}
