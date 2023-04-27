package com.fitbum.entidades.plantillas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="PlantillaMicrociclo")


public class PlantillaMicrociclo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idPlantMeso;
    @Column
    private Float volumenEstandar;
    @Column
    private Float intensidadEstandar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getVolumenEstandar() {
        return volumenEstandar;
    }

    public void setVolumenEstandar(Float volumenEstandar) {
        this.volumenEstandar = volumenEstandar;
    }

    public Float getIntensidadEstandar() {
        return intensidadEstandar;
    }

    public void setIntensidadEstandar(Float intensidadEstandar) {
        this.intensidadEstandar = intensidadEstandar;
    }
}
