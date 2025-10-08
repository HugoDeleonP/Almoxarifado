package org.almoxarifadoindustrial.dao;

import org.almoxarifadoindustrial.model.NotaEntradaItem;
import org.almoxarifadoindustrial.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotaEntradaItemDao {
    public void insert(NotaEntradaItem notaEntradaItem) throws SQLException {
        String sql = """
                INSERT INTO NotaEntradaItem (idNotaEntrada, idMaterial, quantidade)
                VALUES (?, ?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, notaEntradaItem.getNotaEntrada().getId());
            stmt.setInt(2, notaEntradaItem.getMaterial().getId());
            stmt.setDouble(3, notaEntradaItem.getQuantidade());
        }
    }

    public boolean quantidadeMaterial(Integer idMaterial) throws SQLException{
        String sql = """
                SELECT COUNT(*) as quantidade
                FROM NotaEntradaItem
                WHERE idMaterial = ?;
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, idMaterial);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return rs.getInt("quantidade") > 0;
            }
        }

        return false;
    }
}
