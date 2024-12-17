package com.romel.sistema.sistemaED.service;

import com.romel.sistema.sistemaED.entity.Evento;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventoService {
    List<Evento> findAll(Pageable pageable);
    Evento findById(int id);
    Evento create(Evento evento);
    Evento update(int id, Evento evento);
    boolean delete(int id);
}