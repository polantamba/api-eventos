package com.polprojects.eventos.controller;

import com.polprojects.eventos.entity.Usuario;
import com.polprojects.eventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.mostrarUsuarios();
    }

    @PostMapping("/registrar")
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }
}