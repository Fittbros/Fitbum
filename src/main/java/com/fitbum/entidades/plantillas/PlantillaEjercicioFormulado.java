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
@Table(name="PlantillaEjercicioFormulado")
public class PlantillaEjercicioFormulado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEjercicio_formulado;
    @Column
    private Integer idPsesion;
    @Column
    private Integer idEjercico;
    private Integer descanso_esp;
    private String nombre_ej;
    private String descripcion;
    private String modific_periodizacion;
}
