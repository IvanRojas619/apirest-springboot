package com.api.apirest.dto;

import com.api.apirest.model.Comentario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public class PublicacionPrueba {

    @NotEmpty
    @Size(min = 2,message = "El titulo de la publicación deberia tener al menos 2 caracteres")
    private String titulo;

    @NotEmpty
    @Size(min = 10,message = "La descripción de la publicación deberia tener al menos 10 caracteres")
    private String descripcion;

    @NotEmpty
    private String contenido;

    private List<ComentarioPrueba> comentarios;

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

    public List<ComentarioPrueba> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioPrueba> comentarios) {
        this.comentarios = comentarios;
    }

    public PublicacionPrueba(){
        super();
    }
}
