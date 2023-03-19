package com.fitbum.Fitbum.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")

public class Usuario {

    private int idUsuario;
    private int detalle_usuario_idDetalle_usuario;
    private int roles_idRoles;
    private int admin;
}
