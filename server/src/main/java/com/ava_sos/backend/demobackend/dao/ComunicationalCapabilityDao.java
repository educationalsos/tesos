package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.ComunicationalCapability;

public interface ComunicationalCapabilityDao {
    public void save(ComunicationalCapability entity);

    public void saveAll(List<ComunicationalCapability> entities);

    public void update(ComunicationalCapability entity);

    public void delete(Long id);

    public ComunicationalCapability findById(Long id);

    public List<ComunicationalCapability> findAll();
}
