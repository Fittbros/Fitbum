package com.fitbum.Fitbum.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="Relaciones")

public class Relaciones {

    private int idRelacion;
    private int idEntrenador;
    private int idUser;
    private Date fechainit;
    private Date fechafin;
}
