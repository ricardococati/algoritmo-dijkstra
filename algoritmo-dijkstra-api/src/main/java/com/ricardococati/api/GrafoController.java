package com.ricardococati.api;

import com.ricardococati.model.Campanha;
import com.ricardococati.model.RangeDeNosDoGrafo;
import com.ricardococati.service.CampanhaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrafoController {

	private CampanhaService campanhaService;

	private static final String MENSAGEM = "Lista de Nós do Grafo e seus respectivos custos: </br>";

	private static final String OPCOES = "\n AD4, DE1, EC8, CB2, BA6, AC9, DF7, FC5, FE9, BD3, FA3";

	private static final String EXEMPLO = "\n  {\n" +
			"  \"nosDoGrafo\": [\n" +
			"    \"A, D, E\"\n" +
			"  ]\n" +
			"}";
	
	private static final String NOTAS = MENSAGEM + OPCOES + EXEMPLO;

	@Autowired
	public GrafoController(CampanhaService campanhaService) {
		this.campanhaService = campanhaService;
	}

	@ApiOperation(value = "campanhas", notes = NOTAS, response = List.class)
	@RequestMapping(value="/campanhas" , method=RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Campanha>> listaCustoDaRota(@RequestBody RangeDeNosDoGrafo rangeDeNosDoGrafo) {

		return null;
	}


}
