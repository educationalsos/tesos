package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.dao.SosDao;
import com.ava_sos.backend.demobackend.domain.Sos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SosServiceImpl
 */

@Service @Transactional
public class SosServiceImpl implements SosService {

    SosDao dao;
    
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Sos> findAll() {
        return dao.findAll();
    }

    @Override @Transactional(readOnly = true)
    public Sos findId(Long id) {
        return dao.findById(id);
    }

    @Override
    public void save(Sos sos) {
        dao.save(sos);
    }

    @Override
    public void update(Sos sos) {
        dao.update(sos);
    }

    
}