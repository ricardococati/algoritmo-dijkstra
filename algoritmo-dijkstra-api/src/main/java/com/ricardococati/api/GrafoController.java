package com.ricardococati.api;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<GrafoDTO>  listaCustoDaRota(@RequestParam(name = "ids", required = false) List<String> ids) {
		GrafoDTO grafoDTO = null;
		try {
			grafoDTO = this.grafoService.retornaMenorCaminhoGrafoDTO(ids);
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
