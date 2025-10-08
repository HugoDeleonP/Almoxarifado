package org.almoxarifadoindustrial.model;

import java.time.LocalDate;

public class NotaEntrada {

    private Integer id;
    private Fornecedor fornecedor;
    private LocalDate dataEntrada;

    public NotaEntrada(Integer id, Fornecedor fornecedor, LocalDate dataEntrada) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.dataEntrada = dataEntrada;
    }

    public NotaEntrada(Fornecedor fornecedor, LocalDate dataEntrada) {
        this.fornecedor = fornecedor;
        this.dataEntrada = dataEntrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public String toString() {
        return "NotaEntrada{" +
                "id=" + id +
                ", fornecedor=" + fornecedor +
                ", dataEntrada=" + dataEntrada +
                '}';
    }
}
