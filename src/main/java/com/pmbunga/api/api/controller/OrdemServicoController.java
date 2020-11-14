package com.pmbunga.api.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.pmbunga.api.api.model.OrdemServicoInput;
import com.pmbunga.api.api.model.OrdemServicoModel;
import com.pmbunga.api.domain.model.OrdemServico;
import com.pmbunga.api.domain.repository.OrdemServicoRepository;

import com.pmbunga.api.domain.service.GestaoOrdemServicoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {


    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;


    @Autowired
    private ModelMapper modelMaper;
   
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoModel criar(@Valid @RequestBody OrdemServicoInput ordemServicoInput) { 
        
        OrdemServico ordemServico = toEntity(ordemServicoInput);

        return toModel(gestaoOrdemServicoService.criar(ordemServico));
    }


    @GetMapping
    public List<OrdemServicoModel> listar(){
        return toCollectionModel(ordemServicoRepository.findAll());
    }


    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId){

        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if(ordemServico.isPresent()){
            OrdemServicoModel ordemServicoModel = toModel(ordemServico.get());
          return ResponseEntity.ok(ordemServicoModel);
        }

        return ResponseEntity.notFound().build();

    }

    private OrdemServicoModel toModel(OrdemServico ordemServico){

        return modelMaper.map(ordemServico,OrdemServicoModel.class);
    }



    private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServico){

        return ordensServico.stream()
        .map(ordemServico -> toModel(ordemServico))
        .collect(Collectors.toList());
        
    }


    private OrdemServico toEntity(OrdemServicoInput ordemServicoInput){

        return modelMaper.map(ordemServicoInput,OrdemServico.class);
    }
   
    
}
