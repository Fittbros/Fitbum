package com.fitbum.entidades.tutoriales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="ContentTutorial")
public class ContentTutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idContentTutorial;

    private String nombre;
    private String descripcion;
    private String url;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejercicio")
    private Ejercicios ejercicios;




}
