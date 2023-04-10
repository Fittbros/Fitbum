package com.fitbum.Fitbum.plantillas.models;
import jakarta.persistence.*;





@Entity

@Table(name="PlantillaSerie")


public class PlantillaSerie {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer 	idSerie;
    private Integer	IdPlantEjForm;
    private Float	carga;
    private Integer	repes;
    private Integer	modifVis;
    private Integer	modifInterna;
}
