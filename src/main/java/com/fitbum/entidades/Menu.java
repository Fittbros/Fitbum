package com.fitbum.entidades;

import com.fitbum.entidades.usuarios.Role;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer orden;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "padre",nullable = true)
    private Menu padre;
    private String url;
    private String icon;
    private Integer activo;
    private Integer hijos;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
