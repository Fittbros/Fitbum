package com.fitbum.entidades.usuarios;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="Suscripcion")

public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSuscripcion;
    private int idUsuario;
    private LocalDate fechaPago;
    private LocalDate fechaFin;
    private float precio;
    private String codigoDesc;
}
