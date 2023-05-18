
package com.fitbum.entidades.programa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.plantillas.PlantillaMesociclo;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSesion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="Microciclo")
public class Microciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String volumenEstandar;
    @Column
    private String intensidadEstandar;
    @Column
    private Integer orden;


    @ManyToOne
    @JoinColumn(name = "Mesociclo", nullable = false)
    private Mesociclo mesociclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "microciclo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sesion> sesiones;

    public Microciclo(PlantillaMicrociclo plantillaMicrociclo) {
        this.volumenEstandar = plantillaMicrociclo.getVolumenEstandar();
        this.intensidadEstandar = plantillaMicrociclo.getIntensidadEstandar();
        this.orden = plantillaMicrociclo.getOrden();
        List<Sesion> sesiones= new ArrayList<Sesion>();
        for (PlantillaSesion plantillaSesion : plantillaMicrociclo.getPlantillaSesion()) {

            Sesion sesion = new Sesion(plantillaSesion);
            sesiones.add(sesion);
        }

            this.setSesiones(sesiones);
        }
    }

