package org.almoxarifadoindustrial.model;

import java.time.LocalDate;
import java.util.Date;

public class Requisicao {

    Integer id;
    String setor;
    LocalDate dataSolicitacao;

    public Requisicao(Integer id, String setor, LocalDate dataSolicitacao) {
        this.id = id;
        this.setor = setor;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Requisicao(String setor, LocalDate dataSolicitacao) {
        this.setor = setor;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
