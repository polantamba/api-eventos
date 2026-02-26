package com.polprojects.eventos.controller;

import com.polprojects.eventos.entity.Evento;
import com.polprojects.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAll() {
        return eventoService.listarEventos();
    }

    @PostMapping
    public Evento create(@RequestBody Evento evento) {
        return eventoService.guardarEvento(evento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
    }
}