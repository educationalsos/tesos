package com.ava_sos.backend.demobackend.SoScontroller;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.Mission;
import com.ava_sos.backend.demobackend.SoSservice.MissionService;

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
@RequestMapping("/mission")
public class MissionController {

    @Autowired
    private MissionService mission_service;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long save(@RequestBody Mission mission) {
        mission_service.save(mission);
        return mission.getId();
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Mission> findAll() {
        return mission_service.findAll();

    }

    @DeleteMapping("/delete/{mission_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("mission_id") Long mission_id) {
        mission_service.delete(mission_id);
    }

    @GetMapping("/{mission_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Mission findByID(@PathVariable("mission_id") long mission_id) {
        return mission_service.findId(mission_id);

    }

    @PostMapping("/update/{mission_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateMission(@RequestBody Mission mission, @PathVariable("mission_id") long mission_id) {
        mission_service.update(mission);
    }

    @GetMapping("/from_sos/{sos_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Mission> findBySos(@PathVariable("sos_id") long sos_id) {
        return mission_service.findBySos(sos_id);

    }

}