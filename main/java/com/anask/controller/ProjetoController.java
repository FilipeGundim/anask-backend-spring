package com.anask.controller;

import com.anask.model.Projeto;
import com.anask.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping(value = "/get-projetos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProjetos() {
        try {
            return ResponseEntity.ok().body(projetoService.getProject());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/new-projeto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newProjeto(@RequestBody Projeto projeto) {

        try {
            projetoService.newProjeto(projeto);
            return ResponseEntity.ok().body("Inserido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(":(");
        }
    }
}
