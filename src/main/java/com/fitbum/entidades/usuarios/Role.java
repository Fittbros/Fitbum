package com.fitbum.entidades.usuarios;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Role")
public class Role {

    @Id
    private Integer idRole;


    private String nombreRole;

    @JsonManagedReference
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Usuario> usuario;



}
