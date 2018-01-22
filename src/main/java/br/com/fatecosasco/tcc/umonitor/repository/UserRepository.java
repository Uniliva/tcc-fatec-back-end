package br.com.fatecosasco.tcc.umonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecosasco.tcc.umonitor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
