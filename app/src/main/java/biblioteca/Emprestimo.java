package biblioteca;

import java.time.LocalDate;
public class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private LocalDate data;

    public Emprestimo(Leitor leitor, Livro livro, LocalDate data){
        this.leitor = leitor;
        this.livro = livro;
        this.data = data;
    }

    public Leitor getLeitor(){
        return leitor;
    }

    public Livro getLivro(){
        return livro;
    }

    public LocalDate getData(){
        return data;
    }
}
