
package com.fitbum.entidades.programa;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="Microciclo")
public class Microciclo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Float volumen_estandar ;
    @Column
    private Float intensidad_estandar ;
   @Column
    private Integer orden;

    @ManyToOne
    @JoinColumn (name="Mesociclo",nullable=false)
    private Mesociclo meso_microciclo;

    @OneToMany(mappedBy = "Microciclo", cascade = CascadeType.ALL)
    private Set<Microciclo> micro_sesion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getVolumen_estandar() {
        return volumen_estandar;
    }

    public void setVolumen_estandar(Float volumen_estandar) {
        this.volumen_estandar = volumen_estandar;
    }

    public void setIntensidad_estandar(Float intensidad_estandar) {
        this.intensidad_estandar = intensidad_estandar;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
