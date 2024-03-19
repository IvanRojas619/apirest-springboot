package com.api.apirest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Publicacion",uniqueConstraints = {@UniqueConstraint(columnNames ={"Titulo"})})
public class Publicacion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;
    @Column(name="Titulo",nullable = false)
    private String titulo;

    @Column(name="Descripcion",nullable = false)
    private String descripcion;

    @Column(name="Contenido",nullable = false)
    private String contenido;

    @OneToMany(mappedBy = "publicacion",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comentario> comentarios = new HashSet<>();

}
