package com.fitbum.Fitbum.entidades;
import jakarta.persistence.*;

import java.sql.Date;

@Entity

@Table(name="DetalleUsuario")
public class DetalleUsuario {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer	idDetalleUsuario;
    private String	nombre;
    private String	apellido1;
    private String	apellido2;
    private String	contrasenya;
    private Float	atleta_peso;
    private Float	atleta_altura;
    private Integer	sexo;
    private Date fechaNacim;
}
