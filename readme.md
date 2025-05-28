[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/DaO0-MBc)

# Aluno: **Tiago Cargnin Morandi**
# Lista 3: Diagramas de classe
## Sistema de Login

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

# Sistema de Fila de Atendimento

Este projeto implementa um sistema de gerenciamento de fila de atendimento em Java, permitindo o registro de clientes, solicitações de atendimento e geração de relatórios.

## Funcionalidades

- **Registro de Clientes e Pedidos**:
  - Cadastro de novos clientes com nome e número de telefone.
  - Adição de pedidos de atendimento com descrição e tipo (Suporte Técnico, Informação, Atendimento Financeiro).

- **Gestão da Fila de Atendimento**:
  - Visualização do próximo cliente na fila.
  - Atendimento de clientes, movendo pedidos da fila para a lista de atendidos.
  - Listagem de pedidos pendentes e atendidos.

- **Relatórios**:
  - Estatísticas sobre o total de solicitações, atendidas e em espera.
  - Percentual de cada tipo de atendimento.

## Estrutura do Projeto

- **`Client.java`**: Representa um cliente, com métodos para formatar nome e número, e gerenciar solicitações.
- **`Request.java`**: Representa uma solicitação de atendimento, com descrição e categoria.
- **`Service.java`**: Gerencia a fila de atendimento, clientes e pedidos, além de fornecer métodos para operações do sistema.
- **`App.java`**: Classe principal para demonstração das funcionalidades.

## Como Executar

1. Certifique-se de ter o Java instalado em sua máquina.
2. Clone o repositório ou copie os arquivos para o seu ambiente de desenvolvimento.
3. Compile e execute a classe `App.java`:
   ```bash
   javac fila_atendimento/*.java
   java fila_atendimento.App