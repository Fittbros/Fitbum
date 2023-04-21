package com.fitbum.entidades.tutoriales;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitbum.entidades.Notificacion;
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
   @GeneratedValue(strategy = GenerationType.AUTO)

   private Integer idEjercicio;

   private String nombre;
   private String descripcion;
   private String grupo_muscular;
   private String mascara_gen_progresion;

   @JsonManagedReference
   @OneToMany(mappedBy = "ejercicio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private Set<ContentTutorial> contentTutorial;




}
