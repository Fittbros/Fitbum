package com.fitbum.entidades.tutoriales;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.Notificacion;
import com.fitbum.entidades.programa.EjercicioForm;
import com.fitbum.entidades.usuarios.DetalleUsuario;
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

@Table(name="Ejercicios")
public class Ejercicios {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Integer idEjercicio;

   private String nombre;
   private String descripcion;
   private String grupo_muscular;
   private String mascara_gen_progresion;

   @JsonManagedReference
   @OneToOne (mappedBy = "ejercicio")
   @PrimaryKeyJoinColumn
   private ContentTutorial contentTutorial;

   @JsonManagedReference
   @OneToMany(mappedBy = "ejercicios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private Set<EjercicioForm> ejercicioForm;






}
