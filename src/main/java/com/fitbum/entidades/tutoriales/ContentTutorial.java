package com.fitbum.entidades.tutoriales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.usuarios.Usuario;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idContentTutorial;

    private String nombre;
    private String descripcion;
    private String url;

    @JsonManagedReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "idEjercicio")
    private Ejercicios ejercicio;




}
