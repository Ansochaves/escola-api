package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	public ResponseEntity<List<Aluno>> getAllAlunos(){
		return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
	}
	
	@PostMapping("/alunos")
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno)) ;
	}
	
	@GetMapping("/alunos/{id}")
	public ResponseEntity<Optional<Aluno>> getAlunoById(@PathVariable Long id){
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return ResponseEntity.ok(aluno);
	}
	
	
	

	
	
	
	
}
