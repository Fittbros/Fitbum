package com.fitbum.Fitbum.rrhh.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="Suscripción")

public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSuscripcion;
    private int idUsuario;
    private Date fechaPago;
    private Date fechaFin;
    private float precio;
    private String codigoDesc;
}
