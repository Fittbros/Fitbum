package com.fitbum.Fitbum.controladores;


import jakarta.persistence.*;

@Entity
@Table(name="Usuario")

public class UsuarioController {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;
    private int detalle_usuario_idDetalle_usuario;
    private int roles_idRoles;
    private int admin;
}
