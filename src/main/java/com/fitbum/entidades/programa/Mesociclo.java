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
    public void setId(Integer id) {this.id = id;}

    public Integer getNum_micro() {return num_micro;}

    public void setNum_micro(Integer num_micro) {
        this.num_micro = num_micro;
    }

    public Integer getFr_entreno() {return fr_entreno;}

    public void setFr_entreno(Integer fr_entreno) {
        this.fr_entreno = fr_entreno;
    }

    public Integer getLong_micro() {return long_micro;}

    public void setLong_micro(Integer long_micro) {
        this.long_micro = long_micro;
    }

    public Integer getDesc_acc() {
        return desc_acc;
    }

    public void setDesc_acc(Integer desc_acc) {
        this.desc_acc = desc_acc;
    }

    public Integer getDesc_bas() {
        return desc_bas;
    }

    public void setDesc_bas(Integer desc_bas) {
        this.desc_bas = desc_bas;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
}
