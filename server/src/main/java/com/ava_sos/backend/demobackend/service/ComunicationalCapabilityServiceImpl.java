package com.ava_sos.backend.demobackend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ava_sos.backend.demobackend.dao.ComunicationalCapabilityDao;
import com.ava_sos.backend.demobackend.domain.ComunicationalCapability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ComunicationalCapabilityServiceImpl
 */
@Service
@Transactional
public class ComunicationalCapabilityServiceImpl implements ComunicationalCapabilityService {

    @Autowired
    ComunicationalCapabilityDao dao;

    @Override
    public void save(ComunicationalCapability cmCapability) {
        dao.save(cmCapability);
    }

    @Override
    public void update(ComunicationalCapability cmCapability) {
        ComunicationalCapability aux = dao.findById(cmCapability.getId());
        cmCapability.setBehavior(aux.getBehavior());
        dao.update(cmCapability);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ComunicationalCapability findId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComunicationalCapability> findAll() {
        return dao.findAll();
    }

    @Override
    public void saveAll(List<ComunicationalCapability> cmCapabilities) {
        dao.saveAll(cmCapabilities);
    }

}