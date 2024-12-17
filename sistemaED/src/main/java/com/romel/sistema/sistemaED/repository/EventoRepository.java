package com.romel.sistema.sistemaED.repository;

import com.romel.sistema.sistemaED.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
}