package com.fitbum.entidades.usuarios;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.Notificacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Rol")
public class Rol {

    @Id
    private Integer idRol;


    private String nombreRol;

    @JsonManagedReference
    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Usuario> usuario;

}
