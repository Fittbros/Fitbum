package com.fitbum.Fitbum.entidades;
import jakarta.persistence.*;





@Entity

@Table(name="PlantillaSesion")


public class PlantillaSesion {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer	idSesion;
    private Integer	idPlantMicro;
    private String descripcion;
}
