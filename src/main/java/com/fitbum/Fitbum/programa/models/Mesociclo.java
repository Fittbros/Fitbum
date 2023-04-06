package com.fitbum.Fitbum.programa.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="Mesociclo")

public class Mesociclo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idMesociclo;

    private int idUsuario;

    private int num_microciclos;

    private int fr_entr_sem;

    private int long_microciclo;

    private String descanso_basi;

    private String descanso_acces;

    private String descripcion;

    private Date fecha_inicio;

    private Date fecha_fin;

}
