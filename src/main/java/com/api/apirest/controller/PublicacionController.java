package com.api.apirest.controller;

import com.api.apirest.dto.PublicacionDto;
import com.api.apirest.dto.PublicacionResponse;
import com.api.apirest.service.PublicacionService;
import com.api.apirest.utileria.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping()
    public ResponseEntity<PublicacionDto> guardarPublicacion(@Valid@RequestBody PublicacionDto publicacionDto){

        return new ResponseEntity<>(publicacionService.crearPublicacion(publicacionDto), HttpStatus.CREATED);



    }
    @GetMapping("/getall")
    public ResponseEntity<PublicacionResponse>obtenerPublicaciones(@RequestParam(value="pageNo",defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO,required = false) int numeroDePagina,
                                                                   @RequestParam(value = "pageSize",defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO,required = false) int medidaDePagina,
                                                                   @RequestParam(value = "sortBy",defaultValue = AppConstantes.ORDENAR_POR_DEFECTO,required = false) String ordenarPor,
                                                                   @RequestParam(value ="sortDir",defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO,required = false)String sortDir){
        return new ResponseEntity<>(publicacionService.obtenerPubliaciones(numeroDePagina,medidaDePagina,ordenarPor,sortDir),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PublicacionDto> obtenerPublicacionPorId(@PathVariable final Long id) {



            return  ResponseEntity.ok(publicacionService.obtenerPublicacionPorId(id));



    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDto>actualizarPiublicacion(@RequestBody PublicacionDto publicacionDto,@PathVariable(name="id")Long id ){
        PublicacionDto publicacionDtoActualizada = publicacionService.editarPublicacion(id,publicacionDto);

        return new ResponseEntity<>(publicacionDtoActualizada,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name="id") Long id){
        publicacionService.eliminarPublicacion(id);
        return new ResponseEntity<>(String.format("Publicacion con Id : %s eliminada con exito!",id),HttpStatus.OK);
    }

    @GetMapping("/prueba")
    public ResponseEntity<String> pruebita(@RequestParam(name="name") String name){

        return new ResponseEntity<>(String.format("Hola %s",name),HttpStatus.OK);
    }

}
