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
@Table(name="PlantillaSesion")


public class PlantillaSesion {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer	idSesion;
    private Integer	idPlantMicro;
    private String descripcion;
}
