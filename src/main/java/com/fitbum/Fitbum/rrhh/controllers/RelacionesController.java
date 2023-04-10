package com.fitbum.Fitbum.rrhh.controllers;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="Relaciones")

public class RelacionesController {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRelacion;
    private int idEntrenador;
    private int idUser;
    private Date fechainit;
    private Date fechafin;
}
