package br.gov.sp.fatec.springbootlab4.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootlab4.entity.Chamado;
import br.gov.sp.fatec.springbootlab4.service.ChamadoServiceImpl;

@RestController
@RequestMapping(value = "/chamado")
@CrossOrigin
public class ChamadoController {

    @Autowired
    private ChamadoServiceImpl service;

    @GetMapping
    public List<Chamado> todos() {
        return service.todos();
    }

    @PostMapping
    public Chamado novo(@RequestBody Chamado chamado) {
        return service.novo(chamado);
    }

    @GetMapping(value = "/buscaTitulo/{dataHora}/{titulo}")
    public List<Chamado> buscaPorDataHoraCadastroETitulo(@PathVariable("dataHora") LocalDateTime dataHora, @PathVariable("titulo") String titulo) {
        return service.buscaPorDataHoraCadastroETitulo(dataHora, titulo);
    }

    @GetMapping(value = "/buscaEstimativa/{estimativa}/{dataHora}")
    public List<Chamado> buscaPorEstimativaEDataHoraCadastro(@PathVariable("estimativa") Float estimativa, @PathVariable("dataHora") LocalDateTime dataHora) {
        return service.buscaPorEstimativaEDataHoraCadastro(estimativa, dataHora);
    }   
}