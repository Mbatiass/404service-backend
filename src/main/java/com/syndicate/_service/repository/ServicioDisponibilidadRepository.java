package com.syndicate._service.repository;

import com.syndicate._service.model.ServicioDisponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServicioDisponibilidadRepository extends JpaRepository<ServicioDisponibilidad, Integer>, JpaSpecificationExecutor<ServicioDisponibilidad> {
}
