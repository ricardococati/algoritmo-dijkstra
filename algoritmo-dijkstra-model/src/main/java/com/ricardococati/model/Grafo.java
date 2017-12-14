package com.ricardococati.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private List<Vertice> grafo = new ArrayList<>();

	public void setVertices(List<Vertice> vertices) {
		this.grafo.addAll(vertices);
	}

	public void addVertice(Vertice novoVertice) {
		this.grafo.add(novoVertice);
	}

	public List<Vertice> getVertices() {
		return this.grafo;
	}

	// Método que retorna o vértice cuja descrição é igual à procurada.
	public Vertice encontrarVertice(String nome) {
		for (Vertice vertice: this.getVertices()) {
			if (nome.equalsIgnoreCase(vertice.getDescricao())) {
				return vertice;
			}
		}
		return null;
	}

}