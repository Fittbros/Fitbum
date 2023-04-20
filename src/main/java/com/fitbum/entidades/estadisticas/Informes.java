package com.fitbum.entidades.estadisticas;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name="Informes")
public class Informes {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer	idInformes;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha;
    private String	descripcion;
    private String	nombre;
    private Boolean	visibleUsuario;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstadisticas")
    private Estadisticas estadisticas;
}
