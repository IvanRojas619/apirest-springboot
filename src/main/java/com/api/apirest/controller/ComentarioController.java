package com.api.apirest.controller;

import com.api.apirest.dto.ComentarioDto;
import com.api.apirest.repository.ComentarioRepository;
import com.api.apirest.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
