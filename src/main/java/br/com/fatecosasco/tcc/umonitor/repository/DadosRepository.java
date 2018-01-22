package br.com.fatecosasco.tcc.umonitor.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecosasco.tcc.umonitor.model.Dados;
import br.com.fatecosasco.tcc.umonitor.model.Sensor;



public interface DadosRepository extends JpaRepository<Dados, Long> {

	List<Dados> findBySensor(Sensor sensor);

}
