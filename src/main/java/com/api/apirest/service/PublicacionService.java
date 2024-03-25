package com.api.apirest.service;

import com.api.apirest.dto.PublicacionDto;
import com.api.apirest.dto.PublicacionPrueba;
import com.api.apirest.dto.PublicacionResponse;
import com.api.apirest.model.Publicacion;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public interface PublicacionService {
public PublicacionDto crearPublicacion(PublicacionDto publicacionDto);
public PublicacionResponse obtenerPubliaciones(int numeroDePagina, int medidaDePagina, String ordenarPor,String sortDir);
public PublicacionDto obtenerPublicacionPorId(Long id);
public PublicacionDto editarPublicacion(Long id, PublicacionDto publicacionDto);
public void eliminarPublicacion(Long id);
public List<PublicacionPrueba> pruebaChida();




}
