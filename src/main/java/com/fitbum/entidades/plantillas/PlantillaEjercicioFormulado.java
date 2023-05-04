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
@Table(name="PlantillaEjercicioFormulado")
public class PlantillaEjercicioFormulado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlantillaSesion")
    private PlantillaSesion plantillaSesion;


    @JsonManagedReference
    @OneToMany(mappedBy = "plantillaEjercicioFormulado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PlantillaSerie> plantillaSerie;

    @Column
    private Integer idEjercicio;
    @Column
    private Integer descanso_esp;
    @Column
    private String nombre_ej;
    @Column
    private String descripcion;
    @Column
    private String modific_periodizacion;

}
