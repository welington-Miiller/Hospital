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

import com.example.demo.entities.Medico;
import com.example.demo.services.MedicoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping ("/medicos")
  public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Operation(
			summary="Listar Médicos",
			description="Retorna os detalhes de um médico específico pelo ID")
    @GetMapping
    public ResponseEntity<List<Medico>> procuraTodos() {
    	List<Medico> listaDeMedicos = medicoService.procuraTodos();
    	return ResponseEntity.status(HttpStatus.OK).body(listaDeMedicos);
    }
    
    @Operation(
			summary="Procurar Médico",
			description="Retorna os detalhes de um médico específico pelo ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Medico> procuraPorId(@PathVariable Integer id) {
    	Medico response = medicoService.procuraPorId(id);
      return ResponseEntity.status(HttpStatus.OK).body(response);
      
    }
    
    @Operation(
			summary="Adicionar Médico",
			description="Adiciona um novo médico na lista")
	@PostMapping
	public ResponseEntity<String> adicionarMedico (@RequestBody Medico medico) {
    	String response = medicoService.adicionarMedico(medico);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

    @Operation(
			summary="Editar Médico",
			description="Atualiza os detalhes de um médico existente pelo ID")
    @PutMapping (value = "/{id}")
    public ResponseEntity<String> editarMedico(@PathVariable int id, @RequestBody Medico medico) {
      String response = medicoService.editarMedico(id, medico);
      return ResponseEntity.status(200).body(response);
    }

    @Operation(
			summary="Deletar Médico",
			description="Deleta um médico pelo ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable int id){
      medicoService.excluirMedico(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}