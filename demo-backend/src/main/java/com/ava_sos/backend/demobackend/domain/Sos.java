package com.ava_sos.backend.demobackend.domain;

import javax.persistence.*;

/**
 * Sos
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SOS")
public class Sos extends AbstractEntity<Long>{
    
    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false, unique = true, length = 60)
    private String description;

    @Column(nullable = false, unique = true, length = 60)
    private String mkaos_model;

    @Column(nullable = false, unique = false, length = 60)
    private String constituent_model;


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

    public String getConstituent_model() {
        return constituent_model;
    }

    public void setConstituent_model(String constituent_model) {
        this.constituent_model = constituent_model;
    }
}