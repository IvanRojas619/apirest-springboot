package com.api.apirest.service;

import com.api.apirest.dto.ComentarioDto;
import com.api.apirest.exceptions.ResourceNotFoundException;
import com.api.apirest.model.Comentario;
import com.api.apirest.model.Publicacion;
import com.api.apirest.repository.ComentarioRepository;
import com.api.apirest.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ComentarioServiceImpl implements  ComentarioService{
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private PublicacionRepository publicacionRepository;
    @Override
    public ComentarioDto guardarComentario(Long publicacionId, ComentarioDto comentarioDto) {
        //Buscar Publicación por id donde voy a agregar el comentario nuevo
        Publicacion publicacionEncontrada = publicacionRepository.findById(publicacionId)
                .orElseThrow(()->  new ResourceNotFoundException("Publicacion","id",publicacionId));
        Comentario comentario = convertirDtoAentidad(comentarioDto);
        //Seteo la publicacion encontrada en el comentario
        comentario.setPublicacion(publicacionEncontrada);
        Comentario comentarioNuevo = comentarioRepository.save(comentario);

        return convertirEntidadAdto(comentarioNuevo);

    }

    private ComentarioDto convertirEntidadAdto(Comentario comentario){
        ComentarioDto comentarioDto = new ComentarioDto();
        comentarioDto.setId(comentario.getId());
        comentarioDto.setEmail(comentario.getEmail());
        comentarioDto.setNombre(comentario.getNombre());
        comentarioDto.setCuerpo(comentario.getCuerpo());
        return comentarioDto;

    }

    private Comentario convertirDtoAentidad(ComentarioDto comentarioDto){

        Comentario comentario = new Comentario();
        comentario.setId(comentarioDto.getId());
        comentario.setNombre(comentarioDto.getNombre());
        comentario.setEmail(comentarioDto.getEmail());
        comentario.setCuerpo(comentarioDto.getCuerpo());
        return comentario;
    }


}
