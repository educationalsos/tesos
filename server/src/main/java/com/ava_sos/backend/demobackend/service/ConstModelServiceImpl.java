package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.dao.ConstModelDao;
import com.ava_sos.backend.demobackend.domain.ConstModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * ConstModelServiceImpl
 */
@Service @Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class ConstModelServiceImpl implements ConstModelService {

    @Autowired
    ConstModelDao dao;

    @Override
    public void save(ConstModel model) {
        dao.save(model);
    }

    @Override
    public void update(ConstModel model) {
        dao.update(model);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public ConstModel findId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<ConstModel> findAll() {
        return dao.findAll();
    }

    @Override @Transactional(readOnly = true)
    public List<ConstModel> findBySos(Long sosId) {
        List<ConstModel> aux = dao.findAll();
        for (ConstModel model : aux) {
            if (model.getSos().getId() != sosId)
                aux.remove(model);    
        }
        return aux;
    }
    
    @Override @Transactional(readOnly = true)
    public ConstModel findByPath(String path) {
        List<ConstModel> aux = dao.findAll();
        for (ConstModel model : aux) {
            if (model.getPath().equals(path))
                return model;    
        }
        return null;
    }
    
}