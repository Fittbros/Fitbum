package com.fitbum.entidades.plantillas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="PlantillaMesociclo")

public class PlantillaMesociclo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer idMesociclos;

    @Column
    private Integer idEntrenador;

    @Column
    private Integer numMicrociclos;

    @Column
    private Integer frEntreSemana;

    @Column
    private Integer longMicrociclo;

    @Column
    private String 	descansoBas;

    @Column
    private String 	descansoAcces;

    @Column
    private String 	descripcion;

    @Column
    private Date fechaInicio;

    @Column
    private Date fechaFin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMesociclos() {
        return idMesociclos;
    }

    public void setIdMesociclos(Integer idMesociclos) {
        this.idMesociclos = idMesociclos;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Integer getNumMicrociclos() {
        return numMicrociclos;
    }

    public void setNumMicrociclos(Integer numMicrociclos) {
        this.numMicrociclos = numMicrociclos;
    }

    public Integer getFrEntreSemana() {
        return frEntreSemana;
    }

    public void setFrEntreSemana(Integer frEntreSemana) {
        this.frEntreSemana = frEntreSemana;
    }

    public Integer getLongMicrociclo() {
        return longMicrociclo;
    }

    public void setLongMicrociclo(Integer longMicrociclo) {
        this.longMicrociclo = longMicrociclo;
    }

    public String getDescansoAcces() {
        return descansoAcces;
    }

    public void setDescansoAcces(String descansoAcces) {
        this.descansoAcces = descansoAcces;
    }

    public String getDescansoBas() {
        return descansoBas;
    }

    public void setDescansoBas(String descansoBas) {
        this.descansoBas = descansoBas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
