package com.ricardococati.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ricardococati.dto.GrafoDTO;
import com.ricardococati.service.algoritmo.AlgoritmoDijkstra;
import com.ricardococati.service.algoritmo.Grafo;
import com.ricardococati.service.algoritmo.LerDoArquivo;
import com.ricardococati.service.algoritmo.Vertice;

@Service
public class GrafoService implements Serializable {

	private static final long serialVersionUID = 25671121174988145L;

	public GrafoDTO retornaMenorCaminhoGrafoDTO(List<String> ids) throws IOException{
		GrafoDTO retorno = new GrafoDTO();
		Grafo grafo = new Grafo();
		grafo.setVertices(LerDoArquivo.montaListaVertice("teste.txt"));
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
			retorno.setCustoDaRota(resultado.get(indice).getDistancia());
			strBuilder.append("-" + resultado.get(indice).getDescricao()+"-");
		}
		retorno.setDescricao(strBuilder.toString());
		return retorno;
	}
}
