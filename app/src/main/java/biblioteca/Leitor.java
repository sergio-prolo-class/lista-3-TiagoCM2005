package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private static int idCounter = 0;
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private List<Emprestimo> emprestimos; // cada leito tem uma lista de emprestimos

    public Leitor(String nome, String endereco, String telefone) {
        this.id = idCounter++; // Método para gerar um ID único
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();

    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getTelefone(){
        return telefone;
    }

    public List<Emprestimo> getEmprestimos(){
        return new ArrayList<>(emprestimos);    
}

    public void setEmprestimo(Emprestimo e){
        emprestimos.add(e);
    }

    public int ativosEmprestimos(){
        return emprestimos.size();

    }

    public boolean temLivro(Livro book){
        for(Emprestimo e : emprestimos){
            if(e.getLivro().equals(book)){
                return true;
            }
        }
        return false;
    }

    

}
