package org.almoxarifadoindustrial.dao;

import org.almoxarifadoindustrial.model.Material;
import org.almoxarifadoindustrial.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                SELECT count(*) as quantidade from Material
                WHERE nome = ?;
                """;



        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, material.getNome());

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return rs.getInt("quantidade") > 0;
            }

        }

        return false;
    }

    public List<Material> select() throws SQLException{
        String sql = """
                SELECT id, nome, unidade, estoque
                FROM Material;
                """;
        List<Material> materiais = new ArrayList<>();

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String unidade = rs.getString("unidade");
                double estoque = rs.getDouble("estoque");

                var material = new Material(id, nome, unidade, estoque);
                materiais.add(material);
            }
        }

        return materiais;
    }

    public void updateQuantidade(double estoqueTotal, int id) throws SQLException{
        String sql = """
                UPDATE Material SET estoque = ?
                WHERE id = ?;
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1, estoqueTotal);
            stmt.setInt(2, id);

            stmt.executeUpdate();
        }
    }
}
