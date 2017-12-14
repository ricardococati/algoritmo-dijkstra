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
		Vertice vert;
		File file = new File(nomeArquivo);
		String vertices[];
		String linha;
		ArrayList<String[]> custos = new ArrayList<String[]>();
		BufferedReader bufferRead = null;
		try {
			bufferRead = new BufferedReader(new FileReader(file));
			Map<String, Vertice> mapa = new HashMap<String, Vertice>();
			while ((linha = bufferRead.readLine()) != null) {
				if (linha.contains(",")) {
					custos.add(linha.split("/"));
					vertices = custos.get(0)[0].split(",");
					vert = (Vertice) mapa.get(vertices[0]);
					if (vert == null) {
						vert = new Vertice();
					}
					List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
					List<Aresta> arestasAtual = new ArrayList<Aresta>();
					vert.setDescricao(vertices[0]);
					mapa.put(vertices[0], vert);

					if (linha.contains("/")) {
						String pesoArestas[] = custos.get(0)[1].split(",");
						for (int i = 1; i < vertices.length; i++) {
							Vertice vit;
							// vit = g.encontrarVertice(vertices[i]);
							vit = mapa.get(vertices[i]);
							if (vit == null) {
								vit = new Vertice();
							}
							vit.setDescricao(vertices[i]);
							vizinhosAtual.add(vit);
							mapa.put(vertices[i], vit);

							Aresta ait = new Aresta(vert, vit);
							ait.setPeso(Integer.parseInt(pesoArestas[i - 1]));
							arestasAtual.add(ait);

						}
						vert.setVizinhos(vizinhosAtual);
						vert.setArestas(arestasAtual);
					}
				} else {
					vert = (Vertice) mapa.get(linha);
					if (vert == null) {
						vert = new Vertice();
					}
					vert.setDescricao(linha);
					mapa.put(linha, vert);
				}
				grafo.addVertice(vert);
				custos.clear();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nao encontrou o arquivo");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bufferRead != null) {
				bufferRead.close();
			}
		}
		return grafo.getVertices();
	}

}