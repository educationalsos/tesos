package com.ava_sos.backend.demobackend.dao;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Mission;

public interface MissionDao {

    public void save(Mission entity);

    public void saveAll(List<Mission> entities);

    public void update(Mission entity);

    public void delete(Long id);

    public Mission findById(Long id);

    public List<Mission> findAll();
}
