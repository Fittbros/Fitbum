package com.fitbum.entidades.plantillas;
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
    private Integer idSerie;
    private Integer	IdPlantEjForm;
    private Float carga;
    private Integer	repes;
    private Integer	modifVis;
    private Integer	modifInterna;
}
