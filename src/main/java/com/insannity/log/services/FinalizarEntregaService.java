package com.insannity.log.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insannity.log.entities.Entrega;
import com.insannity.log.entities.StatusEntrega;
import com.insannity.log.repositories.EntregaRepository;

@Service
public class FinalizarEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar(Long id) {
		Entrega entrega = buscaEntregaService.buscar(id);
		
		entrega.finalizar();
		
		entrega.setStatus(StatusEntrega.FINALIZADA);
		
		entregaRepository.save(entrega);
	}
	
}
