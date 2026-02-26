package com.polprojects.eventos.service;

import com.polprojects.eventos.entity.Evento;
import com.polprojects.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> buscarPorId(Long id) {
        return eventoRepository.findById(id);
    }

    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}