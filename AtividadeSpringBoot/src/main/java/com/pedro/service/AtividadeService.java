package com.pedro.service;

import com.pedro.entity.Atividade;
import com.pedro.repository.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    private final AtividadeRepository repository;

    public AtividadeService(AtividadeRepository repository) {
        this.repository = repository;
    }

    public List<Atividade> listar() {
        return repository.findAll();
    }

    public Atividade salvar(Atividade atividade) {
        return repository.save(atividade);
    }
}
