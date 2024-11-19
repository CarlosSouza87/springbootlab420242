package br.gov.sp.fatec.springbootlab4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootlab4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByNome(String nomeUsuario);

    public Optional<Usuario> findByNomeAndSenha(String nome, String senha);

    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Optional<Usuario> buscaPorNomeESenha(String nome, String senha);

    @Query("select u from Usuario u join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscarPeloNomeDaAutorizacao(String nome);

    public List<Usuario> findByAutorizacoesNome(String nome);
    
}
