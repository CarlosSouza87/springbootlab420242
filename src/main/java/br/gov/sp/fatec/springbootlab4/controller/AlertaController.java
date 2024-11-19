package br.gov.sp.fatec.springbootlab4.controller;

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

import br.gov.sp.fatec.springbootlab4.entity.Alerta;
import br.gov.sp.fatec.springbootlab4.service.AlertaServiceImpl;

@RestController
@RequestMapping(value = "/alerta")
@CrossOrigin
public class AlertaController {

    @Autowired
    private AlertaServiceImpl service;

    @GetMapping
    public List<Alerta> todosAlertas() {
        return service.todosAlertas();
    }

    @PostMapping
    public Alerta cadastrarAlerta(@RequestBody Alerta alerta) {
        return service.cadastrarAlerta(alerta);
    }

    @GetMapping(value = "/buscaNivel/{dataHora}/{nivel}")
    public List<Alerta> buscarPorDataHoraGeracaoENivel(@PathVariable("dataHora") LocalDateTime dataHoraGeracao, @PathVariable("nivel") Integer nivel) {
        return service.buscarPorDataHoraGeracaoENivel(dataHoraGeracao, nivel);
    }

    @GetMapping(value = "/buscaMensagem/{dataHora}/{mensagem}")
    public List<Alerta> buscarMensagemEDataHoraVerificacao(@PathVariable("dataHora") LocalDateTime dataHoraVerificacao, @PathVariable("mensagem") String mensagem) {
        return service.buscarMensagemEDataHoraVerificacao(mensagem, dataHoraVerificacao);
    }
    
}

