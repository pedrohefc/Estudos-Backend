package com.pedro.controller;

import com.pedro.entity.Atividade;
import com.pedro.service.AtividadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private final AtividadeService service;

    public AtividadeController(AtividadeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Atividade> listar() {
        return service.listar();
    }

    @PostMapping
    public Atividade criar(@RequestBody Atividade atividade) {
        return service.salvar(atividade);
    }
}
