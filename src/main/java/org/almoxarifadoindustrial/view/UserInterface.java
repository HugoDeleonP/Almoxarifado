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

    public int inputInt(String operacao, String atributo, String entidade){
        System.out.printf("=========================| %s |=========================\n\n", operacao);
        System.out.printf("\n Digite %s d%s:", atributo, entidade);

        return UserException.verifyInt(input, "Digite novamente: ");
    }

    public double inputDouble(String operacao, String atributo, String entidade){
        System.out.printf("=========================| %s |=========================\n\n", operacao);
        System.out.printf("\n Digite %s d%s:", atributo, entidade);
        double answer = input.nextDouble();
        input.nextLine();

        return answer;
    }

    public void atributoObrigatorio(String atributo){
        System.out.printf("O %s é obrigatório!", atributo);
    }

    public String inputString(String operacao, String atributo, String entidade){
        System.out.printf("=========================| %s |=========================\n\n", operacao);
        System.out.printf("\n Digite %s d%s:", atributo, entidade);



        return UserException.verifyNull(input, atributo);
    }


}
