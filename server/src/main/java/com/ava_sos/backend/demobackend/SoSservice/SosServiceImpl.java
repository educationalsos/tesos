package com.ava_sos.backend.demobackend.SoSservice;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Sos;
import com.ava_sos.backend.demobackend.dao.SosDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SosServiceImpl
 */

@Service
@Transactional
public class SosServiceImpl implements SosService {

    @Autowired
    SosDao dao;

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sos> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
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

    public Sos findLast() {
        List<Sos> list = dao.findAll();
        return list.get(list.size() - 1);
    }

}