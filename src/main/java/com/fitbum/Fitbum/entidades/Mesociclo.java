package com.fitbum.Fitbum.entidades;



import jakarta.persistence.*;





@Entity

@Table(name="Usuarios")

public class EntidadUsuario {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String name;

    private String email;

}