package com.ava_sos.backend.demobackend.SoSservice;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Constituent;
import com.ava_sos.backend.demobackend.dao.ConstituentDao;

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
public class ConstituentServiceImpl implements ConstituentService {

    @Autowired
    ConstituentDao dao;

    @Override
    public void save(Constituent constituent) {
        dao.save(constituent);
    }

    @Override
    public void update(Constituent constituent) {
        dao.update(constituent);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Constituent findId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Constituent> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Constituent> findBySos(Long sosId) {
        List<Constituent> aux = dao.findAll();
        for (Constituent constituent : aux) {
            if (constituent.getSos().getId() != sosId)
                aux.remove(constituent);
        }
        return aux;
    }

    @Override
    @Transactional(readOnly = true)
    public Constituent findByPath(String path) {
        List<Constituent> aux = dao.findAll();
        for (Constituent constituent : aux) {
            if (constituent.getPath().equals(path))
                return constituent;
        }
        return null;
    }

}