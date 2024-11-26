package br.gov.sp.fatec.springbootlab4.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cha_chamado")
public class Chamado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cha_id")
    private Long id;

    @Column(name = "cha_titulo")
    private String titulo;

    @Column(name = "cha_descricao")
    private String descricao;

    @Column(name = "cha_data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;

    @Column(name = "cha_data_hora_finalizacao")
    private LocalDateTime dataHoraFinalizacao;

    @Column(name = "cha_estimativa")
    private Float estimativa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public LocalDateTime getDataHoraFinalizacao() {
        return dataHoraFinalizacao;
    }

    public void setDataHoraFinalizacao(LocalDateTime dataHoraFinalizacao) {
        this.dataHoraFinalizacao = dataHoraFinalizacao;
    }

    public Float getEstimativa() {
        return estimativa;
    }

    public void setEstimativa(Float estimativa) {
        this.estimativa = estimativa;
    }

}