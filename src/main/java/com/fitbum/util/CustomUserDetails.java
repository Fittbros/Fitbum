package com.fitbum.util;

import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
public UsuarioRepositorio usuarioRepositorio;

    public CustomUserDetails(String email, String password, String avatar, Collection<? extends GrantedAuthority> authorities) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// Buscar el usuario por su email utilizando el UserRepository
        Usuario user = usuarioRepositorio.findUsuarioByUsernameAndActiveTrue(username);

// Si el usuario es encontrado, crear una instancia de UserDetails utilizando los datos del usuario
        if (user != null) {
            CustomUserDetails customUserDetails = new CustomUserDetails(
                    user.getEmail(),
                    user.getPassword(),
                    user.getAvatar(),
                    getAuthorities()
            );
            return customUserDetails;

        }else{
// Si el usuario no es encontrado, lanzar una excepción UsernameNotFoundException
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }



}
