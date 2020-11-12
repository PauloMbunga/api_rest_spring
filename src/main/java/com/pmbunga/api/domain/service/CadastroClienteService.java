package com.pmbunga.api.domain.service;

import com.pmbunga.api.domain.exception.NegocioException;
import com.pmbunga.api.domain.model.Cliente;
import com.pmbunga.api.domain.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroClienteService {
    
@Autowired
private ClienteRepository clienteRepository;

 public Cliente salvar (Cliente cliente){

    Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
       if(clienteExistente != null && !clienteExistente.equals(cliente)){
         
         throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");

       }

       return clienteRepository.save(cliente);

    }

    public void excluir(Long clientId){
        clienteRepository.deleteById(clientId);

    }
    
}
