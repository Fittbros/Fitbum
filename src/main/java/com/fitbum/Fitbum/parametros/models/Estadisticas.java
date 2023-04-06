package com.fitbum.Fitbum.parametros.models;


import jakarta.persistence.*;

@Entity

@Table(name="Estadisticas")
public class Estadisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer	idEstadisticas;
    private String	descripcion;
    private Integer	idUsuario;
    private Integer	InformesIdInformes;


}
