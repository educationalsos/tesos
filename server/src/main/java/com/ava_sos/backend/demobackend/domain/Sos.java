package com.ava_sos.backend.demobackend.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

/**
 * Sos
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SOS")
public class Sos extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = true, length = 60)
    private String description;

    @Column(nullable = true, length = 60)
    private String mkaos_model;

    @OneToMany(mappedBy = "sos", fetch = FetchType.EAGER)
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Stakeholder> stakeholders;

    @OneToMany(mappedBy = "sos", fetch = FetchType.EAGER)
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Mission> missions;

    @OneToMany(mappedBy = "sos", fetch = FetchType.EAGER)
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Behavior> behaviors;

    @OneToMany(mappedBy = "sos", fetch = FetchType.EAGER)
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Constituent> constituents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMkaos_model() {
        return mkaos_model;
    }

    public void setMkaos_model(String mkaos_model) {
        this.mkaos_model = mkaos_model;
    }

    public List<Stakeholder> getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(List<Stakeholder> stakeholders) {
        this.stakeholders = stakeholders;
    }

    public List<Constituent> getConstituents() {
        return constituents;
    }

    public void setConstituents(List<Constituent> constituents) {
        this.constituents = constituents;
    }

    public List<Behavior> getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}