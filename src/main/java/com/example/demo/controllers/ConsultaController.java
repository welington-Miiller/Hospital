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

import com.example.demo.entities.Consulta;
import com.example.demo.services.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
    @Autowired
    private ConsultaService consultaService;

    @Operation(
			summary="Listar Consultas",
			description="Retorna a lista de todas as consultas")
    @GetMapping
    public ResponseEntity<List<Consulta>> procuraTodos() {
    	List<Consulta> listaDeConsultas = consultaService.procuraTodos();
    	return ResponseEntity.status(HttpStatus.OK).body(listaDeConsultas);
    }

    @Operation(
			summary="Pesquisar Consulta",
			description="Retorna os detalhes de uma consulta específica pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> procuraPorId(@PathVariable Integer id) {
    	Consulta response = consultaService.procuraPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
			summary="Adicionar Consulta",
			description="Adiciona uma nova consulta na lista")
    @PostMapping
    public ResponseEntity<String> adicionarConsulta(@RequestBody Consulta consulta) {
    	String response = consultaService.adicionarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
			summary="Editar Consulta",
			description="Atualiza os detalhes de uma consulta existente pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> editarConsulta(@PathVariable Integer id, @RequestBody Consulta consulta) { 
    	String response = consultaService.editarConsulta(id, consulta);
        return ResponseEntity.status(200).body(response);
    }

    @Operation(
			summary="Deletar Consulta",
			description="Deleta uma consulta pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConsulta(@PathVariable Integer id) {
        consultaService.excluirConsulta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}