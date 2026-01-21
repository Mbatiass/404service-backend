package com.syndicate._service.mapper;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.dto.ResenaRequest;
import com.syndicate._service.dto.ResenaResponse;
import com.syndicate._service.model.Contratacion;
import com.syndicate._service.model.Resena;

import java.util.List;

public class ResenaMapper {

    public static ResenaResponse toResponse(Resena Resena) {
        return ResenaResponse.builder()
                .idResena(Resena.getIdResena())
                .idContratacion(Resena.getContratacion().getIdContratacion())
                .calificacion(Resena.getCalificacion())
                .comentario(Resena.getComentario())
                .fecha(Resena.getFecha())
                .build();
    }

    public static Resena toEntity(ResenaRequest request,Contratacion contratacion) {
        Resena Resena = new Resena();
        Resena.setContratacion(contratacion);
        Resena.setCalificacion(request.calificacion());
        Resena.setComentario(request.comentario());
        Resena.setFecha(request.fecha());

        return Resena;
    }
}
