package com.ava_sos.backend.demobackend.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "SERVICES")
public class Services extends AbstractEntity<Long> {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constituent_id")
    private Constituent constituent;

    @Column(nullable = true, unique = false)
    private String link;

    @Column(nullable = false, unique = false, length = 60)
    private String name;

    @Column(nullable = true, unique = false)
    private Boolean satisfied;

    public Services(Constituent constituent, String name, Boolean satisfied) {
        this.constituent = constituent;
        this.name = name;
        this.satisfied = satisfied;
    }

    public Services() {
    }

    @JsonIgnore
    public Constituent getConstituent() {
        return constituent;
    }

    @JsonProperty("constituent")
    public void setConstituent(Constituent constituent) {
        this.constituent = constituent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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