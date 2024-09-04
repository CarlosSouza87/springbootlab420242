package br.gov.sp.fatec.springbootlab4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootlab4.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{

    public Optional<Autorizacao> findByNome(String nome);

    @Query("select a from Autorizacao a where a.nome = ?1")
    public Optional<Autorizacao> buscarPeloNome(String nome);
    
}
