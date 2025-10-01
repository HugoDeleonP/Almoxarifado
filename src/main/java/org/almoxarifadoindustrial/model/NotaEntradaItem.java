package org.almoxarifadoindustrial.model;

public class NotaEntradaItem {

    private NotaEntrada notaEntrada;
    private Material material;
    private double quantidade;

    public NotaEntradaItem(NotaEntrada notaEntrada, Material material, double quantidade) {
        this.notaEntrada = notaEntrada;
        this.material = material;
        this.quantidade = quantidade;
    }

    public NotaEntrada getNotaEntrada() {
        return notaEntrada;
    }

    public void setNotaEntrada(NotaEntrada notaEntrada) {
        this.notaEntrada = notaEntrada;
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
}
