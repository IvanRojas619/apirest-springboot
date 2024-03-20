package com.api.apirest.repository;

import com.api.apirest.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
    public List<Comentario> findByPublicacionId(Long publicacionId);
}
