package com.ava_sos.backend.demobackend.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ConstModel
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "ConstituintModels")
public class ConstModel extends AbstractEntity<Long> {
    
    @Column(nullable = true, unique = false, length = 100)
    private String path;

    @OneToMany(mappedBy = "model", fetch = FetchType.EAGER)
    private List<Services> services;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sos_id")
    private Sos sos;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    @JsonIgnore
    public Sos getSos() {
        return sos;
    }

    @JsonProperty("sos")
    public void setSos(Sos sos) {
        this.sos = sos;
    }

}