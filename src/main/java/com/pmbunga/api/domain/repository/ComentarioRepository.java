package com.pmbunga.api.domain.repository;

import com.pmbunga.api.domain.model.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long>{

   
    
}
