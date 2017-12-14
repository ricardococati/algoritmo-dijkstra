package com.ricardococati.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ricardococati.model.RangeDeNosDoGrafo;
import org.springframework.stereotype.Service;

import com.ricardococati.dto.GrafoDTO;
import com.ricardococati.model.Grafo;
import com.ricardococati.model.Vertice;
import com.ricardococati.service.algoritmo.AlgoritmoDijkstra;
import com.ricardococati.service.algoritmo.CarregaDadosArquivo;

@Service
public class GrafoService implements Serializable {

	private static final long serialVersionUID = 25671121174988145L;

	public GrafoDTO retornaMenorCaminhoGrafoDTO(RangeDeNosDoGrafo rangeDeNosDoGrafo) throws IOException {
		GrafoDTO retorno = new GrafoDTO();
		Grafo grafo = new Grafo();

		int custo = 0;

		grafo.setVertices(CarregaDadosArquivo.montaListaVertice("teste.txt"));
		
		Vertice verticeOrigem = new Vertice();
		Vertice verticeDestino = new Vertice();

		String rangePrimeiroNoh = rangeDeNosDoGrafo.getRangePrimeiroNoh();
		String rangeSegundoNoh = rangeDeNosDoGrafo.getRangeSegundoNoh();

		verticeOrigem = grafo.encontrarVertice(rangePrimeiroNoh);
		verticeDestino = grafo.encontrarVertice(rangeSegundoNoh);

		List<Vertice> resultado = new ArrayList<>();
		AlgoritmoDijkstra algoritmo = new AlgoritmoDijkstra();
		resultado = algoritmo.algoritmoDijkstraParaEncontrarMenorCaminho(grafo, verticeOrigem, verticeDestino);
		StringBuilder strBuilder = new StringBuilder();
		
		for (int indice = 0; indice < resultado.size(); indice++) {
			custo = resultado.get(indice).getDistancia();
			strBuilder.append("-" + resultado.get(indice).getDescricao()+"-");
		}

		retorno.setCustoDaRota(custo);
		retorno.setDescricao(strBuilder.toString());
		
		return retorno;
	}

	private int obterCustoDaDistancia(List<Vertice> resultado){
		int custo = 0;
		for (int indice = 0; indice < resultado.size(); indice++) {
			custo = resultado.get(indice).getDistancia();
		}
		return custo;
	}
}
