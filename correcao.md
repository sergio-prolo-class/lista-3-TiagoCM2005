# Correção

| Questão     | Legibilidade | Diagramas | P1 | P2 | P3 | Total |
|-------------|--------------|-----------|----|----|----|-------|
| Nota máxima | 10           | 10        | 20 | 25 | 35 | 100   |
| Nota        | 7            | 9         | 14 | 22 | 30 |       |

- esqueceu de atualizar o gitignore, veio cheio de arquivo desnecessário (app/bin, por exemplo)
- cuidado com níveis de indentação
- 
## Diagramas

- atributos com tipo e nome invertidos
- membros estáticos sem sublinhado
- P2:
  - Client compõe Request e Service agrega? não parece certo
- P3:
  - Uma associação de agregação, por padrão, permite acesso ao agregado
  - portanto, a associação dupla entre Leitor e Emprestimo é (provavelmente) desnecessária

## P1

- seu diagrama dizia que Gerenciador compõe Usuário, mas App consegue criar objetos Usuario
- aquele problema de usar listas e não conjuntos que falei em aula

### Requisitos Funcionais
- [x] Cadastrar novos usuários
- [x] Remover usuários
- [x] Listar os logins
- [x] Autenticar usuários

## P2

- SoC: multiplas classes com println
- conjunto de clientes armazenado como lista
- Client.addRequest existe, mas não é usado?

### Requisitos Funcionais
- [x] Registrar novas solicitações
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [x] Listar os nomes dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera
- [x] Gerar um relatório estatístico
- [x] ... total de solicitações registradas, atendidas, em espera
- [x] ... distribuição percentual das solicitações por categoria

## P3

- novamente, conjuntos implementados como lista
- número de cópias e disponíveis é algo da bibliteca, não do objeto Livro
- Métodos de listagem retoram os objetos em si. é melhor retornar Strings.
- Livro
  - Leitor.temLivro(Livro b) usa Livro.equals(), que não é sobrescrito em Livro
  - ou seja, só vai impedir o emprestimo se o Livro for o mesmo objeto na memória
  - não há garantia que o ISBN é único
  - joga exceções que não são tratadas

### Requisitos Funcionais
- [x] Cadastrar autores
- [ ] Cadastrar livros
- [x] Cadastrar leitores
- [x] Registrar empréstimos de livros para leitores
- [x] ... pelo menos uma cópia
- [ ] ... leitor não tenha esse livro
- [x] ... leitor possua no máximo 5 livros emprestados
- [x] Listar autores em ordem alfabética
- [x] Listar leitores em ordem alfabética
- [x] Listar leitores por id
- [x] Listar livros por título
- [x] Listar livros por autor
- [x] Listar livros por ISBN
- [x] Listar empréstimos por data
- [x] Listar empréstimos de um leitor, por data