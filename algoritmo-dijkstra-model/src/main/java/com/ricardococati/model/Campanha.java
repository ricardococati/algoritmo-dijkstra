package com.ricardococati.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Campanha implements Serializable {
	
	private static final long serialVersionUID = -3739959736137472637L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_campanha")
	private Integer id;

	@Column(name = "time_do_coracao")
	private String timeDoCoracao;

	@Column(name = "nome_campanha")
	private String nomeCampanha;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "data_vigencia_init")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataVigenciaInicio;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "data_vigencia_term")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataVigenciaTermino;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTimeDoCoracao() {
		return timeDoCoracao;
	}

	public void setTimeDoCoracao(String timeDoCoracao) {
		this.timeDoCoracao = timeDoCoracao;
	}

	public String getNomeCampanha() {
		return nomeCampanha;
	}

	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public LocalDate getDataVigenciaInicio() {
		return dataVigenciaInicio;
	}

	public void setDataVigenciaInicio(LocalDate dataVigenciaInicio) {
		this.dataVigenciaInicio = dataVigenciaInicio;
	}

	public LocalDate getDataVigenciaTermino() {
		return dataVigenciaTermino;
	}

	public void setDataVigenciaTermino(LocalDate dataVigenciaTermino) {
		this.dataVigenciaTermino = dataVigenciaTermino;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Campanha campanha = (Campanha) o;

		if (id != null ? !id.equals(campanha.id) : campanha.id != null) return false;
		if (timeDoCoracao != null ? !timeDoCoracao.equals(campanha.timeDoCoracao) : campanha.timeDoCoracao != null)
			return false;
		if (nomeCampanha != null ? !nomeCampanha.equals(campanha.nomeCampanha) : campanha.nomeCampanha != null)
			return false;
		if (dataVigenciaInicio != null ? !dataVigenciaInicio.equals(campanha.dataVigenciaInicio) : campanha.dataVigenciaInicio != null)
			return false;
		return dataVigenciaTermino != null ? dataVigenciaTermino.equals(campanha.dataVigenciaTermino) : campanha.dataVigenciaTermino == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (timeDoCoracao != null ? timeDoCoracao.hashCode() : 0);
		result = 31 * result + (nomeCampanha != null ? nomeCampanha.hashCode() : 0);
		result = 31 * result + (dataVigenciaInicio != null ? dataVigenciaInicio.hashCode() : 0);
		result = 31 * result + (dataVigenciaTermino != null ? dataVigenciaTermino.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Campanha{" +
				"id=" + id +
				", timeDoCoracao='" + timeDoCoracao + '\'' +
				", nomeCampanha='" + nomeCampanha + '\'' +
				", dataVigenciaInicio=" + dataVigenciaInicio +
				", dataVigenciaTermino=" + dataVigenciaTermino +
				'}';
	}
}
