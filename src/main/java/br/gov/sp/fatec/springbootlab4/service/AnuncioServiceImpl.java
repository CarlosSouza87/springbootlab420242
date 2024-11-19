package br.gov.sp.fatec.springbootlab4.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootlab4.entity.Anuncio;
import br.gov.sp.fatec.springbootlab4.repository.AnuncioRepository;

@Service
public class AnuncioServiceImpl {

    @Autowired
    private AnuncioRepository repo;

    public Anuncio novo(Anuncio anuncio) {
        if(anuncio.getDataHoraCadastro() == null) {
            anuncio.setDataHoraCadastro(LocalDateTime.now());
        }
        return repo.save(anuncio);
    }

    public List<Anuncio> todos() {
        return repo.findAll();
    }

    public List<Anuncio> buscaPorPrecoECadastro(Float preco, LocalDateTime dataHoraCadastro) {
        return repo.findByPrecoLessThanAndDataHoraCadastroGreaterThan(preco, dataHoraCadastro);
    }
    
    public List<Anuncio> buscaPorCadastroEDescricao(LocalDateTime dataHoraCadastro, String descricao) {
        return repo.findByDataHoraCadastroGreaterThanOrDescricaoContains(dataHoraCadastro, descricao);
    }
    
}

