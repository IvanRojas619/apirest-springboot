package com.api.apirest.dto;

import com.api.apirest.model.Comentario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class PublicacionDto {
    private Long id;

    @NotEmpty

    @Size(min = 2,message = "El titulo de la publicación deberia tener al menos 2 caracteres")
    private String titulo;

    @NotEmpty
    @Size(min = 10,message = "La descripción de la publicación deberia tener al menos 10 caracteres")
    private String descripcion;

    @NotEmpty
    private String contenido;

    private Set<Comentario> comentarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public PublicacionDto() {
        super();
    }
}
