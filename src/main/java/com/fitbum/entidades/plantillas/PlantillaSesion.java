package com.fitbum.entidades.plantillas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="PlantillaSesion")


public class PlantillaSesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer	id;
    @Column
    private Integer num_sesion;

    @Column
    private Integer orden;
    @Column
    private String variante;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlantillaMicrociclo")
    private PlantillaMicrociclo plantillaMicrociclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "plantillaSesion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PlantillaEjercicioFormulado> plantillaEjercicioFormulado;

}
