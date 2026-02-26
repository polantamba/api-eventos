package com.polprojects.eventos.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fecha;
    private String ubicacion;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario organizador;

    public Evento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getDescription() { return descripcion; }
    public void setDescription(String descripcion) { this.descripcion = descripcion; }
    public Usuario getOrganizador() { return organizador; }
    public void setOrganizador(Usuario organizador) { this.organizador = organizador; }
}