package br.gov.sp.fatec.springbootlab4.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro_produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_nome")
    private String nome;

    @Column(name = "pro_descricao")
    private String descricao;

    @Column(name = "pro_data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "pro_data_hora_ultima_compra")
    private LocalDateTime dataHoraUltimaCompra;

    @Column(name = "pro_lote")
    private Long lote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataHoraUltimaCompra() {
        return dataHoraUltimaCompra;
    }

    public void setDataHoraUltimaCompra(LocalDateTime dataHoraUltimaCompra) {
        this.dataHoraUltimaCompra = dataHoraUltimaCompra;
    }

    public Long getLote() {
        return lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }


}