package com.anask.controller;

import com.anask.model.Projeto;
import com.anask.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping(value = "/get-projetos/{filter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Projeto>> getProjetos(@PathVariable("filter") String filter) {
        try {
            return ResponseEntity.ok().body(projetoService.getProject(filter + " "));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/user-projetos/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserProjetos(@PathVariable("user") int user) {
        try {
            return ResponseEntity.ok().body(projetoService.getByUserId(user));
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

    @PostMapping(value = "/ingressar-projeto/{user}/{project}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> ingressarProjeto(@PathVariable("user") int user, @PathVariable("project") int project) {

        try {
            projetoService.joinProject(user, project);
            return ResponseEntity.ok().body("Inserido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(":(");
        }
    }
}
