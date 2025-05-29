package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private static int idCounter = 0;
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private List<Emprestimo> emprestimos;

    public Leitor(String nome, String endereco, String telefone) {
        this.id = idCounter++; // Método para gerar um ID único
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
