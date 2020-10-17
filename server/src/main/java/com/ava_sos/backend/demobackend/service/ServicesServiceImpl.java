package com.ava_sos.backend.demobackend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ava_sos.backend.demobackend.dao.ServicesDao;
import com.ava_sos.backend.demobackend.domain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServicesServiceImpl
 */
@Service
@Transactional
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServicesDao dao;

    @Override
    public void save(Services serv) {
        dao.save(serv);
    }

    @Override
    public void update(Services serv) {
        dao.update(serv);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Services findId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Services> findAll() {
        return dao.findAll();
    }

    @Override
    public void saveAll(List<Services> servs) {
        dao.saveAll(servs);

    }

}