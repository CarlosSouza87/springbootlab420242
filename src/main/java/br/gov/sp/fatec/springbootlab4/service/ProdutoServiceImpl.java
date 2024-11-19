package br.gov.sp.fatec.springbootlab4.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootlab4.entity.Produto;
import br.gov.sp.fatec.springbootlab4.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl {
    
    @Autowired
    private ProdutoRepository repo;

    public Produto novo(Produto produto) {
        if(produto.getDataCadastro() == null) {
            produto.setDataCadastro(LocalDate.now());
        }
        return repo.save(produto);
    }

    public List<Produto> todos() {
        return repo.findAll();
    }

    public List<Produto> buscaPorLoteOuCadastro(Long lote, LocalDate cadastro) {
        return repo.findByLoteOrDataCadastroGreaterThan(lote, cadastro);
    }
    
    public List<Produto> buscaPorUltimaCompraENome(String nome, LocalDateTime alteracao) {
        return repo.findByDataHoraUltimaCompraLessThanAndNomeContains(alteracao, nome);
    }

}

