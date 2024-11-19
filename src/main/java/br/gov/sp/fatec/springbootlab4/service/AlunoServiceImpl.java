package br.gov.sp.fatec.springbootlab4.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootlab4.entity.Aluno;
import br.gov.sp.fatec.springbootlab4.repository.AlunoRepository;

@Service
public class AlunoServiceImpl {

    @Autowired
    private AlunoRepository repo;

    public Aluno novo(Aluno aluno) {
        if(aluno.getDataMatricula() == null) {
            aluno.setDataMatricula(LocalDate.now());
        }
        return repo.save(aluno);
    }

    public List<Aluno> todos() {
        return repo.findAll();
    }

    public List<Aluno> buscaPorRaOuMatricula(Long ra, LocalDate dataMatricula) {
        return repo.findByRaOrDataMatriculaLessThan(ra, dataMatricula);
    }
    
    public List<Aluno> buscaPorNomeETermino(String nome, LocalDate termino) {
        return repo.findByNomeCompletoContainsAndDataTerminoGreaterThan(nome, termino);
    }
}
