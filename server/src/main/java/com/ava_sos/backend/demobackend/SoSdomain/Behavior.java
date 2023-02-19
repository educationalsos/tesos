package com.ava_sos.backend.demobackend.SoSdomain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "BEHAVIOR")
public class Behavior extends AbstractEntity<Long> {

    @Column(nullable = true, unique = false, length = 100)
    private String name;

    public Behavior(String name, Sos sos) {
        this.name = name;
        this.sos = sos;
    }

    @OneToMany(mappedBy = "behavior", fetch = FetchType.EAGER)
    private List<ComunicationalCapability> cmCapabilities;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sos_id")
    private Sos sos;

    public Behavior() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ComunicationalCapability> getComunicationalCapabilities() {
        return cmCapabilities;
    }

    public void setComunicationalCapabilities(List<ComunicationalCapability> cmCapabilities) {
        this.cmCapabilities = cmCapabilities;
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
