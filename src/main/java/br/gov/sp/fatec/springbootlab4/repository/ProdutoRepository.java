package br.gov.sp.fatec.springbootlab4.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootlab4.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    public List<Produto> findByLoteOrDataCadastroGreaterThan(Long lote, LocalDate dataCadastro);

    public List<Produto> findByDataHoraUltimaCompraLessThanAndNomeContains(LocalDateTime dataHoraUltimaCompra, String nome);
    
}