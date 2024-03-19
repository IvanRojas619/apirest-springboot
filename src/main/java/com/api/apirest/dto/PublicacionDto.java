package com.api.apirest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PublicacionDto {
    private Long id;
    @NotBlank(message = "El campo debe ir lleno")
    @Size(min = 2,message = "El titulo de la publicación deberia tener al menos 2 caracteres")
    private String titulo;
    @NotEmpty
    @Size(min = 10,message = "La descripción de la publicación deberia tener al menos 10 caracteres")
    private String descripcion;
    @NotEmpty
    private String contenido;

}
