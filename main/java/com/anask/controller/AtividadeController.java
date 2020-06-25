package com.anask.controller;

import com.anask.model.Atividade;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtividadeController {

    @GetMapping(value = "/get-atividades", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Atividade>> getAtividades() {
        return ResponseEntity.ok().body();
    }
}

