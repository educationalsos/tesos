package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Mission;

/**
 * MissionService
 */
public interface MissionService {

    public void save(Mission mission);

    public void saveAll(List<Mission> mission);

    public void update(Mission mission);

    public void delete(Long id);

    public Mission findId(Long id);

    public List<Mission> findAll();

    public List<Mission> findBySos(Long sosId);

}