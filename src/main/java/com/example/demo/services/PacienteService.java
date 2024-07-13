package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Paciente;
import com.example.demo.repositories.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public List <Paciente> procuraTodos () {
		return pacienteRepository.findAll();
	}
	
	public Paciente procuraPorId (Integer id) {
		return pacienteRepository.findById(id).get();
	}
	
	public String adicionarPaciente (Paciente paciente) {
		pacienteRepository.save(paciente);
		return ("Paciente adicionado com sucesso");
	}
	
	public String editarPaciente (Integer id, Paciente paciente) {
		Paciente response = pacienteRepository.findById(id).get();
		response.setId(paciente.getId());
		response.setCpf(paciente.getCpf());
		response.setNome(paciente.getNome());
		response.setDataNascimento(paciente.getDataNascimento());
		response.setTelefone(paciente.getTelefone());
		
		pacienteRepository.save(paciente);
		return ("Paciente editado com sucesso");
	}
	
	public void excluirPaciente (Integer id) {
		Paciente response = pacienteRepository.findById(id).get();
		pacienteRepository.delete(response);
	}
	
}