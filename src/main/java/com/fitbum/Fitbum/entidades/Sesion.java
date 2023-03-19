package com.fitbum.Fitbum.entidades;
import jakarta.persistence.*;

@Entity
@Table(name="Sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idSesion;

    private int idMicrociclo;

    private String nombre_variante;
    private String descripcion;
}
