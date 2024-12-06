package com.example.todolist.security;

import com.example.todolist.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class SecuriteUtilisateur implements UserDetails {
    private Utilisateur utilisateur;

    public SecuriteUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }

    @Override
    public String getUsername() {
        return utilisateur.getPseudo();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> listeAuthority = new ArrayList<>();
        if (this.utilisateur.getDroit().equals("admin")){
            listeAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if (this.utilisateur.getDroit().equals("redacteur")){
            listeAuthority.add(new SimpleGrantedAuthority("ROLE_REDACTEUR"));
        }
        if (this.utilisateur.getDroit().equals("emplo")){
            listeAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return listeAuthority;
    }
}
