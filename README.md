# Sistema de CRUD de Produtos

## Descrição

Este é um projeto desenvolvido como parte da Avaliação 3 da disciplina de Java Database Connectivity (JDBC). O sistema realiza operações CRUD (Create, Read, Update e Delete) para gerenciar produtos em um banco de dados.

## Integrantes da Equipe

- José Heitor Dias Tavares
- Gustavo Henrique Araújo Barbosa
- João Victor Antunes de Oliveira

## Requisitos

### Atributos do Produto

- Id (incrementado automaticamente)
- Nome
- Preço
- Categoria (laticínios, hortifrúti, cereais, bebidas, etc...)
- Data de Vencimento (utilizando LocalDate)

### Funcionalidades

1. Cadastrar no mínimo 5 produtos (mínimo 2 pertencentes à mesma categoria)
2. Buscar todos os produtos cadastrados na base de dados
3. Buscar todos os produtos cadastrados de uma categoria
4. Buscar o produto com o maior preço
5. Buscar o produto com a data de vencimento mais próxima da data atual
6. Atualizar o preço de um produto
7. Remover um produto da base de dados pelo nome
