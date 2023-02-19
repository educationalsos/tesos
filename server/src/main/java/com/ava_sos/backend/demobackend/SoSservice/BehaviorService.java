package com.ava_sos.backend.demobackend.SoSservice;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Behavior;

/**
 * ConstModelService
 */
public interface BehaviorService {

    public void save(Behavior behavior);

    public void update(Behavior behavior);

    public void delete(Long id);

    public Behavior findId(Long id);

    public List<Behavior> findAll();

    public List<Behavior> findBySos(Long sosId);
}