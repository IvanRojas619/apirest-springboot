package com.api.apirest.repository;

import com.api.apirest.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion,Long> {

}
