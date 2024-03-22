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
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/alunos/{id}")
	public ResponseEntity<Optional<Aluno>> getAlunoById(@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findById(id));
	}
	
	@GetMapping("/alunos/email/{email}")
	public ResponseEntity<Optional<Aluno>> getAlunoByEmail(@PathVariable String email){
		
		return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findByEmail(email));
	}
	
	
	@PutMapping("/alunos/{id}")
	public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno){
		Optional<Aluno> optionalAluno = alunoRepository.findById(id);
		
		if (optionalAluno.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		Aluno alunoExistente = optionalAluno.get();
		
		alunoExistente.setNome(aluno.getNome());
		alunoExistente.setSobrenome(aluno.getSobrenome());
		alunoExistente.setEmail(aluno.getEmail());
		alunoExistente.setDataNascimento(aluno.getDataNascimento());
		
		return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoExistente));
	}		
	
	@PostMapping("/alunos")
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno)) ;
	}
	
	
	
	
	

	
	
	
	
}
