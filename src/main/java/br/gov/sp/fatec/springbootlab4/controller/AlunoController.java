package br.gov.sp.fatec.springbootlab4.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootlab4.entity.Aluno;
import br.gov.sp.fatec.springbootlab4.service.AlunoServiceImpl;

@RestController
@RequestMapping(value = "/aluno")
@CrossOrigin
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> todos() {
        return service.todos();
    }

    @PostMapping
    public Aluno novo(@RequestBody Aluno aluno) {
        return service.novo(aluno);
    }

    @GetMapping(value = "/buscaRa/{data}/{ra}")
    public List<Aluno> buscaPorRaOuMatricula(@PathVariable("data") LocalDate data, @PathVariable("ra") Long ra) {
        return service.buscaPorRaOuMatricula(ra, data);
    }

    @GetMapping(value = "/buscaNome/{data}/{nome}")
    public List<Aluno> buscaPorNomeETermino(@PathVariable("data") LocalDate data, @PathVariable("nome") String nome) {
        return service.buscaPorNomeETermino(nome, data);
    }

}

