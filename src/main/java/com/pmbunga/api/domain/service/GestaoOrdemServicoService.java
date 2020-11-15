package com.pmbunga.api.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import com.pmbunga.api.domain.exception.EntidadeNaoEncontradaException;
import com.pmbunga.api.domain.exception.NegocioException;
import com.pmbunga.api.domain.model.Cliente;
import com.pmbunga.api.domain.model.Comentario;
import com.pmbunga.api.domain.model.OrdemServico;
import com.pmbunga.api.domain.model.StatusOrdemServico;
import com.pmbunga.api.domain.repository.ClienteRepository;
import com.pmbunga.api.domain.repository.ComentarioRepository;
import com.pmbunga.api.domain.repository.OrdemServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public OrdemServico criar(OrdemServico ordemServico){

         Cliente  cliente = clienteRepository.findById(ordemServico.getCliente().getId())
         .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
       
          ordemServico.setCliente(cliente);
          ordemServico.setStatus(StatusOrdemServico.ABERTA);
          ordemServico.setDataAbertura(OffsetDateTime.now());

   return ordemServicoRepository.save(ordemServico);

    }


  public void finalizar(Long ordemServicoId){

      OrdemServico ordemServico = buscar(ordemServicoId);

      ordemServico.finalizar();

      ordemServicoRepository.save(ordemServico);

  }


    public Comentario adicionarComentario(Long ordemServicoId,String descricao){
      
        OrdemServico ordemServico = buscar(ordemServicoId);
        Comentario comentario = new Comentario();
        comentario.setDataEnvio(OffsetDateTime.now());
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);

        return comentarioRepository.save(comentario);

    }


    private OrdemServico buscar(Long ordemServicoId){

        return ordemServicoRepository.findById(ordemServicoId)
        .orElseThrow(()  -> new EntidadeNaoEncontradaException("Ordem de Serviço não encontrada"));
    
    
      }
    
    
}
