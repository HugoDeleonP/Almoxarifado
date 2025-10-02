package org.almoxarifadoindustrial.dao;

import org.almoxarifadoindustrial.model.Material;
import org.almoxarifadoindustrial.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialDao {
    public void insert(Material material) throws SQLException {
        String sql = """
                INSERT INTO Material (nome, unidade, estoque)
                VALUES (?, ?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, material.getNome());
            stmt.setString(2, material.getUnidade());
            stmt.setDouble(3, material.getEstoque());

            stmt.executeUpdate();
        }
    }

    public boolean quantidadeNome(Material material) throws SQLException{
        String sql = """
                SELECT count(nome) as quantidade from Material
                WHERE nome = "?";
                """;

        int quantidade = -1;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, material.getNome());
            stmt.executeUpdate();

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                quantidade = rs.getInt("quantidade");
            }



            return quantidade > 0;
        }
    }
}
