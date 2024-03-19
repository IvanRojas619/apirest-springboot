package com.api.apirest.dto;

import java.util.List;

public class PublicacionResponse {
    private Integer numeroDePagina;
    private Integer medidadDePagina;
    private Integer totalElementos;
    private Integer totalPaginas;
    private Boolean ultima;

    public Boolean getUltima() {
        return ultima;
    }

    public void setUltima(Boolean ultima) {
        this.ultima = ultima;
    }

    public Integer getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(Integer totalElementos) {
        this.totalElementos = totalElementos;
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(Integer totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    private List<PublicacionDto> contenido;

    public PublicacionResponse(Integer numeroDePagina, Integer medidadDePagina, List<PublicacionDto> contenido) {
        this.numeroDePagina = numeroDePagina;
        this.medidadDePagina = medidadDePagina;
        this.contenido = contenido;
    }

    public PublicacionResponse() {
    }

    public Integer getNumeroDePagina() {
        return numeroDePagina;
    }

    public void setNumeroDePagina(Integer numeroDePagina) {
        this.numeroDePagina = numeroDePagina;
    }

    public Integer getMedidadDePagina() {
        return medidadDePagina;
    }

    public void setMedidadDePagina(Integer medidadDePagina) {
        this.medidadDePagina = medidadDePagina;
    }

    public List<PublicacionDto> getContenido() {
        return contenido;
    }

    public void setContenido(List<PublicacionDto> contenido) {
        this.contenido = contenido;
    }
}

