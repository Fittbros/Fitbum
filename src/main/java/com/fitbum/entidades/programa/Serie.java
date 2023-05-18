package com.fitbum.entidades.programa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSerie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="Serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private Integer orden;
    @Column
    private Float carga;
    @Column

    private Integer repes;
    @Column

    private Integer modifVis;
    @Column

    private Integer modifInterna;
    @Column
    private Boolean completado;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idEjercicioForm", nullable = false)
    private EjercicioForm ejercicioForm;

    public Serie(PlantillaSerie plantillaSerie) {

        this.carga = plantillaSerie.getCarga();
        this.orden = plantillaSerie.getOrden();
        this.repes = plantillaSerie.getRepes();
        this.modifInterna = plantillaSerie.getModifInterna();
        this.modifVis = plantillaSerie.getModifVis();

    }
}