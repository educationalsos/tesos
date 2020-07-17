package com.ava_sos.backend.demobackend.web.controller;


import java.util.List;


import com.ava_sos.backend.demobackend.domain.Sos;

import com.ava_sos.backend.demobackend.service.SosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sos")
public class SosController {

    @Autowired
    private SosService sos_service;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long save(@RequestBody Sos sos) {
        sos_service.save(sos);
        return sos.getId();

    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Sos> findAll() {
        return sos_service.findAll();

    }

    @DeleteMapping("/delete/{sos_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("sos_id") Long sos_id) {
        sos_service.delete(sos_id);
    }

    @GetMapping("/{sos_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Sos findByID(@PathVariable("sos_id") long sos_id) {
        return sos_service.findId(sos_id);

    }

    @PostMapping("/update/{sos_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updatesos(@RequestBody Sos sos, @PathVariable("sos_id") long sos_id) {
        sos_service.update(sos);
    }

    

}