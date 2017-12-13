package com.ricardococati.service;

import com.ricardococati.dto.GrafoDTO;
import com.ricardococati.model.CustoNodeGrafo;
import com.ricardococati.model.RangeNodeGrafo;
import com.ricardococati.repository.GrafoRepository;
import com.ricardococati.service.algoritmo.AlgoritmoDijkstra;
import com.ricardococati.service.algoritmo.Grafo;
import com.ricardococati.service.algoritmo.LerDoArquivo;
import com.ricardococati.service.algoritmo.Vertice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

	public GrafoDTO retornaMenorCaminhoGrafoDTO(List<String> ids){
		GrafoDTO retorno = new GrafoDTO();
		Grafo grafo = new Grafo();
		List<CustoNodeGrafo> list = this.findAll();
		grafo.setVertices(LerDoArquivo.montaListaVertice(list));
		Vertice verticeOrigem = new Vertice();
		Vertice verticeDestino = new Vertice();

		int primeiraPosicao = 0;
		int ultimoItemDaLista = ids.size() - 1;

		verticeOrigem = grafo.encontrarVertice(ids.get(primeiraPosicao));
		verticeDestino = grafo.encontrarVertice(ids.get(ultimoItemDaLista));

		List<Vertice> resultado = new ArrayList<>();
		AlgoritmoDijkstra algoritmo = new AlgoritmoDijkstra();
		resultado = algoritmo.encontrarMenorCaminhoDijkstra(grafo, verticeOrigem, verticeDestino);
		StringBuilder strBuilder = new StringBuilder();
		for (int indice = 0; indice < resultado.size(); indice++) {
			retorno.setCustoDaRota(resultado.get(indice).getDistancia() + indice);
			strBuilder.append("-" + resultado.get(indice).getDescricao()+"-");
		}
		retorno.setDescricao(strBuilder.toString());
		return retorno;
	}

	@Transactional
	public void save(final CustoNodeGrafo custoNodeGrafo) {
		this.grafoRepository.save(custoNodeGrafo);
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
