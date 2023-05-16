package com.fitbum.entidades.programa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.plantillas.PlantillaMicrociclo;
import com.fitbum.entidades.plantillas.PlantillaSesion;
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
@Table(name="Sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private Integer num_sesion;

    @Column
    private Integer orden;
    @Column
    private String variante;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idMicrociclo", nullable = false)
    private Microciclo microciclo;

    @JsonManagedReference
    @OneToMany(mappedBy = "sesion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EjercicioForm> ejerciciosForm;

    public Sesion(PlantillaSesion plantillaSesion) {
        this.variante = plantillaSesion.getVariante();
        this.num_sesion = plantillaSesion.getNum_sesion();
        this.orden = plantillaSesion.getOrden();

    }
}