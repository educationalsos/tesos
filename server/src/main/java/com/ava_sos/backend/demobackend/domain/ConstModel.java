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
    private String path;

    @OneToMany(mappedBy = "model")
    private List<Services> services;

    @ManyToOne
    @JoinColumn(name = "sos_id")
    private Sos sos;
    
    public String getFile() {
        return path;
    }

    public void setFile(String path) {
        this.path = path;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public Sos getSos() {
        return sos;
    }

    public void setSos(Sos sos) {
        this.sos = sos;
    }

}