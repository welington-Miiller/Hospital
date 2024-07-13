package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Consulta;
import com.example.demo.repositories.ConsultaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List <Consulta> procuraTodos () {
		return consultaRepository.findAll();
	}
	
	public Consulta procuraPorId (Integer id) {
		return consultaRepository.findById(id).get();
	}
	
	public String adicionarConsulta (Consulta consulta) {
		consultaRepository.save(consulta);
		return ("Consulta adicionada com sucesso");
	}
	
	public String editarConsulta (Integer id, Consulta consulta) {
		Consulta response = consultaRepository.findById(id).get();
		response.setId(consulta.getId());
		response.setDataHora(consulta.getDataHora());
		response.setMotivo(consulta.getMotivo());
		response.setMedico(consulta.getMedico());
		response.setPaciente(consulta.getPaciente());
		
		consultaRepository.save(consulta);
		return ("Consulta editada com sucesso");
	}
	
	public void excluirConsulta (Integer id) {
		Consulta response = consultaRepository.findById(id).get();
		consultaRepository.delete(response);
	}
	
}

	