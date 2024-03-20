package com.api.apirest.service;

import com.api.apirest.dto.ComentarioDto;
import com.api.apirest.exceptions.BlogAppException;
import com.api.apirest.exceptions.ResourceNotFoundException;
import com.api.apirest.model.Comentario;
import com.api.apirest.model.Publicacion;
import com.api.apirest.repository.ComentarioRepository;
import com.api.apirest.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ComentarioDto> obtenerComentariosPorPublicacion(Long publicacionId) {
        List<Comentario> comentarios = comentarioRepository.findByPublicacionId(publicacionId);
        return comentarios.stream().map(comentario -> convertirEntidadAdto(comentario)).collect(Collectors.toList());
    }

    @Override
    public ComentarioDto obtenerComentarioPorIdComentario(Long publicacionId, Long comentarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));

        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if(!comentario.getPublicacion().getId().equals(publicacion.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicación");
        }

        return convertirEntidadAdto(comentario);
    }

    @Override
    public ComentarioDto actualizarComentario(Long publicacionId, Long comentarioId,ComentarioDto solicitudDeComentario) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));

        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if(!comentario.getPublicacion().getId().equals(publicacion.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicación");
        }

// Seteo el comentario con los nuevos valores
        comentario.setCuerpo(solicitudDeComentario.getCuerpo());
        comentario.setEmail(solicitudDeComentario.getEmail());
        comentario.setNombre(solicitudDeComentario.getNombre());
        //Guardo el comentario actualizado
        Comentario comentarioActualizado=comentarioRepository.save(comentario);
        // lo retorno en forma de dto
        return convertirEntidadAdto(comentarioActualizado);


    }

    @Override
    public void eliminarComentario(Long publicacionId, Long comentarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));

        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if(!comentario.getPublicacion().getId().equals(publicacion.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicación");
        }
//Elimino el comentario
        comentarioRepository.delete(comentario);

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
