package br.com.fatecosasco.tcc.umonitor.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecosasco.tcc.umonitor.model.Dados;
import br.com.fatecosasco.tcc.umonitor.model.Sensor;
import br.com.fatecosasco.tcc.umonitor.repository.DadosRepository;
import br.com.fatecosasco.tcc.umonitor.repository.SensorRepository;

@RestController
@RequestMapping("/rest")
@CrossOrigin(allowedHeaders = "*")
public class DadosController {
	
	@Autowired
	private DadosRepository dadosDao;
	@Autowired
	private SensorRepository sensorDao;

	
	@GetMapping("/dados/{idsensor}")
	public List<Dados> retornaDados(@PathVariable long idsensor) {
		Sensor sensor = sensorDao.findById(idsensor);
		return  dadosDao.findBySensor(sensor);	
	}
	
	

	@PostMapping("/dados/{idsensor}")
	public Dados salvar(@PathVariable long idsensor,@RequestBody Dados dados) {
		dados.setDataAtual(new Date());
		System.out.println(idsensor);
		Sensor sensor = sensorDao.findById(idsensor);
		dados.setSensor(sensor);
		
		dadosDao.save(dados);
		return dados;
		
	}
	


}
