package com.fitbum.dto;

import com.fitbum.entidades.usuarios.Rol;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private long id;

    private String email;

    private String nombreUsuario;

    private String nombreEmail;

    private Set<Rol> roles = new HashSet<>();
}