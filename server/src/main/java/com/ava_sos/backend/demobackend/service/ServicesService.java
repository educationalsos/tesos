package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Services;

/**
 * ServicesService
 */
public interface ServicesService {

    public void save(Services serv);

    public void saveAll(List<Services> servs);

    public void update(Services serv);

    public void delete(Long id);

    public Services findId(Long id);

    public List<Services> findAll();

}