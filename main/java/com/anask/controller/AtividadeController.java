package com.anask.controller;

import com.anask.model.Atividade;
import com.anask.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping(value = "/get-atividades/{id}")
    public ResponseEntity<List<Atividade>> getAtividades(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(atividadeService.getAtividades(id));
    }

    @PostMapping(value = "/delete-atividade/{id}")
    public ResponseEntity<String> deleteAtividade(@PathVariable("id") int id){
        atividadeService.deleteAtividade(id);
        return  ResponseEntity.ok().body("Deletado com sucesso");
    }

    @PostMapping(value = "/new-atividade", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newAtividade(@RequestBody Atividade atividade){
        atividadeService.newAtividade(atividade);
        return  ResponseEntity.ok().body("Inserido com sucesso");
    }
}

