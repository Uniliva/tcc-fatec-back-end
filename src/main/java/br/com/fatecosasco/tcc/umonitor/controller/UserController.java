package br.com.fatecosasco.tcc.umonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecosasco.tcc.umonitor.model.User;
import br.com.fatecosasco.tcc.umonitor.repository.UserRepository;

@RestController
@RequestMapping("/rest")
@CrossOrigin(allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserRepository dao;


	@PostMapping("/user")
	public User salvar(@RequestBody User user) {
		return dao.save(user);
	}

	@GetMapping("/user")
	public List<User> listar() {
		return dao.findAll();
	}

	@PostMapping("/valida")
	public ResponseEntity<User> valida(@RequestBody User user) {
		try {
			User userdb = dao.findByEmail(user.getEmail());
				System.out.println(userdb);
			if (userdb == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else if (userdb.igual(user)) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
