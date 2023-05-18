package com.fitbum.entidades.plantillas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="PlantillaSerie")

public class PlantillaSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer orden;
    @Column
    private Float carga;
    @Column
    private Integer	repes;
    @Column
    private Integer	modifVis;
    @Column
    private Integer	modifInterna;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlantillaEjercicioFormulado")
    private PlantillaEjercicioFormulado plantillaEjercicioFormulado;
}
