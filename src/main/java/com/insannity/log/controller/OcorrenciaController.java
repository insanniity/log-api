package com.insannity.log.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insannity.log.dto.OcorrenciaDTO;
import com.insannity.log.entities.Entrega;
import com.insannity.log.entities.Ocorrencia;
import com.insannity.log.input.OcorrenciaInput;
import com.insannity.log.mapper.OcorrenciaMapper;
import com.insannity.log.services.BuscaEntregaService;
import com.insannity.log.services.OcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Autowired
	private OcorrenciaService service;
	
	@Autowired
	private OcorrenciaMapper mapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId,@Valid @RequestBody OcorrenciaInput ocorrencia) {
		Ocorrencia ocorrenciaRegistrada = service.registrar(entregaId, ocorrencia.getDescricao());		
		return mapper.toDto(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaDTO> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return mapper.toListDto(entrega.getOcorrencias());
	}
	
	
}
