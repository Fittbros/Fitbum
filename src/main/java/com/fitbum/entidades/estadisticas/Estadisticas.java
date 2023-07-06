package com.fitbum.entidades.estadisticas;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Estadisticas")
public class Estadisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer	id;
    private String	descripcion;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @JsonManagedReference
    @OneToMany(mappedBy = "estadisticas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Informes> informes;

}
