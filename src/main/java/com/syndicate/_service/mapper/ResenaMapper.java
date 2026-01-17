package com.syndicate._service.mapper;

import com.syndicate._service.dto.ResenaRequest;
import com.syndicate._service.dto.ResenaResponse;
import com.syndicate._service.model.Resena;


public class ResenaMapper {

    public static ResenaResponse toResponse(Resena Resena) {
        return ResenaResponse.builder()
                .idResena(Resena.getIdResena())
                .idContratacion(Resena.getIdContratacion())
                .calificacion(Resena.getCalificacion())
                .comentario(Resena.getComentario())
                .fecha(Resena.getFecha())
                .build();
    }

    public static Resena toEntity(ResenaRequest request) {
        Resena Resena = new Resena();
        Resena.setIdContratacion(request.idContratacion());
        Resena.setCalificacion(request.calificacion());
        Resena.setComentario(request.comentario());
        Resena.setFecha(request.fecha());

        return Resena;
    }
}
