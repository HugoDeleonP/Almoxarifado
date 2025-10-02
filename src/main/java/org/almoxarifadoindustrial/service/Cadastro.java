package org.almoxarifadoindustrial.service;

import org.almoxarifadoindustrial.dao.FornecedorDao;
import org.almoxarifadoindustrial.model.Fornecedor;
import org.almoxarifadoindustrial.view.UserInterface;

public class Cadastro {

    UserInterface ui;

    public Cadastro(){
        ui = new UserInterface();
    }

    public void createFornecedor(){

        String operacao = "Cadastrar Fornecedor";
        String entidade = "o fornecedor";

        /*
        Fluxo de execução:

        ● Menu exibe a opção Cadastrar Fornecedor.

        Solicitar ao usuário:
        ● Nome do fornecedor
        ● CNPJ do fornecedor

        Validações:
        ● Nome e CNPJ obrigatórios
        ● CNPJ único (não permitir cadastro de fornecedor com CNPJ duplicado)

        Inserção:
        ● Inserir fornecedor no banco de dados

        Confirmação:
        ● Exibir mensagem de sucesso ou erro (ex: “Fornecedor cadastrado com
        sucesso!” ou “CNPJ já cadastrado!”)
        */

        String nome = ui.inputString(operacao, "o nome", entidade);
        String cnpj = ui.inputString(operacao, "o CNPJ", entidade);

        Fornecedor fornecedor = new Fornecedor(nome, cnpj);

        FornecedorDao fornecedorData = new FornecedorDao();
        fornecedorData.insert(fornecedor);
        ui.sucessoInsert();

    }

    public void createMaterial(){
        /*
        Fluxo de execução:
        ● Menu exibe a opção Cadastrar Material.

        Solicitar ao usuário:
        ● Nome do material
        ● Unidade de medida (kg, m, peça, etc.)
        ● Quantidade inicial em estoque

        Validações:
        ● Nome do material obrigatório
        ● Validar se material já existe (nome duplicado).
        ● Quantidade em estoque ≥ 0

        Inserção:
        ● Inserir material no banco de dados

        Confirmação:
        ● Exibir mensagem de sucesso ou erro (ex: “Material cadastrado com
        sucesso!” ou “Valor de estoque inválido!”)
        */



    }

    public void createNotaEntrada(){
        /*

        Fluxo de execução:
        ● Menu exibe a opção Registrar Nota de Entrada.

        Solicitar ao usuário:
        ● Selecionar fornecedor.
        ● Data de entrada (data atual).
        ● Listar materiais para que o usuário possa associar a essa nota.
        ● verificar se o material já foi adicionado, caso sim não deve listar
        novamente para fazer associação.
        ● Deve permitir que o usuário adicione mais de um material a nota.

        Validações:

        ● Verificar se a quantidade de cada material é válida (estoque ≥ 0)
        ● Validar a existência do fornecedor no banco de dados

        Inserção:
        ● Registrar a nota de entrada no banco de dados, as informações gerais da
        nota na tabela “NotaEntrada”.
        ● Para associar materiais e quantidades a nota salvar na tabela
        NotaEntradaItem item por item.
        ● Atualizar o estoque dos materiais cadastrados (aumentar a quantidade
        conforme a nota recebida)

        Confirmação:
        ● Exibir mensagem de sucesso ou erro (ex: “Nota de entrada registrada com
        sucesso!” ou “Erro ao registrar nota de entrada!”)

        */
    }

    public void createRequisicaoMaterial(){
        /*
        Fluxo de execução:
        ● Menu exibe a opção Criar Requisição de Material.

        Solicitar ao usuário:
        ● Setor requisitante
        ● Lista de materiais a serem requisitados com suas quantidades

        Validações:
        ● Verificar se a quantidade solicitada não ultrapassa o estoque disponível
        ● Setor e materiais obrigatórios

        Inserção:
        ● Inserir requisição no banco de dados na tabela “Requisicao” com status
        PENDENTE
        ● Associar os materiais e quantidades solicitadas à requisição salvando na
        tabela “RequisicaoItem” um por um, conforme informado pelo cliente.
        ● Após associado uma vez ele não deve aparecer para associar

        Confirmação:
        ● Exibir mensagem de sucesso ou erro (ex: “Requisição de material criado
        com sucesso!” ou “Erro ao criar requisição!”)
        */
    }
}
