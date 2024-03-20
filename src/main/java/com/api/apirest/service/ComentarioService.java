package com.api.apirest.service;

import com.api.apirest.dto.ComentarioDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ComentarioService {
    public ComentarioDto guardarComentario(Long publicacionId, ComentarioDto comentarioDto);
    public List<ComentarioDto> obtenerComentariosPorPublicacion(Long publicacionId);
    public ComentarioDto obtenerComentarioPorIdComentario(Long publicacionId,Long comentarioId);
    public ComentarioDto actualizarComentario(Long publicacionId, Long comentarioId, ComentarioDto solicitudDeComentario);
    public void eliminarComentario(Long publicacionId, Long comentarioId);


}
