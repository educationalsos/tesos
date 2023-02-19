package com.ava_sos.backend.demobackend.SoScontroller;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Behavior;
import com.ava_sos.backend.demobackend.SoSservice.BehaviorService;

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
@RequestMapping("/behavior")
public class BehaviorController {

    @Autowired
    private BehaviorService behavior_service;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long save(@RequestBody Behavior consts) {
        behavior_service.save(consts);
        return consts.getId();
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Behavior> findAll() {
        return behavior_service.findAll();

    }

    @DeleteMapping("/delete/{behavior_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("behavior_id") Long behavior_id) {
        behavior_service.delete(behavior_id);
    }

    @GetMapping("/{behavior_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Behavior findByID(@PathVariable("behavior_id") long behavior_id) {
        return behavior_service.findId(behavior_id);

    }

    @PostMapping("/update/{behavior_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateBehavior(@RequestBody Behavior behavior, @PathVariable("behavior_id") long behavior_id) {
        behavior_service.update(behavior);
    }

    @GetMapping("/from_sos/{sos_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Behavior> findBySos(@PathVariable("sos_id") long sos_id) {
        return behavior_service.findBySos(sos_id);

    }

}