package com.romel.sistema.sistemaED.controller;

import com.romel.sistema.sistemaED.entity.Evento;
import com.romel.sistema.sistemaED.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("s/v1/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Evento> eventos = eventoService.findAll(pageable);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getById(@PathVariable("id") int id) {
        Evento evento = eventoService.findById(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping("/eventos")
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {

        return ResponseEntity.ok(eventoService.create(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable("id") int id, @RequestBody Evento evento) {
        Evento updatedEvento = eventoService.update(id, evento);
        return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
