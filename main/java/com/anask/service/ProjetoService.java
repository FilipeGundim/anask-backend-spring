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

    public List<Projeto> getProject(String filter) {
        return projetoRepository.getAllByFilter(filter);
    }

    public void newProjeto(Projeto projeto) {
        projetoRepository.save(projeto);
    }

    public void joinProject(int user, int project) {
        projetoRepository.ingressarProjeto(user, project);
    }

    public List<Projeto> getByUserId(int user) {
        return projetoRepository.getAllByUserId(user);
    }

}
