# Supermercado Azulão

Trabalho valendo a primeira nota de PDS, consiste na implementação de um sistema completo de supermercado, necessitando criação de produtos, atualização, listagem e remoção para o Administrador e permitindo que os usuários possam adicionar itens ao carrinho de compras e finalizar a compra gerando uma NF.

## Deploy:

Para rodar o código:
  1) Clone o repositório;
  2) Execute o SQL "create database supermercado";
  3) Coloque o Banco de Dados (com.arthur_pereira.supermercado.service.BancoDeDados.java) em modo "recreate" através da String DBMODE, além de alterar a senha (PASSWORD) para a senha do banco do usuário.
  4) Execute o código e de preferência logo em seguida altere o DBMODE para "keep", para manter o Banco de Dados íntegro através dos usos.
