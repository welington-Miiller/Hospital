package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.entities.Paciente;
import com.example.demo.services.PacienteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping (value = "/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Operation(
			summary="Listar Pacientes",
			description="Retorna a lista de todos os pacientes")
	
	@GetMapping
	public ResponseEntity<List<Paciente>> procuraTodos() {
    	List<Paciente> listaDePacientes = pacienteService.procuraTodos();
    	return ResponseEntity.status(HttpStatus.OK).body(listaDePacientes);
	}
	
	@Operation(
			summary="Procurar Paciente",
			description="Retorna os detalhes de um paciente específico pelo ID")
	@GetMapping (value = "/{id}")
	public ResponseEntity<Paciente> procuraPorId (@PathVariable Integer id) {
		Paciente response = pacienteService.procuraPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Operation(
			summary="Adicionar Paciente",
			description="Adiciona um novo paciente na lista")
	@PostMapping
	public ResponseEntity<String> adicionarPaciente (@RequestBody Paciente paciente) {
		String response = pacienteService.adicionarPaciente(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Operation(
			summary="Editar Paciente",
			description="Atualiza os detalhes de um paciente existente pelo ID")
	@PutMapping (value = "/{id}")
	public ResponseEntity <String> editarPaciente (@PathVariable Integer id, @RequestBody Paciente paciente) {
		String response = pacienteService.editarPaciente(id, paciente);
		return ResponseEntity.status(200).body(response);
	}
	
	@Operation(
			summary="Deletar Paciente",
			description="Deleta um paciente pelo ID")
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> excluirPaciente (@PathVariable Integer id) {
		pacienteService.excluirPaciente(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}