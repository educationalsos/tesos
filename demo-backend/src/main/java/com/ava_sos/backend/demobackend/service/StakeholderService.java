package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Stakeholder;

/**
 * Stakeholder
 */
public interface StakeholderService {

    public void save(Stakeholder sos);	
    
    public void update(Stakeholder sos);
	
	public void delete(Long id);
	
    public Stakeholder findId(Long id);
    
    public List<Stakeholder> findAll();

}