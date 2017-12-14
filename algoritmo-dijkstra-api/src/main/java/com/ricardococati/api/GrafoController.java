package com.ricardococati.api;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.ricardococati.model.RangeDeNosDoGrafo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ricardococati.dto.GrafoDTO;
import com.ricardococati.service.GrafoService;

import io.swagger.annotations.ApiOperation;

@RestController
public class GrafoController {

	private GrafoService grafoService;

	private static final String MENSAGEM = "Lista de Nós do Grafo armazenados no arquivo e seus respectivos custos: ";

	private static final String OPCOES = "\n AD4, DE1, EC8, CB2, BA6, AC9, DF7, FC5, FE9, BD3, FA3";
	
	private static final String NOTAS = MENSAGEM + OPCOES;

	@Autowired
	public GrafoController(GrafoService grafoService) {
		this.grafoService = grafoService;
	}

	@ApiOperation(value = "grafo", notes = NOTAS)
	@RequestMapping(path="/grafo" , method = RequestMethod.GET)
	public ResponseEntity<GrafoDTO>  listaCustoDaRota(RangeDeNosDoGrafo rangeDeNosDoGrafo) {
		GrafoDTO grafoDTO = null;
		try {
			grafoDTO = this.grafoService.retornaMenorCaminhoGrafoDTO(rangeDeNosDoGrafo);
			if (Objects.isNull(grafoDTO)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>(grafoDTO, HttpStatus.OK);
	}

}
