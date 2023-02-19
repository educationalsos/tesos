package com.ava_sos.backend.demobackend.SoScontroller;

import java.util.List;

import com.ava_sos.backend.demobackend.SoSdomain.ComunicationalCapability;
import com.ava_sos.backend.demobackend.SoSservice.ComunicationalCapabilityService;

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
@RequestMapping("/cm_capability")
public class ComunicationalCapabilityController {

    @Autowired
    private ComunicationalCapabilityService cm_capability_service;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public void save(@RequestBody ComunicationalCapability cm_capability) {
        cm_capability_service.save(cm_capability);

    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ComunicationalCapability> findAll() {
        return cm_capability_service.findAll();

    }

    @DeleteMapping("/delete/{serv_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("serv_id") Long serv_id) {
        cm_capability_service.delete(serv_id);
    }

    @GetMapping("/{serv_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ComunicationalCapability findByID(@PathVariable("serv_id") long serv_id) {
        return cm_capability_service.findId(serv_id);

    }

    @PostMapping("/update/{serv_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateComunicationalCapability(@RequestBody ComunicationalCapability cm_capability,
            @PathVariable("serv_id") long serv_id) {
        cm_capability_service.update(cm_capability);
    }

}