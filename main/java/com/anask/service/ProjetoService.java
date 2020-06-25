package com.anask.service;

import com.anask.model.Projeto;
import com.anask.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> getProject(){
        return ProjetoRepository;
    }
}
