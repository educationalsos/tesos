package com.ava_sos.backend.demobackend.SoSservice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ava_sos.backend.demobackend.SoSdomain.Stakeholder;
import com.ava_sos.backend.demobackend.dao.StakeholderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StakeholderServiceImpl
 */
@Service
@Transactional
public class StakeholderServiceImpl implements StakeholderService {

    @Autowired
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

    @Override
    @Transactional(readOnly = true)
    public Stakeholder findId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stakeholder> findAll() {

        return dao.findAll();
    }

}