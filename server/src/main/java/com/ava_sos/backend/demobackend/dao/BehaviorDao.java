package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Behavior;

public interface BehaviorDao {

    public void save(Behavior entity);

    public void update(Behavior entity);

    public void delete(Long id);

    public Behavior findById(Long id);

    public List<Behavior> findAll();
}
