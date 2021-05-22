package com.insannity.log.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insannity.log.entities.Entrega;
import com.insannity.log.exception.EntityNotFoundException;
import com.insannity.log.repositories.EntregaRepository;

@Service
public class BuscaEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
		
	}
	
}
