package com.example.todolist.dao;

import com.example.todolist.model.Tache;
import com.example.todolist.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
    @Query("SELECT t FROM Tache t JOIN t.utilisateursAffectes u WHERE u.id = :utilisateurId")
    List<Tache> findByUtilisateurAffectes(@Param("utilisateurId") Integer utilisateurId);

    Optional<Utilisateur> findByPseudo(String pseudo);
}
