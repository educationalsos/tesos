package com.ava_sos.backend.demobackend.web.controller;

import java.util.List;

import com.ava_sos.backend.demobackend.domain.ConstModel;
import com.ava_sos.backend.demobackend.domain.Sos;

import com.ava_sos.backend.demobackend.service.ConstModelService;
import com.ava_sos.backend.demobackend.service.SosService;


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
@RequestMapping("/const_model")
public class ConstModelController {
    
    @Autowired  
    private ConstModelService const_service;  

    @Autowired
    private SosService sos_service;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")  
    public void save(@RequestBody ConstModel consts) {  
        Sos aux = sos_service.findLast();
        consts.setSos(aux);
        const_service.save(consts);  

    }  
      
    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ConstModel> findAll() {  
        return const_service.findAll();

    }

    @DeleteMapping("/delete/{const_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("const_id") Long const_id) {
        const_service.delete(const_id);
    }

    @GetMapping("/{const_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ConstModel findByID(@PathVariable("const_id") long const_id) {
        return const_service.findId(const_id);
          
    }  
      
    @PostMapping("/update/{const_id}")  
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateConstModel(@RequestBody ConstModel consts,@PathVariable("const_id") long const_id) {    
        const_service.update(consts);  
    }  

    @GetMapping("/from_sos/{sos_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ConstModel> findBySos(@PathVariable("sos_id") long sos_id) {
        return const_service.findBySos(sos_id);
          
    }  

}