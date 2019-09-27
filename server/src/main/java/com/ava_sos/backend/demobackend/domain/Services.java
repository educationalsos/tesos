package com.ava_sos.backend.demobackend.domain;


import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Services")
public class Services extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ConstModel model;

    @Column(nullable = false, unique = true, length = 30)
    private String link;

    @Column(nullable = false, unique = true, length = 60)
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}