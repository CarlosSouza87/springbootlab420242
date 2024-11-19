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

import br.gov.sp.fatec.springbootlab4.entity.Anuncio;
import br.gov.sp.fatec.springbootlab4.service.AnuncioServiceImpl;

@RestController
@RequestMapping(value = "/anuncio")
@CrossOrigin
public class AnuncioController {

    @Autowired
    private AnuncioServiceImpl service;

    @GetMapping
    public List<Anuncio> todos() {
        return service.todos();
    }

    @PostMapping
    public Anuncio novo(@RequestBody Anuncio anuncio) {
        return service.novo(anuncio);
    }

    @GetMapping(value = "/buscaPreco/{dataHora}/{preco}")
    public List<Anuncio> buscaPorPrecoECadastro(@PathVariable("dataHora") LocalDateTime dataHora, @PathVariable("preco") Float preco) {
        return service.buscaPorPrecoECadastro(preco, dataHora);
    }

    @GetMapping(value = "/buscaDescricao/{dataHora}/{descricao}")
    public List<Anuncio> buscaPorCadastroEDescricao(@PathVariable("dataHora") LocalDateTime dataHora, @PathVariable("descricao") String descricao) {
        return service.buscaPorCadastroEDescricao(dataHora, descricao);
    }

}

