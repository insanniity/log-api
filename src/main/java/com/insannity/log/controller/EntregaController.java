package com.insannity.log.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insannity.log.dto.EntregaDTO;
import com.insannity.log.entities.Entrega;
import com.insannity.log.input.EntregaInput;
import com.insannity.log.mapper.EntregaMapper;
import com.insannity.log.repositories.EntregaRepository;
import com.insannity.log.services.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	private SolicitacaoEntregaService service;
	
	@Autowired
	private EntregaRepository repository;
	
	@Autowired
	private EntregaMapper mapper;
	
	
	@GetMapping
    public List<EntregaDTO> listar(){
       return mapper.toListDto(repository.findAll());
    }
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {		
		Entrega novaEntrega = mapper.toEntity(entregaInput);		
		Entrega entregaSolicitada = service.solicitar(novaEntrega);
		return mapper.toDto(entregaSolicitada);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> buscar (@PathVariable Long id) {
		return repository.findById(id).map(entrega -> ResponseEntity.ok(mapper.toDto(entrega))).orElse(ResponseEntity.notFound().build());		
	}
	
	
}
