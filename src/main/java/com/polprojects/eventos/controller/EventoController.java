package com.polprojects.eventos.controller;

import com.polprojects.eventos.entity.Evento;
import com.polprojects.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listar() { return eventoService.mostrarEventos(); }

    @PostMapping
    public Evento crear(@RequestBody Evento evento) { return eventoService.guardarEvento(evento); }

    @PutMapping("/{id}")
    public Evento actualizar(@PathVariable Long id, @RequestBody Evento evento) {
        return eventoService.actualizarEvento(id, evento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { eventoService.eliminarEvento(id); }
}