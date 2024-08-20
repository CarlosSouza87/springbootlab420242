package br.gov.sp.fatec.springbootlab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootlab4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
