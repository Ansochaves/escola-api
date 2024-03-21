package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Aluno;
import com.escola.api.repository.AlunoRepository;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class AlunoController {

	private AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	@PostMapping("/alunos")
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	
	public ResponseEntity<Optional<Aluno>> getAlunoById(@PathVariable Long id){
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return ResponseEntity.ok(aluno);
	}
	
	
	
	
}
