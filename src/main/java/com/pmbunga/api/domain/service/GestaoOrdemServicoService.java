package com.pmbunga.api.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import com.pmbunga.api.domain.exception.NegocioException;
import com.pmbunga.api.domain.model.Cliente;
import com.pmbunga.api.domain.model.OrdemServico;
import com.pmbunga.api.domain.model.StatusOrdemServico;
import com.pmbunga.api.domain.repository.ClienteRepository;
import com.pmbunga.api.domain.repository.OrdemServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico criar(OrdemServico ordemServico){

         Cliente  cliente = clienteRepository.findById(ordemServico.getCliente().getId())
         .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
       
          ordemServico.setCliente(cliente);
          ordemServico.setStatus(StatusOrdemServico.ABERTA);
          ordemServico.setDataAbertura(OffsetDateTime.now());

   return ordemServicoRepository.save(ordemServico);

    }
    
}
