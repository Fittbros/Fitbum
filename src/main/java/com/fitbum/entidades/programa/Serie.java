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
@Table(name="Serie")
public class Serie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idEjercicio_form;
    @Column
    private Float carga;
    @Column
    private Integer repes;
    @Column
    private String modif_tecnicos;
    @Column
    private String modif_programacion;

    @ManyToOne
    @JoinColumn (name="EjerForm",nullable=false)
    private Mesociclo ejer_Serie;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCarga() {
        return carga;
    }

    public void setCarga(Float carga) {
        this.carga = carga;
    }

    public Integer getIdEjercicio_form() {
        return idEjercicio_form;
    }

    public void setIdEjercicio_form(Integer idEjercicio_form) {
        this.idEjercicio_form = idEjercicio_form;
    }

    public Integer getRepes() {
        return repes;
    }

    public void setRepes(Integer repes) {
        this.repes = repes;
    }

    public String getModif_programacion() {
        return modif_programacion;
    }

    public void setModif_programacion(String modif_programacion) {
        this.modif_programacion = modif_programacion;
    }

    public String getModif_tecnicos() {
        return modif_tecnicos;
    }

    public void setModif_tecnicos(String modif_tecnicos) {
        this.modif_tecnicos = modif_tecnicos;
    }
}
