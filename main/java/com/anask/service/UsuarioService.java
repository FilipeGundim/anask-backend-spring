package com.anask.service;

import com.anask.model.Usuario;
import com.anask.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUser(String email, String senha) throws Exception {
        return usuarioRepository.getUser(email, senha);
    }

    public void newUser(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
