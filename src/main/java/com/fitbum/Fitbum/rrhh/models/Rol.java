package com.fitbum.Fitbum.rrhh.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Rol {

    @Id
    private int idRol;


    private String nombre_rol;
}
