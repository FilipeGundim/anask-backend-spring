package com.anask.service;

import com.anask.model.Atividade;
import com.anask.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> getAtividades(int id) {
        return atividadeRepository.getByUserId(id);
    }

    public List<Atividade> getHistorico(int id) {
        return atividadeRepository.getHistorico(id);
    }

    public void deleteAtividade(int id) {
        atividadeRepository.deleteAtividade(id);
    }

    public void newAtividade(Atividade atividade) {
        atividadeRepository.save(atividade);
    }
}
