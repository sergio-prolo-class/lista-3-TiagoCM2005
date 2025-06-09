package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String isbn;
    private List<Autor> autores;
    private int total_copias;
    private int copias_emprestadas;

    public Livro(String titulo, String isbn, List<Autor> autores, int total_copias) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autores = new ArrayList<>(autores);
        this.total_copias = total_copias;
        this.copias_emprestadas = 0;
    }

    // retornar o titulo do livro
    public String getTitulo() {
        return titulo;
    }

    // retornar o isbn do livro
    public String getIsbn() {
        return isbn;
    }   

    // retornar a lista de autores do livro
    public List<Autor> getAutores() {
        return new ArrayList<>(autores);
    }

    // retornar o total de cópias do livro
    public int getTotalCopias() {
        return total_copias;
    }

    // retornar o total de cópias emprestadas do livro
    public int getCopiasEmprestadas() {
        return copias_emprestadas;
    }

    // retorna true ou false se existe um livro disponível para empréstimo
    public boolean verifica_disponivel(){
        return total_copias > copias_emprestadas;
    }

    // para registrar um empréstimo, verifica se há cópias disponíveis e incrementa o contador de cópias emprestadas
    public void registrar_emprestimo(){
        if(!verifica_disponivel()) {
            throw new IllegalStateException("Não há cópias disponíveis para empréstimo.");
        }
        copias_emprestadas++;
    }

    // para registrar uma devolução, verifica se há cópias emprestadas e decrementa o contador de cópias emprestadas
    public void registrar_devolucao(){
        if(copias_emprestadas == 0) {
            throw new IllegalStateException("Não há cópias emprestadas para devolver.");
        }
        copias_emprestadas--;
    }




    
}
