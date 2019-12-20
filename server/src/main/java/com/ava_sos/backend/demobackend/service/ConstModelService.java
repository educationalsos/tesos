package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.ConstModel;

/**
 * ConstModelService
 */
public interface ConstModelService {

    public void save(ConstModel model);	
    
    public void update(ConstModel model);
	
	public void delete(Long id);
	
    public ConstModel findId(Long id);
    
    public List<ConstModel> findAll();

    public List<ConstModel> findBySos(Long sosId);

    public ConstModel findByPath(String path);
}