package com.fitbum.entidades.programa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.tutoriales.Ejercicios;
import com.fitbum.entidades.usuarios.Usuario;
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
@Table(name="EjercicioForm")
public class EjercicioForm {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


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

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name="idSesion",nullable=false)
    private Sesion sesion;

    @JsonManagedReference
    @OneToMany(mappedBy = "ejercicioForm",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Serie> serie;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEjercicios")
    private Ejercicios ejercicios;



}

