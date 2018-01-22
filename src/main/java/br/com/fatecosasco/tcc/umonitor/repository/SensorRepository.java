package br.com.fatecosasco.tcc.umonitor.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecosasco.tcc.umonitor.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

	Sensor findById(long idSensor);
	

}
