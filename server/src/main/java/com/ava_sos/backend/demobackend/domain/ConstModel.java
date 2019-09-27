package com.ava_sos.backend.demobackend.domain;

import java.util.List;

import javax.persistence.*;

/**
 * ConstModel
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "ConstituintModels")
public class ConstModel extends AbstractEntity<Long> {
    
    @Column(nullable = false, unique = true, length = 30)
    private String file;

    @OneToMany(mappedBy = "model")
    private List<Services> services;

    @ManyToMany(mappedBy = "models")
    private List<Sos> sos;
    

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public List<Sos> getSos() {
        return sos;
    }

    public void setSos(List<Sos> sos) {
        this.sos = sos;
    }

}