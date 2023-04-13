package com.fitbum.entidades.estadisticas;

import java.sql.Date;
import jakarta.persistence.*;

@Entity

@Table(name="Informes")
public class Informes {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer	idInformes;
    private Date fecha;
    private String	descripcion;
    private String	nombre;
    private Boolean	visibleUsuario;
}
