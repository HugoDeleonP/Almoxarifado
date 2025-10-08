package org.almoxarifadoindustrial.dao;

import org.almoxarifadoindustrial.model.Fornecedor;
import org.almoxarifadoindustrial.model.Material;
import org.almoxarifadoindustrial.util.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao {

    public void insert(Fornecedor fornecedor) throws SQLException {
        String sql = """
                INSERT INTO Fornecedor (nome, cnpj)
                VALUES (?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.executeUpdate();

        }

    }

    public boolean quantidadeCnpj(Fornecedor fornecedor) throws SQLException{
        String sql = """
                SELECT count(*) as quantidade from Fornecedor
                WHERE cnpj = ?;
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, fornecedor.getNome());

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return rs.getInt("quantidade") > 0;
            }

        }

        return false;
    }

    public List<Fornecedor> select() throws SQLException{
        String sql = """
                SELECT id, nome, cnpj
                FROM Fornecedor;
                """;
        List<Fornecedor> fornecedores = new ArrayList<>();

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");

                Fornecedor fornecedor = new Fornecedor(id, nome, cnpj);
                fornecedores.add(fornecedor);
            }
        }

        return fornecedores;
    }
}
