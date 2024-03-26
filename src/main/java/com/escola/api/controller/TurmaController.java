package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Turma;
import com.escola.api.repository.TurmaRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/turmas")
	public ResponseEntity<List<Turma>> getAllTurmas(){
		return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.findAll());
	}
	
	@GetMapping("/turmas/{id}")
	public ResponseEntity<Optional<Turma>> getTurmaById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.findById(id));
	}
	
	@GetMapping("/turmas/nome/{nome}")
	public ResponseEntity<Optional<List<Turma>>> getAllTurmaByNome(@PathVariable String nome){
		return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.findByNomeLike(nome));
	}
	
	@PostMapping("/turmas")
	public ResponseEntity<Turma> cadastrarTurmas(@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
		
	}
	
	@PutMapping("/turmas/{id}")
	public ResponseEntity<Turma> atualizaTurmaById(@PathVariable Long id, @RequestBody Turma turma){
		Optional<Turma> turmaExistente = turmaRepository.findById(id);
		
		if(turmaExistente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		Turma turmaObj = turmaExistente.get();
		
		turmaObj.setNome(turma.getNome());
		turmaObj.setCargaHoraria(turma.getCargaHoraria());
		turmaObj.setDataInicio(turma.getDataInicio());
		turmaObj.setDataTermino(turma.getDataInicio());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.save(turmaObj));
	}
	
	@DeleteMapping("/turmas/{id}")
	public ResponseEntity<Turma> deletarTurma(@PathVariable Long id){
		Optional<Turma> optionalTurma = turmaRepository.findById(id);
		
		if(optionalTurma.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		turmaRepository.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	
}
