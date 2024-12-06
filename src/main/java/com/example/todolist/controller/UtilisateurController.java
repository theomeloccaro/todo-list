package com.example.todolist.controller;

import com.example.todolist.dao.UtilisateurDao;
import com.example.todolist.model.Tache;
import com.example.todolist.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UtilisateurController {
    @Autowired
    UtilisateurDao utilisateurDao;



    @GetMapping("/utilisateurs")
    public List<Utilisateur> getAll() {

        return utilisateurDao.findAll();

    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> get(@PathVariable Integer id) {

        //On vérifie que l'utilisateur existe bien dans la base de donnée
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        //si l'utilisateur n'existe pas
        if(optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalUtilisateur.get(),HttpStatus.OK);
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<Tache>> getTacheAffecte(@PathVariable Integer utilisateurId) {

        //On vérifie que l'utilisateur existe bien dans la base de donnée
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(utilisateurId);

        //si l'utilisateur n'existe pas
        if(optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Tache> tachesAffectees = utilisateurDao.findByUtilisateurAffectes(utilisateurId);

        if (tachesAffectees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tachesAffectees,HttpStatus.OK);
    }
}
