package com.polprojects.eventos.service;

import com.polprojects.eventos.entity.Evento;
import com.polprojects.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> mostrarEventos() {
        return eventoRepository.findAll();
    }

    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento actualizarEvento(Long id, Evento evento) {
        Evento existente = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        existente.setNombre(evento.getNombre());
        existente.setDescripcion(evento.getDescripcion());
        existente.setImageUrl(evento.getImageUrl());
        existente.setFecha(evento.getFecha());
        existente.setPrecio(evento.getPrecio());

        return eventoRepository.save(existente);
    }

    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}