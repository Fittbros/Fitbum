package com.fitbum.Fitbum.plantillas.models;
import jakarta.persistence.*;





@Entity

@Table(name="PlantillaEjercicioFormulado")


public class PlantillaEjercicioFormulado {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer 	idEjercicio_formulado;
    private Integer 	idPsesion;
    private Integer 	idEjercico;
    private Integer 	descanso_esp;
    private String 	nombre_ej;
    private String 	descripcion;
    private String modific_periodizacion;
}
