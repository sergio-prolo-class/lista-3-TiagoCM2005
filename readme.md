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

# Diagrama de Classes - Sistema de Fila de Atendimento



# Sistema de Biblioteca em Java

Este projeto implementa um sistema de gerenciamento de biblioteca em Java, permitindo o cadastro de autores, livros, leitores e o controle de empréstimos.

## Funcionalidades Principais

### Cadastro e Gerenciamento
- **Autores**: Cadastro com nome e idioma.
- **Livros**: Registro com título, ISBN, lista de autores e quantidade de cópias.
- **Leitores**: Cadastro com nome, endereço e telefone, com ID único gerado automaticamente.

### Empréstimos
- Registro de empréstimos com data.
- Verificação de disponibilidade de cópias.
- Limite de 5 empréstimos por leitor.
- Impedimento de empréstimo duplicado do mesmo livro para o mesmo leitor.

### Consultas e Relatórios
- Listagem de autores em ordem alfabética.
- Listagem de livros por título, autor ou ISBN.
- Consulta de empréstimos por leitor ou por data.
- Resumo geral com estatísticas da biblioteca.

## Estrutura do Projeto

### Classes Principais
- **`Autor`**: Representa um autor com nome e idioma.
- **`Livro`**: Gerencia informações do livro, incluindo disponibilidade e cópias.
- **`Leitor`**: Armazena dados do leitor e seus empréstimos ativos.
- **`Emprestimo`**: Registra os detalhes de um empréstimo (leitor, livro, data).
- **`Biblioteca`**: Classe central que gerencia todas as operações do sistema.

### Classe de Teste
- **`App`**: Demonstra as funcionalidades do sistema com exemplos práticos.

# Diagrama de Classes do Sistema de Biblioteca

```mermaid
classDiagram
    %% Classes principais
    class Biblioteca {
        -List~Autor~ autores
        -List~Livro~ livros
        -List~Leitor~ leitores
        -List~Emprestimo~ emprestimos
        +registraAutor(Autor autor) void
        +registraLivro(Livro livro) void
        +registraLeitor(Leitor leitor) void
        +registrarEmprestimo(int idLeitor, String isbn, LocalDate data) boolean
        +livros_por_titulos() List~Livro~
        +mostrarResumo() void
    }

    class Autor {
        -String nome
        -String idioma
        +getNome() String
        +setNome(String nome) void
    }

    class Livro {
        -String titulo
        -String isbn
        -List~Autor~ autores
        -int total_copias
        -int copias_emprestadas
        +verifica_disponivel() boolean
        +registrar_emprestimo() void
    }

    class Leitor {
        -int id
        -String nome
        -String endereco
        -String telefone
        -List~Emprestimo~ emprestimos
        +temLivro(Livro book) boolean
        +emprestimosAtivos() int
    }

    class Emprestimo {
        -Leitor leitor
        -Livro livro
        -LocalDate data
        +getData() LocalDate
    }

    %% Relacionamentos
    Biblioteca "1" *-- "0..*" Autor
    Biblioteca "1" *-- "0..*" Livro
    Biblioteca "1" *-- "0..*" Leitor
    Biblioteca "1" *-- "0..*" Emprestimo
    Livro "1" *-- "1..*" Autor : autores
    Leitor "1" *-- "0..*" Emprestimo : histórico
    Emprestimo "1" --> "1" Livro : emprestado
    Emprestimo "1" --> "1" Leitor : solicitante

  