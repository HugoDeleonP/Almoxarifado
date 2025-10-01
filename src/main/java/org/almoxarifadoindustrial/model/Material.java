package org.almoxarifadoindustrial.model;

public class Material {
    private Integer id;
    private String nome;
    private double unidade;
    private double estoque;

    public Material(Integer id, String nome, double unidade, double estoque) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.estoque = estoque;
    }

    public Material(String nome, double unidade, double estoque) {
        this.nome = nome;
        this.unidade = unidade;
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getUnidade() {
        return unidade;
    }

    public void setUnidade(double unidade) {
        this.unidade = unidade;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
}
