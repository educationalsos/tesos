package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.dao.ConstModelDao;
import com.ava_sos.backend.demobackend.domain.ConstModel;


/**
 * ConstModelServiceImpl
 */
public class ConstModelServiceImpl implements ConstModelService {

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

    @Override
    public ConstModel findId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<ConstModel> findAll() {
        return dao.findAll();
    }

    
}