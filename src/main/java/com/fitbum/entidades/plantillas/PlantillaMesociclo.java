package com.fitbum.entidades.plantillas;
import jakarta.persistence.*;

import java.sql.Date;


@Entity

@Table(name="PlantillaMesociclo")


public class PlantillaMesociclo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer idMesociclos;

    @Column
    private Integer idEntrenador;

    @Column
    private Integer numMicrociclos;

    @Column
    private Integer frEntreSemana;

    @Column
    private Integer longMicrociclo;

    @Column
    private String 	descansoBas;

    @Column
    private String 	descansoAcces;

    @Column
    private String 	descripcion;

    @Column
    private Date fechaInicio;

    @Column
    private Date 	fechaFin;
}
