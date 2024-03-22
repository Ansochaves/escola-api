package com.escola.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Optional<Aluno> findByEmail(String email);
	
	
}
