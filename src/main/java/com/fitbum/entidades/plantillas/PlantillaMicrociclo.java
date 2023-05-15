package com.fitbum.entidades.plantillas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="PlantillaMicrociclo")


public class PlantillaMicrociclo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer orden;
    @Column
    private Float volumenEstandar;
    @Column
    private Float intensidadEstandar;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlantillaMesociclo")
    private PlantillaMesociclo plantillaMesociclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "plantillaMicrociclo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy(value = "orden asc ")
    private List<PlantillaSesion> plantillaSesion;

}
