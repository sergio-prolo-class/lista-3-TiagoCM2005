package biblioteca;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Criando a biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Cadastrando autores
        Autor autor1 = new Autor("Machado de Assis", "Português");
        //Autor autor2 = new Autor("George Orwell", "Inglês");

        biblioteca.registraAutor(autor1);
        //biblioteca.registraAutor(autor2);

        // Cadastrando livros
        Livro livro1 = new Livro("Dom Casmurro", "978-85-01-00001-1", List.of(autor1), 3);
        //Livro livro2 = new Livro("1984", "978-85-01-00002-2", List.of(autor2), 2);

        biblioteca.registraLivro(livro1);
        //biblioteca.registraLivro(livro2);

        // Cadastrando leitores
        Leitor leitor1 = new Leitor("João da Silva", "Rua A, 123", "9999-1111");
        //Leitor leitor2 = new Leitor("Maria Oliveira", "Rua B, 456", "9999-2222");

        biblioteca.registraLeitor(leitor1);
        //biblioteca.registraLeitor(leitor2);

        // Registrando empréstimos
        boolean emprestado1 = biblioteca.registrarEmprestimo(leitor1.getId(), "978-85-01-00001-1", LocalDate.of(2025, 5, 28));
        //boolean emprestado2 = biblioteca.registrarEmprestimo(leitor2.getId(), "978-85-01-00002-2", LocalDate.of(2025, 5, 29));

        System.out.println("\n>>> Empréstimos realizados:");
        System.out.println("João emprestou Dom Casmurro? " + emprestado1);
        //System.out.println("Maria emprestou 1984? " + emprestado2);

        // Listar autores em ordem alfabética
        System.out.println("\n>>> Autores cadastrados:");
        for (Autor autor : biblioteca.alfAutor()) {
            System.out.println(autor);
        }

        // Listar livros por título
        System.out.println("\n>>> Livros por título:");
        for (Livro livro : biblioteca.livros_por_titulos()) {
            System.out.println(livro);
        }

        // Listar empréstimos por leitor
        System.out.println("\n>>> Empréstimos do João:");
        for (Emprestimo e : biblioteca.emprestimos_por_Leitor(leitor1.getId())) {
            System.out.println(e);
        }

        // Resumo geral
        System.out.println("\n>>> Resumo da biblioteca:");
        biblioteca.mostrarResumo();
    }
}
