package com.fitbum.Fitbum.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;
    private int detalle_usuario_idDetalle_usuario;
    private int roles_idRoles;
    private int admin;
}
