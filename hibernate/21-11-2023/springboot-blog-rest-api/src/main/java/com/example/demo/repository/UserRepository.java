package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//it indicates that it will handle database operrations for the user entity
	// with a primary key long
	//optional---> a way to express that a value may or may not be present 
	//if present shows result if not shows null value
	
	 Optional<User> findByEmail(String email);
	    Optional<User> findByUsernameOrEmail(String username, String email);
	    Optional<User> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);

}
