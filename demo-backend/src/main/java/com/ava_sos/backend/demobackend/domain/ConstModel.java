package com.ava_sos.backend.demobackend.domain;

import java.util.List;

import javax.persistence.*;

/**
 * ConstModel
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "ConstituintModels")
public class ConstModel extends AbstractEntity<Long> {
    
    @Column(nullable = false, unique = true, length = 30)
    private String file;

    @Column(nullable = false, unique = true, length = 60)
    private String link;

    @ManyToMany(mappedBy = "models")
    private List<Sos> sos;
    

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}