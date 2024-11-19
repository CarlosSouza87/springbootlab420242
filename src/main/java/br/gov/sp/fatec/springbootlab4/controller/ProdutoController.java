package br.gov.sp.fatec.springbootlab4.controller;

import java.time.LocalDate;
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

import br.gov.sp.fatec.springbootlab4.entity.Produto;
import br.gov.sp.fatec.springbootlab4.service.ProdutoServiceImpl;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl service;

    @GetMapping
    public List<Produto> todos() {
        return service.todos();
    }

    @PostMapping
    public Produto novo(@RequestBody Produto produto) {
        return service.novo(produto);
    }

    @GetMapping(value = "/buscaLote/{data}/{lote}")
    public List<Produto> buscaPorLoteOuCadastro(@PathVariable("data") LocalDate data, @PathVariable("lote") Long preco) {
        return service.buscaPorLoteOuCadastro(preco, data);
    }

    @GetMapping(value = "/buscaNome/{dataHora}/{nome}")
    public List<Produto> buscaPorUltimaCompraENome(@PathVariable("dataHora") LocalDateTime dataHora, @PathVariable("nome") String nome) {
        return service.buscaPorUltimaCompraENome(nome, dataHora);
    }

}

