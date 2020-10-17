package com.ava_sos.backend.demobackend.web.controller;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.Stakeholder;
import com.ava_sos.backend.demobackend.service.StakeholderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stakeholder")
public class StakeholderController {

    @Autowired
    private StakeholderService stake_service;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public void save(@RequestBody Stakeholder stake) {
        stake_service.save(stake);

    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Stakeholder> findAll() {
        return stake_service.findAll();

    }

    @DeleteMapping("/delete/{stakeholder_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("stakeholder_id") Long stakeholder_id) {
        stake_service.delete(stakeholder_id);
    }

    @GetMapping("/{stakeholder_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Stakeholder findByID(@PathVariable("stakeholder_id") long stakeholder_id) {
        return stake_service.findId(stakeholder_id);

    }

    @PostMapping("/update/{stakeholder_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateStakeholder(@RequestBody Stakeholder stake, @PathVariable("stakeholder_id") long stakeholder_id) {
        stake_service.update(stake);
    }

}