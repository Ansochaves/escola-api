package com.escola.api.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
