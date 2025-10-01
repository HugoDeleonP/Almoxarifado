create database almoxarifadoIndustrial;

use almoxarifadoIndustrial;

-- Fornecedores
CREATE TABLE Fornecedor (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cnpj VARCHAR(14) UNIQUE NOT NULL
);
-- Materiais
CREATE TABLE Material (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
unidade VARCHAR(20) NOT NULL, -- Ex.: kg, m, peça
estoque DOUBLE NOT NULL
);
-- Requisições de Material
CREATE TABLE Requisicao (
id INT PRIMARY KEY AUTO_INCREMENT,
setor VARCHAR(50) NOT NULL,
dataSolicitacao DATE NOT NULL,

status VARCHAR(20) NOT NULL -- PENDENTE / ATENDIDA / CANCELADA
);
-- Itens da Requisição
CREATE TABLE RequisicaoItem (
idRequisicao INT NOT NULL,
idMaterial INT NOT NULL,
quantidade DOUBLE NOT NULL,
PRIMARY KEY (idRequisicao, idMaterial),
FOREIGN KEY (idRequisicao) REFERENCES Requisicao(id),
FOREIGN KEY (idMaterial) REFERENCES Material(id)
);
-- Notas de Entrada (compras recebidas de fornecedores)
CREATE TABLE NotaEntrada (
id INT PRIMARY KEY AUTO_INCREMENT,
idFornecedor INT NOT NULL,
dataEntrada DATE NOT NULL,
FOREIGN KEY (idFornecedor) REFERENCES Fornecedor(id)
);
-- Itens da Nota de Entrada
CREATE TABLE NotaEntradaItem (
idNotaEntrada INT NOT NULL,
idMaterial INT NOT NULL,
quantidade DOUBLE NOT NULL,
PRIMARY KEY (idNotaEntrada, idMaterial),
FOREIGN KEY (idNotaEntrada) REFERENCES NotaEntrada(id),
FOREIGN KEY (idMaterial) REFERENCES Material(id)
);