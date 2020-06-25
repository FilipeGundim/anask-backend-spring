package com.anask.controller;

import com.anask.model.Projeto;
import com.anask.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping(value = "/get-projetos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Projeto>> getProjetos(){
        return ResponseEntity.ok().body(projetoService.getProject());
    }

}
