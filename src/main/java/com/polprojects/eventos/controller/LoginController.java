package com.polprojects.eventos.controller;

import com.polprojects.eventos.entity.Usuario;
import com.polprojects.eventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario loginReq) {
        Usuario usuario = usuarioRepository.findByEmail(loginReq.getEmail()).orElse(null);
        if (usuario != null && passwordEncoder.matches(loginReq.getPassword(), usuario.getPassword())) {
            return usuario;
        }
        return null;
    }
}