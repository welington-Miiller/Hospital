package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Medico;
import com.example.demo.repositories.MedicoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	public List<Medico> procuraTodos() {
		return medicoRepository.findAll();
	}
	
	public Medico procuraPorId(Integer id) {
		return medicoRepository.findById(id).get();
	}
	
	public String adicionarMedico(Medico medico) {
		medicoRepository.save(medico);
		return("Medico adicionado com sucesso");
	}
	
	public String editarMedico(Integer id, Medico medico) {
		Medico response = medicoRepository.findById(id).get();
		response.setId(medico.getId());
		response.setNome(medico.getNome());
		response.setEspecialidade(medico.getEspecialidade());
		
		medicoRepository.save(medico);
		return("Medico editado com sucesso");
	}
	
	public void excluirMedico(Integer id) {
		Medico response = medicoRepository.findById(id).get();
		medicoRepository.delete(response);
	}
}
