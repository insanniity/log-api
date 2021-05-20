package com.insannity.log.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insannity.log.entities.Cliente;
import com.insannity.log.repositories.ClienteRepository;
import com.insannity.log.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
    public List<Cliente> listar(){
       return repository.findByNome("Joao");
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		return repository.findById(id)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente){
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}		
		cliente.setId(id);
		cliente = service.salvar(cliente);
		
		return ResponseEntity.ok(cliente);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
}








