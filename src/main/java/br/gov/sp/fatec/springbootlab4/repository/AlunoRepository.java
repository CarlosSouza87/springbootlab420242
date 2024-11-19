package br.gov.sp.fatec.springbootlab4.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootlab4.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    public List<Aluno> findByRaOrDataMatriculaLessThan(Long ra, LocalDate dataMatricula);

    public List<Aluno> findByNomeCompletoContainsAndDataTerminoGreaterThan(String nomeCompleto, LocalDate dataMatricula);
    
}
