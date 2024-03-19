package com.api.apirest.repository;

import com.api.apirest.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JajaRepository extends JpaRepository<Publicacion,Long> {
}
