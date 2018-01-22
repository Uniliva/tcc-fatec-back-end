package br.com.fatecosasco.tcc.umonitor.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.fatecosasco.tcc.umonitor.model.Sensor;
import br.com.fatecosasco.tcc.umonitor.repository.SensorRepository;

//informa ao spring que essa classe esta passivel de receber requisiçoes rest
@RestController
@RequestMapping("/rest")
@CrossOrigin(allowedHeaders = "*")
public class sensorController {
	@Autowired
	private SensorRepository dao;

	@GetMapping("/sensores")
	public List<Sensor> listar() {
		return dao.findAll();
	}

	@PostMapping("/sensores")
	public Sensor salvar(@RequestBody Sensor sensor) {
		return dao.save(sensor);

	}


}
