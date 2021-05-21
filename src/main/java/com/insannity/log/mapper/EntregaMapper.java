package com.insannity.log.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.insannity.log.dto.EntregaDTO;
import com.insannity.log.entities.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {
	
	private ModelMapper mapper;
	
	public EntregaDTO toDto(Entrega entrega) {
		return mapper.map(entrega, EntregaDTO.class);
	}
	
	public List<EntregaDTO> toListDto(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}
	
}
