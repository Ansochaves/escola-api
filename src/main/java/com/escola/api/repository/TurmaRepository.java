package com.escola.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

	List<Turma> findAllByNome(String nome);
	
	Optional<List<Turma>> findByNomeLike(String nome);
}
