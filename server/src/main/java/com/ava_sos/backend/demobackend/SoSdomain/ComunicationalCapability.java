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
@Table(name = "COMUNICATIONAL_CAPABILITY")
public class ComunicationalCapability extends AbstractEntity<Long> {

    public ComunicationalCapability(String name, Behavior behavior, Boolean satisfied) {
        this.behavior = behavior;
        this.name = name;
        this.satisfied = satisfied;
    }

    @Column(nullable = false, unique = false, length = 60)
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "behavior_id")
    private Behavior behavior;

    @Column(nullable = true, unique = false)
    private Boolean satisfied;

    public ComunicationalCapability() {
    }

    @JsonIgnore
    public Behavior getBehavior() {
        return behavior;
    }

    @JsonProperty("behavior")
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
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

}
