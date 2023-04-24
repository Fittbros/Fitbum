package com.fitbum.entidades.programa;
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
@Table(name="Ejercicio_form")
public class Ejercicio_form {

    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEjercicio_form;

    @Column
    private Integer idSesion;
    @Column
    private Integer idEjercicio;

    @Column
    private Integer desc_especif;

    @Column
    private String nombre_ejercicio;
    @Column
    private String descripcion;

    @Column
    private String modific_periodizacion;

    @Column
    private Integer tipo_funcional;

    @ManyToOne
    @JoinColumn (name="Sesion",nullable=false)
    private Mesociclo sesion_ejer;

    @OneToMany(mappedBy = "EjerForm", cascade = CascadeType.ALL)
    private Set<Microciclo> ejer_Serie;
}

