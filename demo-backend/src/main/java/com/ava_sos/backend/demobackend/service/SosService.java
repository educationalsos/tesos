package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Sos;

/**
 * SosService
 */
public interface SosService {
    
    public void save(Sos sos);	
    
    public void update(Sos sos);
	
	public void delete(Long id);
	
    public Sos findId(Long id);
    
    public List<Sos> findAll();
}