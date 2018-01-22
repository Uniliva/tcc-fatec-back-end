package br.com.fatecosasco.tcc.umonitor.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_dados_sensores")
public class Dados {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dados_sensores")
	private long idDadosSensores;
	
	@Column(name="temperatura_atual")
	private double temperaturaAtual;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_atual")
	private Date dataAtual;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Sensor sensor;

	public long getIdDadosSensores() {
		return idDadosSensores;
	}

	public void setIdDadosSensores(long idDadosSensores) {
		this.idDadosSensores = idDadosSensores;
	}

	public double getTemperaturaAtual() {
		return temperaturaAtual;
	}

	public void setTemperaturaAtual(double temperaturaAtual) {
		this.temperaturaAtual = temperaturaAtual;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	
	

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	
	
	
	

}
