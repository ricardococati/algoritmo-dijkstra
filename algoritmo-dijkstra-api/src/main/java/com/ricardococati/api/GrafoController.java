package com.ricardococati.api;

import com.ricardococati.dto.GrafoDTO;
import com.ricardococati.model.RangeNodeGrafo;
import com.ricardococati.service.GrafoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GrafoController {

	private GrafoService grafoService;

	private static final String MENSAGEM = "Lista de Nós do Grafo armazenados na base e seus respectivos custos: ";

	private static final String OPCOES = "\n AD4, DE1, EC8, CB2, BA6, AC9, DF7, FC5, FE9, BD3, FA3";
	
	private static final String NOTAS = MENSAGEM + OPCOES;

	@Autowired
	public GrafoController(GrafoService grafoService) {
		this.grafoService = grafoService;
	}

	@ApiOperation(value = "grafo", notes = NOTAS, response = GrafoDTO.class)
	@RequestMapping(value="/grafo" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GrafoDTO>  listaCustoDaRota(@RequestBody RangeNodeGrafo rangeDeNosDoGrafo) {
		GrafoDTO grafoDTO = this.grafoService.retornaMenorCaminhoGrafoDTO(rangeDeNosDoGrafo);
		if (Objects.isNull(grafoDTO)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(grafoDTO, HttpStatus.OK);
	}

}
