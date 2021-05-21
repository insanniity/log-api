package com.insannity.log.services;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insannity.log.entities.Cliente;
import com.insannity.log.entities.Entrega;
import com.insannity.log.entities.StatusEntrega;
import com.insannity.log.repositories.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EntregaRepository repository;
	
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return repository.save(entrega);
	}
	
}
