package org.almoxarifadoindustrial.service;

import org.almoxarifadoindustrial.view.UserInterface;

public class Eventos {

    UserInterface ui;

    public Eventos(){
        ui = new UserInterface();
    }

    public void atendeRequisicao(){
        /*
        Menu exibe a opção Atender Requisição.

        Solicitar ao usuário:
          ● Selecionar a requisição a ser atendida (somente as de status PENDENTE)
          ● Confirmar a quantidade de materiais a ser retirada do estoque
          ● Subtrair os valores do estoque dos materiais.

        Validações:
          ● Verificar se o estoque é suficiente para atender a requisição (se não for, exibir erro e não
          permitir a execução)
          ● Alterar o status da requisição para ATENDIDA
          ● Atualizar o estoque de materiais (subtrair a quantidade atendida)

        Inserção:
          ● Atualizar status da requisição para ATENDIDA

          ● Atualizar estoque dos materiais, reduzindo conforme a quantidade solicitada

        Confirmação:
          ● Exibir mensagem de sucesso ou erro (ex: “Requisição atendida com sucesso!” ou
          “Estoque insuficiente para atender a requisição!”)
          */
    }

    public void cancelaRequisicao(){

    }
}
