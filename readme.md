[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/DaO0-MBc)

# Aluno: Tiago Cargnin Morandi
# Programação Orientada a Objetos

# Lista 3: Diagramas de classe

# Sistema de Login

Este projeto simula um sistema de login simples utilizando Java. A aplicação permite o cadastro, remoção, listagem e autenticação de usuários, com base em login e senha. O login é tratado de forma insensível a maiúsculas/minúsculas.

## Estrutura de Arquivos

- **App.java**  
  Classe principal responsável pela execução do programa e testes das funcionalidades.

- **Usuario.java**  
  Classe que representa um usuário. Armazena login e senha. O login é sempre armazenado em letras minúsculas para garantir unicidade independente da entrada do usuário.

- **Gerenciador.java**  
  Classe utilitária (com métodos static) que gerencia os usuários cadastrados. Permite adicionar, remover, autenticar e listar usuários.

## Funcionalidades

- **Cadastro de Usuário**  
  - É necessário informar um login e uma senha.  
  - O login é convertido automaticamente para letras minúsculas.  
  - Não é permitido cadastrar dois usuários com o mesmo login (insensível a maiúsculas).

-  **Remoção de Usuário**  
  - É possível remover um usuário existente a partir do login.

-  **Listagem de Usuários**  
  - A listagem mostra todos os logins cadastrados, na ordem em que foram adicionados.

-  **Autenticação de Usuário**  
  - Verifica se o login e senha informados correspondem a um usuário existente.

---