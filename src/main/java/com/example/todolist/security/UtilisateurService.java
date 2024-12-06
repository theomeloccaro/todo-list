package com.example.todolist.security;

import com.example.todolist.dao.UtilisateurDao;
import com.example.todolist.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService implements UserDetailsService {
    @Autowired
    UtilisateurDao utilisateurDao;
    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException
    {
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findByPseudo(pseudo);
        if(optionalUtilisateur.isPresent()) {
            return new SecuriteUtilisateur(optionalUtilisateur.get());
        }
        throw new UsernameNotFoundException("Email introuvable");
    }
}
