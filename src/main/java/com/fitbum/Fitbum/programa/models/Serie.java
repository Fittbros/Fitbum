package com.fitbum.Fitbum.programa.models;

import jakarta.persistence.*;

@Entity
@Table(name="Serie")
public class Serie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idSerie;

    private int idEjercicio_form;
    private float carga;
    private int repes;

    private String modif_visibles;

    private String modif_interna;

}
