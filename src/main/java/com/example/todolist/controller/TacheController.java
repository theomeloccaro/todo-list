package com.example.todolist.controller;

import com.example.todolist.dao.TacheDao;
import com.example.todolist.model.Tache;
import com.example.todolist.model.Utilisateur;
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
public class TacheController {

    @Autowired
    TacheDao tacheDao;

    @GetMapping("/taches")
    public List<Tache> getAll() {
        return tacheDao.findAll();
    }

    @GetMapping("/taches/priorite")
    public ResponseEntity<List<Tache>> getTachesPriorite() {

        List<Tache> tachesPriorite = tacheDao.findByValideFalseOrderByPrioriteNiveauAsc();

        if (tachesPriorite.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tachesPriorite,HttpStatus.OK);
    }
}
