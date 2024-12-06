package com.example.todolist.controller;

import com.example.todolist.dao.UtilisateurDao;
import com.example.todolist.model.Tache;
import com.example.todolist.model.Utilisateur;
import com.example.todolist.security.SecuriteUtilisateur;
import com.example.todolist.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ConnexionController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UtilisateurDao utilisateurDao;

    @Autowired
    AuthenticationProvider authenticationProvider;

    
    @GetMapping("/test-jwt")
    public String testJwt() {
        return jwtUtils.generationToken("a@a.com");
    }

}
