package org.almoxarifadoindustrial.dao;

import org.almoxarifadoindustrial.model.Fornecedor;
import org.almoxarifadoindustrial.util.Connect;

import java.sql.*;
import java.time.LocalDate;

public class NotaEntradaDao {
    public int insert(Fornecedor fornecedor) throws SQLException {
        String sql = """
                INSERT INTO NotaEntrada (idFornecedor, dataEntrada)
                VALUES (?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            stmt.setInt(1, fornecedor.getId());
            stmt.setObject(2, LocalDate.now());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                int idGerado = rs.getInt(1);
                System.out.println("Nota de Entrada registrada com Sucesso! ID: " + idGerado);
                return idGerado;
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }


    }
}
