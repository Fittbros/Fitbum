package com.fitbum.Fitbum.Media.models;

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

@Table(name="Content_tutorial")
public class Content_tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idContent_tutorial;

    private String nombre;
    private String descripcion;
    private String url;




}
