package com.fitbum.Fitbum.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="Suscripción")

public class Suscripcion {

    private int idSuscripcion;
    private int idUsuario;
    private Date fechaPago;
    private Date fechaFin;
    private int precio;
    private String codigoDesc;
}
