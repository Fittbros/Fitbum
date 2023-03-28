package com.fitbum.Fitbum.entidades;
import jakarta.persistence.*;

import java.sql.Date;


@Entity

@Table(name="PlantillaMesociclo")


public class PlantillaMesociclo {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer 	idMesociclos;
    private Integer 	idEntrenador;
    private Integer 	numMicrociclos;
    private Integer 	frEntreSemana;
    private Integer 	longMicrociclo;
    private String 	descansoBas;
    private String 	descansoAcces;
    private String 	descripcion;
    private Date fechaInicio;
    private Date 	fechaFin;
}
