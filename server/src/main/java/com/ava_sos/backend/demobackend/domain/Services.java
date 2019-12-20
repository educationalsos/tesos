package com.ava_sos.backend.demobackend.domain;

import javax.persistence.*;



@SuppressWarnings("serial")
@Entity
@Table(name = "Services")
public class Services extends AbstractEntity<Long> {

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name = "model_id")
    private ConstModel model;

    @Column(nullable = false, unique = true, length = 100)
    private String link;

    @Column(nullable = false, unique = false, length = 60)
    private String name;

    public ConstModel getModel() {
        return model;
    }

    public void setModel(ConstModel model) {
        this.model = model;
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
    
}