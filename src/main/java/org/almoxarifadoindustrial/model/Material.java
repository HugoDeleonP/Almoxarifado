package org.almoxarifadoindustrial.model;

public class Material {
    private Integer id;
    private String nome;
    private String unidade;
    private double estoque;

    public Material(Integer id, String nome, String unidade, double estoque) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.estoque = estoque;
    }

    public Material(String nome, String unidade, double estoque) {
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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", unidade='" + unidade + '\'' +
                ", estoque=" + estoque +
                '}';
    }
}
