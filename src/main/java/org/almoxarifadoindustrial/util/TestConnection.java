package org.almoxarifadoindustrial.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        try(Connection conn = Connect.connect()){
            if(conn != null){
                System.out.println("Conectado com sucesso!");
            }
            else{
                System.out.println("Não houve sucesso na conectividade.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
