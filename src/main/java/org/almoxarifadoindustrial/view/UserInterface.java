package org.almoxarifadoindustrial.view;

import java.util.Scanner;

public class UserInterface {

    Scanner input;

    public UserInterface(){
        input = new Scanner(System.in);
    }

    public int mainMenu(){
        System.out.println("=========================| Almoxarifado Industrial |=========================");
        System.out.println(" 1 - Cadastrar Fornecedor");
        System.out.println(" 2 - Cadastrar Material");
        System.out.println(" 3 - Registrar Nota de Entrada");
        System.out.println(" 4 - Criar Requisição de Material");
        System.out.println(" 5 - Atender Requisição");
        System.out.println(" 6 - Cancelar Requisição");
        System.out.println(" \n0 - Sair");
        System.out.println("===========================================================================");

        System.out.println("\n Digite o que deseja fazer, conforme a legenda acima:");
        return UserException.verifyInt(input,"\nDigite o que deseja fazer, conforme a legenda acima:" );
    }

    public int repeticao(String operacao){
        System.out.printf("=========================| %s |=========================\n\n", operacao);
        System.out.println(" 1 - Sim");
        System.out.println(" 2 - Não");

        System.out.println("Gostaria de adicionar mais um material à nota?");

        return UserException.verifyInt(input, "\nDigite o que deseja fazer, conforme a legenda acima:");
    }

    public int inputInt(String operacao, String atributo, String entidade){
        System.out.printf("=========================| %s |=========================\n\n", operacao);
        System.out.printf("\n Digite %s d%s:\n", atributo, entidade);

        return UserException.verifyInt(input, "Digite novamente: ");
    }

    public double inputDouble(String operacao, String atributo, String entidade){
        System.out.printf("=========================| %s |=========================\n\n", operacao);
        System.out.printf("\n Digite %s d%s:\n", atributo, entidade);
        return UserException.verifyDouble(input, "Digite novamente: ");
    }

    public void atributoObrigatorio(String atributo){
        System.err.printf("O %s é obrigatório!", atributo);
    }

    public String inputString(String operacao, String atributo, String entidade){
        System.out.printf("=========================| %s |=========================\n\n", operacao);
        System.out.printf("\n Digite %s d%s:\n", atributo, entidade);

        return UserException.verifyNull(input);
    }

    public void sucessoInsert(){
        System.out.println("Dados enviados com sucesso!");
    }

    public void sucessoUpdate(){
        System.out.println("Dados atualizados com sucesso!");
    }

    public static void erroQuantidadeNegativo(){
        System.err.println("A quantidade digitada está abaixo de zero.");
        System.err.println("Digite uma quantidade acima de zero\n");
    }

    public static void erroDuplicado(String atributo){
        System.out.printf("%s digitado já existe no sistema!", atributo);
    }

}
