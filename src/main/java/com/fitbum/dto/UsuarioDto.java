package com.fitbum.dto;

import com.fitbum.entidades.usuarios.Role;
import jakarta.validation.constraints.NotEmpty;
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

    private Integer id;
@NotEmpty
    private String email;
    @NotEmpty

    private String nombreUsuario;

    private Integer role;
}