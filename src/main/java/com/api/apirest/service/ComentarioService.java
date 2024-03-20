package com.api.apirest.service;

import com.api.apirest.dto.ComentarioDto;
import org.springframework.stereotype.Service;

@Service

public interface ComentarioService {
    public ComentarioDto guardarComentario(Long publicacionId, ComentarioDto comentarioDto);


}
