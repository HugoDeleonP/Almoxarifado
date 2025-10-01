package org.almoxarifadoindustrial.dao;

import org.almoxarifadoindustrial.model.Fornecedor;
import org.almoxarifadoindustrial.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDao {

    public void insert(Fornecedor fornecedor){
        String sql = """
                INSERT INTO Fornecedor (nome, cnpj)
                VALUES (?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
