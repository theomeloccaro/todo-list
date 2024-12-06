package com.example.todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String description;
    String nom;
    boolean valide;

    @ManyToOne
    @JoinColumn(name = "createur_id") // Lien vers le créateur
    Utilisateur createur;

    @JsonIgnore
    @ManyToMany(mappedBy = "tachesAffectees") // Relation inverse avec les utilisateurs affectés
    List<Utilisateur> utilisateursAffectes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "priorite_id") // Lien vers la priorité
    Priorite priorite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public List<Utilisateur> getUtilisateursAffectes() {
        return utilisateursAffectes;
    }

    public void setUtilisateursAffectes(List<Utilisateur> utilisateursAffectes) {
        this.utilisateursAffectes = utilisateursAffectes;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
