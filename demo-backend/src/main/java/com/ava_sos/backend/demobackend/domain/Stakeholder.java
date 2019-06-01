package com.ava_sos.backend.demobackend.domain;

import javax.persistence.*;

/**
 * Stakeholder
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "STAKEHOLDER")
public class Stakeholder extends AbstractEntity<Long> {
    
    @Column(nullable = false, unique = true, length = 30)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}