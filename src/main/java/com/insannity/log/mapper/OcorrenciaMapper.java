package com.insannity.log.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insannity.log.dto.OcorrenciaDTO;
import com.insannity.log.entities.Ocorrencia;

@Component
public class OcorrenciaMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OcorrenciaDTO toDto(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}
	
	public List<OcorrenciaDTO> toListDto (List<Ocorrencia> ocorrencias){
		return ocorrencias.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
