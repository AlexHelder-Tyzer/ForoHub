package com.alx.foroHub.domain.topico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
    //Long id,
    @NotBlank
    String titulo,
    @NotBlank
    String mensaje
//    @NotNull
//    @Future
//    LocalDateTime fechaCreacion,
//    @NotNull
//    Long autor
) {

    public DatosActualizarTopico(Topico topico){
        this(
                //topico.getId(),
                topico.getTitulo(),
                topico.getMensaje()
//                topico.getFechaCreacion(),
//                topico.getAutor().getId()
        );
    }
}
