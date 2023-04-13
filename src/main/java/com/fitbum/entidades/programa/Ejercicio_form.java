package com.fitbum.entidades.programa;
import jakarta.persistence.*;

@Entity
@Table(name="Ejercicio_form")
public class Ejercicio_form {

    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEjercicio_form;

    private int idSesion;

    private int idEjercicio;

    private int desc_especif;

    private String nombre_ejercicio;
    private String descripcion;

    private String modific_periodizacion;
}

