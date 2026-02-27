package com.polprojects.eventos.controller;

import com.polprojects.eventos.entity.Evento;
import com.polprojects.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired private EventoService service;

    @GetMapping
    public List<Evento> listar() { return service.listarEventos(); }

    @PostMapping
    public Evento crear(@RequestBody Evento evento) { return service.guardarEvento(evento); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminarEvento(id); }
}