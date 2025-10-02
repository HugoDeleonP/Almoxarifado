package org.almoxarifadoindustrial.view;

import org.almoxarifadoindustrial.dao.MaterialDao;
import org.almoxarifadoindustrial.model.Material;

import java.sql.SQLException;
import java.util.Scanner;

public class UserException {

    static UserInterface ui;
    static MaterialDao materialData;
    public UserException(){
        ui = new UserInterface();
        materialData = new MaterialDao();
    }

    public static int verifyInt(Scanner input, String comando){

        boolean valido = false;
        int answer = 0;

        do{
            try{
                String answerString = input.nextLine();
                answer = Integer.parseInt(answerString);
                valido = true;

            }catch (NumberFormatException e){
                System.err.println("Digite um número sem vírgula.");
                System.err.println("Digite o campo novamente: ");
            }

        }while(!valido);

        return answer;
    }

    public static double verifyDouble(Scanner input, String comandoRepeticao){
        boolean valido = false;
        double answer = 0;

        do{
            try{
                String answerString = input.nextLine();
                answer = Double.parseDouble(answerString);
                valido = true;

            }catch (NumberFormatException e){
                System.out.println("Digite um número com vírgula.");
                System.out.println("Digite o campo novamente: ");
            }

        }while(!valido);

        return answer;
    }

    public static String verifyNull(Scanner input){
        String answer = "";

        do{
            try{
                answer = input.nextLine();
            }catch (Exception e){
                System.err.println("Campo obrigatório!");
                System.err.println("Digite o campo novamente: ");
            }

        }while(answer.trim().isEmpty());

        return answer;
    }

    public static boolean verifyPositive(double valor){
        return valor > 0;
    }

    public static Boolean validateMaterial(Material material){

        Boolean permissao = false;

        double estoque = material.getEstoque();

        boolean verifyEstoque = verifyPositive(estoque);

        if(!verifyEstoque){
            ui.erroQuantidadeNegativo();
            return permissao;
        }

        boolean duplicado = false;

        try{
            duplicado = materialData.quantidadeNome(material);
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(duplicado){
            ui.erroDuplicado("O nome");
            return permissao;
        }

        return true;
    }

}
