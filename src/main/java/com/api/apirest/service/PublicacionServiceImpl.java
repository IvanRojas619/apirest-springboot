package com.api.apirest.service;

import com.api.apirest.dto.PublicacionDto;
import com.api.apirest.dto.PublicacionResponse;
import com.api.apirest.exceptions.ResourceNotFoundException;
import com.api.apirest.model.Publicacion;
import com.api.apirest.repository.JajaRepository;
import com.api.apirest.repository.PublicacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service

public class PublicacionServiceImpl implements PublicacionService{
     @Autowired
    private PublicacionRepository publicacionRepository;
     @Autowired
     private ModelMapper modelMapper;
     private JajaRepository jajaRepository;
    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {


        //Convierto publicacionDto a Publicacion-entidad
        Publicacion publicacion = convertirEntidadDTOaEntidad(publicacionDto);
        //Hago el save y retorno la publicacion creada en un nuevo objeto
        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);

        //Convierto el nuevo objeto en DTO y lo retorno
     PublicacionDto publicacionRespuesta = convertirEntidadAdto(nuevaPublicacion);



        return publicacionRespuesta;

    }

    @Override
    public PublicacionResponse obtenerPubliaciones(int numeroDePagina, int medidaDePagina, String ordenarPor,String sortDir) {
        Sort sort =sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina,medidaDePagina, /*Sort.by(ordenarPor)*/ sort);
        Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);


   //List<Publicacion> publicaciones = (List<Publicacion>) publicacionRepository.findAll(); // Normal retorna lista de publicaciones sin paginar

        List<Publicacion> lista_publicaciones=publicaciones.getContent(); // Lista de publicaciones ya listadol

        List<PublicacionDto> contenido = lista_publicaciones.stream().map(publicacion -> convertirEntidadAdto(publicacion)).collect(Collectors.toList());
        PublicacionResponse publicacionResponse =new PublicacionResponse();
        publicacionResponse.setContenido(contenido);

        publicacionResponse.setNumeroDePagina(publicaciones.getNumber());
        publicacionResponse.setMedidadDePagina(publicaciones.getSize());
        publicacionResponse.setTotalElementos((int) publicaciones.getTotalElements());
        publicacionResponse.setTotalPaginas(publicaciones.getTotalPages());
        publicacionResponse.setUltima(publicaciones.isLast());


return publicacionResponse;

    }

    @Override
    public PublicacionDto obtenerPublicacionPorId(Long id) {
        Publicacion publicacionEncontrada = publicacionRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException("Publicacion","id",id));
return convertirEntidadAdto(publicacionEncontrada);
    }

    @Override
    public PublicacionDto editarPublicacion(Long id, PublicacionDto publicacionDto) {
        Publicacion publicacionAeditar = publicacionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Publicacion","id",id));
        publicacionAeditar.setContenido(publicacionDto.getContenido());
        publicacionAeditar.setDescripcion(publicacionDto.getDescripcion());
        publicacionAeditar.setTitulo(publicacionDto.getTitulo());
       Publicacion publicacionActualizada = publicacionRepository.save(publicacionAeditar);
       return convertirEntidadAdto(publicacionActualizada);


    }

    @Override
    public void eliminarPublicacion(Long id) {
        Publicacion publicacionAeliminar = publicacionRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException("Publicacion","id",id));
        publicacionRepository.delete(publicacionAeliminar);
    }

    public Publicacion convertirEntidadDTOaEntidad(PublicacionDto publicacionDto){

       /* Publicacion publicacion = new Publicacion();
        publicacion.setId(publicacionDto.getId());
        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());*/
        Publicacion publicacion = modelMapper.map(publicacionDto,Publicacion.class); //Implementando ModelMapper para mapear
        return publicacion;
    }

    public PublicacionDto convertirEntidadAdto(Publicacion publicacion){

       /* PublicacionDto publicacionDto = new PublicacionDto();
        publicacionDto.setId(publicacion.getId());
        publicacionDto.setTitulo(publicacion.getTitulo());
        publicacionDto.setDescripcion(publicacion.getDescripcion());
        publicacionDto.setContenido(publicacion.getContenido());*/
        PublicacionDto publicacionDto = modelMapper.map(publicacion,PublicacionDto.class);//Implementado ModelMapper
        return publicacionDto;
    }

}
