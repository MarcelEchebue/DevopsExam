package com.marcelino.examdevops.marcelino.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
public class VoitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    // Getters
    public Long getId() {
        return id;
    }
    public String getMarque() {
        return marque;
    }
    public String getModele() {
        return modele;
    }
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }

}
