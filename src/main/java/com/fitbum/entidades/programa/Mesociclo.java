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
@Table(name="Mesociclo")

public class Mesociclo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idUsuario;
    @Column
    private Integer num_micro ;
    @Column
    private Integer fr_entreno ;
    @Column
    private Integer long_micro;
    @Column
    private Integer desc_bas ;
    @Column
    private Integer desc_acc ;
    @Column
    private String descripcion;
    @Column
    private Date fecha_inicio ;
    @Column
    private Date fecha_fin;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name="Usuario",nullable=false)
    private Usuario usuariomesociclo;

    @OneToMany(mappedBy = "Mesociclo", cascade = CascadeType.ALL)
    private Set<Microciclo> meso_microciclo;


    public Integer getId() {return id;}


    public Integer getNum_micro() {return num_micro;}

    public Integer getFr_entreno() {return fr_entreno;}

    public Integer getLong_micro() {return long_micro;}

    public Integer getDesc_acc() {
        return desc_acc;
    }

    public void setDesc_bas(Integer desc_bas) {
        this.desc_bas = desc_bas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }
}
