package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
