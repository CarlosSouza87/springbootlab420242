package br.gov.sp.fatec.springbootlab4.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootlab4.entity.Chamado;
import br.gov.sp.fatec.springbootlab4.repository.ChamadoRepository;

@Service
public class ChamadoServiceImpl {
    
    @Autowired
    private ChamadoRepository repo;

    public Chamado novo(Chamado chamado) {
        if(chamado.getDataHoraCadastro() == null) {
            chamado.setDataHoraCadastro(LocalDateTime.now());
        }
        return repo.save(chamado);
    }

    public List<Chamado> todos() {
        return repo.findAll();
    }

    public List<Chamado> buscaPorDataHoraCadastroETitulo(LocalDateTime cadastro, String titulo) {
        return repo.findByTituloContainsAndDataHoraCadastroGreaterThanAndDataHoraFinalizacaoIsNull(titulo, cadastro);
    }
    
    public List<Chamado> buscaPorEstimativaEDataHoraCadastro(Float estimativa, LocalDateTime cadastro) {
        return repo.findByDataHoraCadastroGreaterThanAndEstimativaGreaterThanAndDataHoraFinalizacaoIsNull(cadastro, estimativa);
    }

}