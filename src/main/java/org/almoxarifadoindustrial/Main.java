package org.almoxarifadoindustrial;

import org.almoxarifadoindustrial.service.Industria;
import org.almoxarifadoindustrial.view.UserInterface;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Industria industria = new Industria();
        int opcaoUsuario = -1;

        do{
            opcaoUsuario = ui.mainMenu();
            industria.routerMain(opcaoUsuario);
        }while(opcaoUsuario != 0);

    }
}