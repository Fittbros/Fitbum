package com.fitbum.entidades.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Rol {

    @Id
    private int idRol;


    private String nombre_rol;
}