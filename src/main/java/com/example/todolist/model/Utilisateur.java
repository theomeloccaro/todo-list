package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String pseudo;
    String password;

    // Tâches créées par l'utilisateur
    @OneToMany(mappedBy = "createur")
    List<Tache> tachesCreees = new ArrayList<>();

    // Tâches affectées à l'utilisateur
    @ManyToMany
    @JoinTable(
            name = "utilisateur_tache",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "tache_id")
    )
    List<Tache> tachesAffectees = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "droit_id") // Lien vers la priorité
    Droit droit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tache> getTachesCreees() {
        return tachesCreees;
    }

    public void setTachesCreees(List<Tache> tachesCreees) {
        this.tachesCreees = tachesCreees;
    }

    public List<Tache> getTachesAffectees() {
        return tachesAffectees;
    }

    public void setTachesAffectees(List<Tache> tachesAffectees) {
        this.tachesAffectees = tachesAffectees;
    }

    public Droit getDroit() {
        return droit;
    }

    public void setDroit(Droit droit) {
        this.droit = droit;
    }
}
