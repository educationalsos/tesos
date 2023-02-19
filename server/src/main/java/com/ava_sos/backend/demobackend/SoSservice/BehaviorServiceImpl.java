package com.ava_sos.backend.demobackend.SoSservice;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Behavior;
import com.ava_sos.backend.demobackend.dao.BehaviorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * ConstModelServiceImpl
 */
@Service
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class BehaviorServiceImpl implements BehaviorService {

    @Autowired
    BehaviorDao dao;

    @Override
    public void save(Behavior behavior) {
        dao.save(behavior);
    }

    @Override
    public void update(Behavior behavior) {
        dao.update(behavior);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Behavior findId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Behavior> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Behavior> findBySos(Long sosId) {
        List<Behavior> aux = dao.findAll();
        for (Behavior behavior : aux) {
            if (behavior.getSos().getId() != sosId)
                aux.remove(behavior);
        }
        return aux;
    }
}