package com.ava_sos.backend.demobackend.SoSdomain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stakeholder
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "STAKEHOLDER")
public class Stakeholder extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sos_id")
    private Sos sos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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