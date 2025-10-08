package org.almoxarifadoindustrial.service;

import org.almoxarifadoindustrial.Main;
import org.almoxarifadoindustrial.dao.FornecedorDao;
import org.almoxarifadoindustrial.dao.MaterialDao;
import org.almoxarifadoindustrial.dao.NotaEntradaDao;
import org.almoxarifadoindustrial.dao.NotaEntradaItemDao;
import org.almoxarifadoindustrial.model.Fornecedor;
import org.almoxarifadoindustrial.model.Material;
import org.almoxarifadoindustrial.model.NotaEntrada;
import org.almoxarifadoindustrial.model.NotaEntradaItem;
import org.almoxarifadoindustrial.view.UserException;
import org.almoxarifadoindustrial.view.UserInterface;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;

public class Cadastro {

    private UserInterface ui;
    private FornecedorDao fornecedorData = new FornecedorDao();
    private MaterialDao materialData = new MaterialDao();
    private NotaEntradaDao notaEntradaData = new NotaEntradaDao();
    private NotaEntradaItemDao notaEntradaItemData = new NotaEntradaItemDao();
    public Busca busca;

    public Cadastro(){
        ui = new UserInterface();
        busca = new Busca();
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

        boolean permissao = UserException.validateFornecedor(fornecedor);

        if(!permissao){
            return;
        }

        try{
            fornecedorData.insert(fornecedor);
            ui.sucessoInsert();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void createMaterial() {
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

        String operacao = "Cadastro material";
        String entidade = "o material";

        String nome = ui.inputString(operacao, "o nome", entidade);
        String unidade = ui.inputString(operacao, "a unidade", entidade);
        double estoque = ui.inputDouble(operacao, "o estoque", entidade);

        Material material = new Material(nome, unidade, estoque);

        boolean permissao = UserException.validateMaterial(material);

        if(!permissao){
            return;
        }

        try{
            materialData.insert(material);
            ui.sucessoInsert();

        }catch (SQLException e){
            e.printStackTrace();
        }

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

        String operacao = "Cadastro Nota Entrada";

        int idCandidata = 0;

        busca.listaFornecedor();
        int idFornecedor = ui.inputInt(operacao, "o ID", "o fornecedor");
        Fornecedor fornecedor = busca.buscaFornecedor(idFornecedor);
        boolean permissao = UserException.objectNull(fornecedor);

        if(!permissao){
            System.out.println("Fornecedor não encontrado!");
            return;
        }

        operacao = "Associar Material a Nota Entrada";

        try{
            idCandidata = notaEntradaData.insert(fornecedor);
        }catch (SQLException e){
            e.printStackTrace();
        }

        NotaEntrada notaEntrada = new NotaEntrada(idCandidata, fornecedor, LocalDate.now());

        boolean repetir;
        do{
            busca.listaMaterial();
            int idMaterial = ui.inputInt(operacao, "o ID", "o material");
            var material = busca.buscaMaterial(idMaterial);

            double quantidade = ui.inputDouble(operacao, "a quantidade", "a nota entrada associado ao item");
            var notaEntradaItem = new NotaEntradaItem(notaEntrada, material, quantidade);

            permissao = UserException.validateNotaEntradaItem(notaEntradaItem);

            if(!permissao){
                System.out.println("Erro na associação do item à nota de entrada");
                return;
            }

            double estoqueTotal = quantidade + material.getEstoque();

            try{

                ui.sucessoInsert();
                notaEntradaItemData.insert(notaEntradaItem);
                ui.sucessoInsert();

                materialData.updateQuantidade(estoqueTotal, idMaterial);
                ui.sucessoUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }

            int opcao = ui.repeticao(operacao);

            repetir = routerRepeticaoNotaEntrada(opcao);
        }while(repetir);

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

    public Boolean routerRepeticaoNotaEntrada(int adicionarMais){
        switch (adicionarMais){
            case 1 ->{
                return true;
            }

            case 2 ->{
                return false;
            }

            default -> {
                return null;
            }
        }
    }
}
