package com.anask.controller;

import com.anask.model.Usuario;
import com.anask.service.UsuarioService;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/get-user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok().body(usuarioService.getUser(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/new-user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newUser(@RequestBody Usuario usuario) {
        try {
            usuarioService.newUser(usuario);
            return ResponseEntity.ok().body("Inserido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(":( " + e.getMessage());
        }
    }
}
