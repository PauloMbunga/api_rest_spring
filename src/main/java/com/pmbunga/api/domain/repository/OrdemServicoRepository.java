package com.pmbunga.api.domain.repository;

import com.pmbunga.api.domain.model.OrdemServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico,Long>{

    
    
}
