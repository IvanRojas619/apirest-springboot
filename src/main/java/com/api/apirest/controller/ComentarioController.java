package com.api.apirest.controller;

import com.api.apirest.dto.ComentarioDto;
import com.api.apirest.repository.ComentarioRepository;
import com.api.apirest.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@RestController
@RequestMapping("/api/")

public class ComentarioController {
    @Autowired
    ComentarioService comentarioService;
    @PostMapping("publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentarioDto> guardarComentario(@PathVariable( name = "publicacionId")Long publicacionId,
                                                           @RequestBody ComentarioDto comentarioDto){

return new ResponseEntity<>(comentarioService.guardarComentario(publicacionId,comentarioDto), HttpStatus.CREATED);

    }
    @PutMapping("publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public ResponseEntity<ComentarioDto> actualizarComentario(@PathVariable(name="publicacionId")Long publicacionId,
                                                              @PathVariable(name = "comentarioId")Long comentarioId,
                                                              @RequestBody ComentarioDto solicitudComentario){

        ComentarioDto comentarioActualizado = comentarioService.actualizarComentario(publicacionId,comentarioId,solicitudComentario);
        return new ResponseEntity<>(comentarioActualizado,HttpStatus.OK);
    }


    @GetMapping("publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDto> listarComentariosPorIdPublicacion(@PathVariable(name = "publicacionId") long publicacionId){

        return  comentarioService.obtenerComentariosPorPublicacion(publicacionId);

    }

    @GetMapping("publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDto> obtenerComentarioPorId(@PathVariable(value = "publicacionId") Long publicacionId,@PathVariable(value = "id") Long comentarioId){
        ComentarioDto comentarioDto = comentarioService.obtenerComentarioPorIdComentario(publicacionId, comentarioId);
        return new ResponseEntity<>(comentarioDto,HttpStatus.OK);
    }

    @DeleteMapping("publicaciones/{publicacionId}/comentarios/{comentarioId}")

    public ResponseEntity<String> eliminarComentrio(@PathVariable(name = "publicacionId") Long publicacionId,
                                                    @PathVariable(name = "comentarioId") Long comentarioId){

        comentarioService.eliminarComentario(publicacionId,comentarioId);
        return new ResponseEntity<>("Comentario eliminado con éxito!",HttpStatus.OK);

    }



}
