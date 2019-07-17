package com.ava_sos.backend.demobackend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ava_sos.backend.demobackend.dao.StakeholderDao;
import com.ava_sos.backend.demobackend.domain.Stakeholder;

import org.springframework.stereotype.Service;

/**
 * StakeholderServiceImpl
 */
@Service @Transactional
public class StakeholderServiceImpl implements StakeholderService {

    StakeholderDao dao;

    @Override
    public void save(Stakeholder task) {
        dao.save(task);
    }

    @Override
    public void update(Stakeholder task) {
        dao.update(task);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Stakeholder findId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Stakeholder> findAll() {
        return dao.findAll();
    }


    
}