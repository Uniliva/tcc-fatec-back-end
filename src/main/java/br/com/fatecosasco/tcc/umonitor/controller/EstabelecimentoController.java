package br.com.fatecosasco.tcc.umonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecosasco.tcc.umonitor.model.Estabelecimento;
import br.com.fatecosasco.tcc.umonitor.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("/rest")
@CrossOrigin(allowedHeaders = "*")
public class EstabelecimentoController {
	@Autowired
	private EstabelecimentoRepository dao;
	
	@GetMapping("/loja")
	public List<Estabelecimento> listar() {
		return dao.findAll();
	}
	
	@PostMapping("/loja")
	public Estabelecimento salvar(@RequestBody Estabelecimento loja) {
		return dao.save(loja);
		
	}
}
