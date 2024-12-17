package com.romel.sistema.sistemaED.service.Impl;

import com.romel.sistema.sistemaED.entity.Evento;
import com.romel.sistema.sistemaED.repository.EventoRepository;
import com.romel.sistema.sistemaED.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> findAll(Pageable pageable) {
        return eventoRepository.findAll(pageable).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Evento findById(int id) {
        return eventoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Evento no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public Evento create(Evento evento) {
        return eventoRepository.save(evento);
        Evento managedEvento = entityManager.find(Evento.class, evento.getId());
        entityManager.refresh(managedEvento); // Reload from database
        return eventoRepository.save(managedEvento);
    }

    @Override
    @Transactional
    public Evento update(int id, Evento evento) {
        Evento existingEvento = findById(id);
        existingEvento.setNombre(evento.getNombre());
        existingEvento.setDescripcion(evento.getDescripcion());
        existingEvento.setFechaInicio(evento.getFechaInicio());
        existingEvento.setFechaFin(evento.getFechaFin());
        existingEvento.setCosto(evento.getCosto());
        return eventoRepository.save(existingEvento);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Evento evento = findById(id);
        eventoRepository.delete(evento);
        return true;
    }
}
