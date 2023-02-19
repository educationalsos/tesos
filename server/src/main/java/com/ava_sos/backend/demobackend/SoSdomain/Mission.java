package com.ava_sos.backend.demobackend.SoSdomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "MISSION")
public class Mission extends AbstractEntity<Long> {

    @Column(nullable = true, unique = false)
    private String name;

    public Mission(String name, Sos sos, Boolean satisfied) {
        this.name = name;
        this.sos = sos;
        this.satisfied = satisfied;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sos_id")
    private Sos sos;

    @Column(nullable = true, unique = false)
    private Boolean satisfied;

    public Mission() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(Boolean satisfied) {
        this.satisfied = satisfied;
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
