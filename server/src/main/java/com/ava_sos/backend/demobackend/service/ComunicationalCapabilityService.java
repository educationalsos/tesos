package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.ComunicationalCapability;

/**
 * ComunicationalCapabilityService
 */
public interface ComunicationalCapabilityService {

    public void save(ComunicationalCapability cmCapability);

    public void saveAll(List<ComunicationalCapability> cmCapabilities);

    public void update(ComunicationalCapability cmCapability);

    public void delete(Long id);

    public ComunicationalCapability findId(Long id);

    public List<ComunicationalCapability> findAll();

}