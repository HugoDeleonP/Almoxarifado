package org.almoxarifadoindustrial.view;

import java.util.Scanner;

public class UserException {

    static UserInterface ui;

    public UserException(){
        ui = new UserInterface();
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
                input.nextLine();
                valido = true;

            }catch (NumberFormatException e){
                System.err.println("Digite um número com vírgula.");
                System.err.println("Digite o campo novamente: ");
            }

        }while(!valido);

        return answer;
    }

    public static String verifyNull(Scanner input, String atributoObrigatorio){
        String answer = "";

        do{
            try{
                answer = input.nextLine();
            }catch (NullPointerException e){
                System.err.println("Campo obrigatório!");
                System.err.println("Digite o campo novamente: ");
            }

        }while(answer.trim().isEmpty());

        return answer;
    }


}
