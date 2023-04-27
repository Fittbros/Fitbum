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
@Table(name="Sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer idMicrociclo;

    @Column
    private String nombre_variante;
    @Column
    private String descripcion;

    @ManyToOne
    @JoinColumn (name="Microciclo",nullable=false)
    private Mesociclo micro_sesion;

    @OneToMany(mappedBy = "Sesion", cascade = CascadeType.ALL)
    private Set<Microciclo> sesion_ejer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMicrociclo() {
        return idMicrociclo;
    }

    public void setIdMicrociclo(Integer idMicrociclo) {
        this.idMicrociclo = idMicrociclo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_variante() {
        return nombre_variante;
    }

    public void setNombre_variante(String nombre_variante) {
        this.nombre_variante = nombre_variante;
    }
}
