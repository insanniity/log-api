package com.insannity.log.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insannity.log.entities.Cliente;
import com.insannity.log.exception.NegocioException;
import com.insannity.log.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = repository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return repository.save(cliente);
	}
	
	@Transactional
	public void excluir (Long id) {
		repository.deleteById(id);
	}
	
	
}
