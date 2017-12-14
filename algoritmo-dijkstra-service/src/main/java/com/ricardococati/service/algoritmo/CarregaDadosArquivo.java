package com.ricardococati.service.algoritmo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ricardococati.model.Aresta;
import com.ricardococati.model.Grafo;
import com.ricardococati.model.Vertice;

public class CarregaDadosArquivo {

	public static List<Vertice> montaListaVertice(String nomeArquivo) throws IOException {
		Grafo grafo = new Grafo();
		Vertice vertice;
		File arquivo = new File(nomeArquivo);
		String vertices[];
		String linha;
		ArrayList<String[]> listCustos = new ArrayList<String[]>();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(arquivo));
			Map<String, Vertice> mapa = new HashMap<String, Vertice>();
			while ((linha = bufferReader.readLine()) != null) {
				if (linha.contains(",")) {
					listCustos.add(linha.split("/"));
					vertices = listCustos.get(0)[0].split(",");
					vertice = (Vertice) mapa.get(vertices[0]);
					if (vertice == null) {
						vertice = new Vertice();
					}
					List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
					List<Aresta> arestasAtual = new ArrayList<Aresta>();
					vertice.setDescricao(vertices[0]);
					mapa.put(vertices[0], vertice);
					if (linha.contains("/")) {
						String pesoArestas[] = listCustos.get(0)[1].split(",");
						for (int i = 1; i < vertices.length; i++) {
							Vertice vit;
							vit = mapa.get(vertices[i]);
							if (vit == null) {
								vit = new Vertice();
							}
							vit.setDescricao(vertices[i]);
							vizinhosAtual.add(vit);
							mapa.put(vertices[i], vit);
							Aresta ait = new Aresta(vertice, vit);
							ait.setPeso(Integer.parseInt(pesoArestas[i - 1]));
							arestasAtual.add(ait);
						}
						vertice.setVizinhos(vizinhosAtual);
						vertice.setArestas(arestasAtual);
					}
				} else {
					vertice = (Vertice) mapa.get(linha);
					if (vertice == null) {
						vertice = new Vertice();
					}
					vertice.setDescricao(linha);
					mapa.put(linha, vertice);
				}
				grafo.addVertice(vertice);
				listCustos.clear();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nao encontrou o arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bufferReader != null) {
				bufferReader.close();
			}
		}
		return grafo.getVertices();
	}

}