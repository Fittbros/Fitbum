package com.fitbum.entidades.estadisticas;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;

import java.util.List;

@Entity

@Table(name="Estadisticas")
public class Estadisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer	idEstadisticas;
    private String	descripcion;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @JsonManagedReference
    @OneToMany(mappedBy = "estadisticas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Informes> informes;

}
