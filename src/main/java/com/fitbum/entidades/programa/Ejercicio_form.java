package com.fitbum.entidades.programa;
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
@Table(name="Ejercicio_form")
public class Ejercicio_form {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idSesion;
    @Column
    private Integer idEjercicio;

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

    @ManyToOne
    @JoinColumn (name="Sesion",nullable=false)
    private Mesociclo sesion_ejer;

    @OneToMany(mappedBy = "EjerForm", cascade = CascadeType.ALL)
    private Set<Microciclo> ejer_Serie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public Integer getDesc_especif() {
        return desc_especif;
    }

    public void setDesc_especif(Integer desc_especif) {
        this.desc_especif = desc_especif;
    }

    public String getNombre_ejercicio() {
        return nombre_ejercicio;
    }

    public void setNombre_ejercicio(String nombre_ejercicio) {
        this.nombre_ejercicio = nombre_ejercicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModific_periodizacion() {
        return modific_periodizacion;
    }

    public void setModific_periodizacion(String modific_periodizacion) {
        this.modific_periodizacion = modific_periodizacion;
    }

    public Integer getTipo_funcional() {
        return tipo_funcional;
    }

    public void setTipo_funcional(Integer tipo_funcional) {
        this.tipo_funcional = tipo_funcional;
    }
}

