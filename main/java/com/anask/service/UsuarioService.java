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

    public Usuario getUser(int id) throws Exception {
        Optional<Usuario> optUser = usuarioRepository.findById(id);
        if (optUser.isPresent()) {
            return optUser.get();
        } else {
            throw new Exception("Usuario não encontrado");
        }
    }

    public void newUser(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
