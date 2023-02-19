package com.ava_sos.backend.demobackend.service;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Constituent;

/**
 * ConstModelService
 */
public interface ConstituentService {

    public void save(Constituent constituent);

    public void update(Constituent constituent);

    public void delete(Long id);

    public Constituent findId(Long id);

    public List<Constituent> findAll();

    public List<Constituent> findBySos(Long sosId);

    public Constituent findByPath(String path);
}