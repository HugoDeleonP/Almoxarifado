package org.almoxarifadoindustrial.service;

import org.almoxarifadoindustrial.dao.FornecedorDao;
import org.almoxarifadoindustrial.dao.MaterialDao;
import org.almoxarifadoindustrial.model.Fornecedor;
import org.almoxarifadoindustrial.model.Material;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Busca {

    List<Fornecedor> fornecedores = new ArrayList<>();
    List<Material> materiais = new ArrayList<>();

    public List<Fornecedor> listaFornecedor(){
        FornecedorDao fornecedorData = new FornecedorDao();

        try{
            fornecedores = fornecedorData.select();
        }catch (SQLException e){
            e.printStackTrace();
        }

        for(Fornecedor fornecedor: fornecedores){
            System.out.println(fornecedor);
        }

        return fornecedores;
    }

    public Fornecedor buscaFornecedor(Integer id){
        FornecedorDao fornecedorData = new FornecedorDao();

        try{
            fornecedores = fornecedorData.select();
        }catch (SQLException e){
            e.printStackTrace();
        }

        for(Fornecedor fornecedor: fornecedores){
            if(Objects.equals(fornecedor.getId(), id)){
                return fornecedor;
            }
        }

        return null;
    }

    public List<Material> listaMaterial(){
        MaterialDao materialData = new MaterialDao();

        try{
            materiais = materialData.select();
        }catch (SQLException e){
            e.printStackTrace();
        }

        for(Material material: materiais){
            System.out.println(material);
        }

        return materiais;
    }

    public Material buscaMaterial(Integer id){
        MaterialDao materialData = new MaterialDao();

        try{
            materiais = materialData.select();
        }catch (SQLException e){
            e.printStackTrace();
        }

        for(Material material: materiais){
            if(Objects.equals(material.getId(), id)){
                return material;
            }
        }

        return null;
    }

}