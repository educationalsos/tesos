package com.ava_sos.backend.demobackend.web.controller;

import java.util.List;

import com.ava_sos.backend.demobackend.wrapper.ServiceWrapper;
import com.ava_sos.backend.demobackend.domain.ConstModel;
import com.ava_sos.backend.demobackend.domain.Services;

import com.ava_sos.backend.demobackend.service.ConstModelService;
import com.ava_sos.backend.demobackend.service.ServicesService;

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
@RequestMapping("/services")
public class ServiceController {
    
    @Autowired  
    private ServicesService serv_service;  

    @Autowired
    private ConstModelService const_service;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")  
    public void save(@RequestBody Services serv) {  
        serv_service.save(serv);  

    }  
      
    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Services> findAll() {  
        return serv_service.findAll();

    }

    @DeleteMapping("/delete/{serv_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("serv_id") Long serv_id) {
        serv_service.delete(serv_id);
    }

    @GetMapping("/{serv_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Services findByID(@PathVariable("serv_id") long serv_id) {
        return serv_service.findId(serv_id);
          
    }  
      
    @PostMapping("/update/{serv_id}")  
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateConstModel(@RequestBody Services serv,@PathVariable("serv_id") long serv_id) {    
        serv_service.update(serv);  
    }  

}