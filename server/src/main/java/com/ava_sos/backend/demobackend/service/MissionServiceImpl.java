package com.ava_sos.backend.demobackend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ava_sos.backend.demobackend.dao.MissionDao;
import com.ava_sos.backend.demobackend.domain.Mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MissionServiceImpl
 */
@Service
@Transactional
public class MissionServiceImpl implements MissionService {

    @Autowired
    MissionDao dao;

    @Override
    public void save(Mission mission) {
        dao.save(mission);
    }

    @Override
    public void update(Mission mission) {
        dao.update(mission);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Mission findId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mission> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mission> findBySos(Long sosId) {
        List<Mission> aux = dao.findAll();
        for (Mission behavior : aux) {
            if (behavior.getSos().getId() != sosId)
                aux.remove(behavior);
        }
        return aux;
    }

    @Override
    public void saveAll(List<Mission> missions) {
        dao.saveAll(missions);
    }
}