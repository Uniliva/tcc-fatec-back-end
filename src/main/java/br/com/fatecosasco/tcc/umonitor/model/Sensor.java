package br.com.fatecosasco.tcc.umonitor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_sensor")
public class Sensor {
	@Id
	@Column(name = "id_sensor")
	private Long id;

	@Column(name = "descricao_sensor")
	private String descricaoSensor;

	@Column(name = "temperatura_min")
	private double temperaturaMin;

	@Column(name = "temperatura_max")
	private double temperaturaMax;

	@Column(name = "Tipo_item_monitorado")
	private String TipoItemMonitorado;
	
	
	@OneToMany(mappedBy="sensor", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Dados> dados = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoSensor() {
		return descricaoSensor;
	}

	public void setDescricaoSensor(String descricaoSensor) {
		this.descricaoSensor = descricaoSensor;
	}

	public double getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public double getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public String getTipoItemMonitorado() {
		return TipoItemMonitorado;
	}

	public void setTipoItemMonitorado(String tipoItemMonitorado) {
		TipoItemMonitorado = tipoItemMonitorado;
	}

	public List<Dados> getDados() {
		List<Dados> nova = new ArrayList<>();
		int t = dados.size();
		if (t > 1) {
			nova.add(dados.get(t - 1));
			return nova;
		}
		return dados;
	}

	public void setDados(List<Dados> dados) {
		this.dados = dados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
