package org.almoxarifadoindustrial.service;

import org.almoxarifadoindustrial.view.UserInterface;

import javax.swing.text.View;
import java.util.Scanner;

public class Industria {
    //cadastro fornecedor
    //cadastro material
    //cadastro nota entrada
    //cadastro requisicao de material
    //atender requisicao

    //validacao

    Cadastro cadastro;
    UserInterface ui;

    public Industria(){
        cadastro = new Cadastro();
        ui = new UserInterface();
    }

    public void routerMain(int option){
        switch (option){
            case 1 ->{
                cadastro.createFornecedor();
            }

            case 2 ->{
                cadastro.createMaterial();
            }

            case 3 ->{
                cadastro.createNotaEntrada();
            }

            case 4 ->{

            }

            case 5 ->{

            }
        }
    }
}
