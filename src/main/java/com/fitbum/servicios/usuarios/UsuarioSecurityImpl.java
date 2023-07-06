package com.fitbum.servicios.usuarios;



import com.fitbum.entidades.usuarios.Usuario;
import com.fitbum.repositorios.usuarios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioSecurityImpl implements IUsuarioServicio, UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder1;




    @Override
    public String getEncodedPassword(Usuario usuario) {
        String passwd = usuario.getPassword();
        String encodedPassword = passwordEncoder1.encode(passwd);
        return encodedPassword;
    }

@Autowired
public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername username : " + username);
        Usuario  usuario= usuarioRepositorio.findUsuarioByUsernameAndActiveTrue(username);
        System.out.println("loadUserByUsername usuario : " + usuario.getUsername());

        org.springframework.security.core.userdetails.User springUser=null;

        Set<GrantedAuthority> ga = new HashSet<>();
        ga.add(new SimpleGrantedAuthority(usuario.getRole().getNombreRole()));

        springUser = new org.springframework.security.core.userdetails.User(
                username,
                usuario.getPassword(),
                ga );
        return springUser;
    }
}


