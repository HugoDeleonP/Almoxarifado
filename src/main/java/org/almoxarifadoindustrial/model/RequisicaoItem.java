package org.almoxarifadoindustrial.model;

public class RequisicaoItem {
    private Requisicao requisicao;
    private Material material;
    private double quantidade;

    public RequisicaoItem(Requisicao requisicao, Material material, double quantidade) {
        this.requisicao = requisicao;
        this.material = material;
        this.quantidade = quantidade;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "RequisicaoItem{" +
                "requisicao=" + requisicao +
                ", material=" + material +
                ", quantidade=" + quantidade +
                '}';
    }
}
