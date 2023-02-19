package com.ava_sos.backend.demobackend.SoSservice;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Stakeholder;

/**
 * Stakeholder
 */
public interface StakeholderService {

    public void save(Stakeholder task);

    public void update(Stakeholder task);

    public void delete(Long id);

    public Stakeholder findId(Long id);

    public List<Stakeholder> findAll();

}