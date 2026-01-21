package com.syndicate._service.security.model;

import com.syndicate._service.model.Usuario;
import com.syndicate._service.model.UsuarioRol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioSecurity implements UserDetails {

    private final Usuario usuario;

    public UsuarioSecurity(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UsuarioRol rol = usuario.getRol();
        return List.of(new SimpleGrantedAuthority("ROLE_" + rol.name()));
    }

    @Override public String getPassword() {
        return usuario.getPassword_hash();
    }
    @Override public String getUsername() {
        return usuario.getEmail();
    }
    public Usuario getUsuario() {
        return usuario;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
}
