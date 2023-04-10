package com.fitbum.Fitbum.rrhh.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="Relaciones")

public class Relaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRelacion;
    private int idEntrenador;
    private int idUser;
    private Date fechainit;
    private Date fechafin;
}
