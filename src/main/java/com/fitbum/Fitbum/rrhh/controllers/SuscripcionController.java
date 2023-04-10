package com.fitbum.Fitbum.rrhh.controllers;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="Suscripción")

public class SuscripcionController {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSuscripcion;
    private int idUsuario;
    private Date fechaPago;
    private Date fechaFin;
    private float precio;
    private String codigoDesc;
}
