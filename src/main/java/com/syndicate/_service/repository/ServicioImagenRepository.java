package com.syndicate._service.repository;

import com.syndicate._service.model.ServicioImagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServicioImagenRepository extends JpaRepository<ServicioImagen, Integer>, JpaSpecificationExecutor<ServicioImagen> {
}
