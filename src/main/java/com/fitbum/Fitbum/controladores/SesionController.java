package com.fitbum.Fitbum.controladores;
import jakarta.persistence.*;

@Entity
@Table(name="Sesion")
public class SesionController {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idSesion;

    private int idMicrociclo;

    private String nombre_variante;
    private String descripcion;
}
