package com.ricardococati.service;

import com.ricardococati.dto.GrafoDTO;
import com.ricardococati.model.CustoNodeGrafo;
import com.ricardococati.model.RangeNodeGrafo;
import com.ricardococati.repository.GrafoRepository;
import com.ricardococati.service.algoritmo.AlgoritmoDijkstra;
import com.ricardococati.service.algoritmo.Grafo;
import com.ricardococati.service.algoritmo.Vertice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class GrafoService implements Serializable {

	private static final long serialVersionUID = 25671121174988145L;

	private GrafoRepository grafoRepository;

	@Autowired
	public GrafoService(GrafoRepository grafoRepository) {
		this.grafoRepository = grafoRepository;
	}

	public GrafoDTO retornaMenorCaminhoGrafoDTO(RangeNodeGrafo rangeDeNosDoGrafo){
		GrafoDTO retorno = new GrafoDTO();
		Grafo teste = new Grafo();
		//teste.setVertices(LerDoArquivo.lerGrafo(a0));
		Vertice verticeOrigem = new Vertice();
		Vertice verticeDestino = new Vertice();

		int primeiraPosicao = 0;
		int ultimoItemDaLista = rangeDeNosDoGrafo.getNosDoGrafo().size() - 1;

		verticeOrigem = teste.encontrarVertice(rangeDeNosDoGrafo.getNosDoGrafo().get(primeiraPosicao));
		verticeDestino = teste.encontrarVertice(rangeDeNosDoGrafo.getNosDoGrafo().get(ultimoItemDaLista));

		List<Vertice> resultado = new ArrayList<>();
		AlgoritmoDijkstra algoritmo = new AlgoritmoDijkstra();
		resultado = algoritmo.encontrarMenorCaminhoDijkstra(teste, verticeOrigem, verticeDestino);
		return retorno;
	}

	public List<CustoNodeGrafo> findAll() {
		return this.grafoRepository.findAll();
	}

	public CustoNodeGrafo findById(Integer id) {
		return this.grafoRepository.findById(id);
	}

	public List<CustoNodeGrafo> findGrafosByIds(List<Integer> ids) {
		return this.grafoRepository.findByIdIn(ids);
	}
}
