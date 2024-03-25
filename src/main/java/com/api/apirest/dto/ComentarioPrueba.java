package com.api.apirest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ComentarioPrueba {

    private long id;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")
    private String nombre;

    @NotEmpty(message = "El email no debe ser vacio o nulo")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10,message = "El cuerpo del comentario debe tener al menos 10 caracteres")
    private String cuerpo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public ComentarioPrueba() {
        super();
    }

    public ComentarioPrueba(long id, String nombre, String email, String cuerpo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cuerpo = cuerpo;
    }
}


