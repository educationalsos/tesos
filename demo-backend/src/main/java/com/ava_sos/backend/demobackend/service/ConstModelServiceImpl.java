package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.dao.ConstModelDao;
import com.ava_sos.backend.demobackend.domain.ConstModel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * ConstModelServiceImpl
 */
@Service @Transactional
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

    @Override @Transactional(readOnly = true)
    public ConstModel findId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<ConstModel> findAll() {
        return dao.findAll();
    }

    
}