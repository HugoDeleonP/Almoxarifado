package org.almoxarifadoindustrial.view;

import org.almoxarifadoindustrial.dao.FornecedorDao;
import org.almoxarifadoindustrial.dao.MaterialDao;
import org.almoxarifadoindustrial.dao.NotaEntradaItemDao;
import org.almoxarifadoindustrial.model.Fornecedor;
import org.almoxarifadoindustrial.model.Material;
import org.almoxarifadoindustrial.model.NotaEntrada;
import org.almoxarifadoindustrial.model.NotaEntradaItem;

import java.sql.SQLException;
import java.util.Scanner;

public class UserException {

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

    public static Boolean validateFornecedor(Fornecedor fornecedor){
        boolean duplicado = false;

        FornecedorDao fornecedorData = new FornecedorDao();
        try{
            duplicado = fornecedorData.quantidadeCnpj(fornecedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(duplicado){
            UserInterface.erroDuplicado("O CNPJ");
            return false;
        }

        return true;
    }

    public static Boolean validateMaterial(Material material){

        Boolean permissao = false;

        double estoque = material.getEstoque();

        boolean verifyEstoque = verifyPositive(estoque);

        if(!verifyEstoque){
            UserInterface.erroQuantidadeNegativo();
            return permissao;
        }

        boolean duplicado = false;

        try{
            MaterialDao materialData = new MaterialDao();
            duplicado = materialData.quantidadeNome(material);
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(duplicado){
            UserInterface.erroDuplicado("O nome");
            return permissao;
        }

        return true;
    }

    public static <T> Boolean objectNull(T objeto){
        return objeto != null;
    }

    public static boolean validateNotaEntradaItem(NotaEntradaItem notaEntradaItem){

        NotaEntradaItemDao notaEntradaItemData = new NotaEntradaItemDao();
        boolean permissao = false;
        int idMaterial = notaEntradaItem.getMaterial().getId();

        double quantidade = notaEntradaItem.getQuantidade();

        if(quantidade < 0){
            return false;
        }

        try{
            boolean itemNotaEntradaDuplicado = notaEntradaItemData.quantidadeMaterial(idMaterial);

            if(itemNotaEntradaDuplicado){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

}
