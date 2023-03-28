package com.fitbum.Fitbum.entidades;
import jakarta.persistence.*;





@Entity

@Table(name="PlantillaMicrociclo")


public class PlantillaMicrociclo {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer 	idMicrocilo;
    private Integer 	idPlantMeso;
    private Float 	volumenEstandar;
    private Float 	intensidadEstandar;
}
