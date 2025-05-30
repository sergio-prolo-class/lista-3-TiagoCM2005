package biblioteca;
// Classe responsável pelo gerenciamento de dados.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.*;

public class Biblioteca {
    private List<Autor> autores; // Lista de autores
    private List<Livro> livros; 
    private List<Leitor> leitores;
    private List<Emprestimo> emprestimos; 


    public Biblioteca() {
        this.autores = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.leitores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void registraAutor(Autor autor){
        if (!autores.contains(autor)){
            autores.add(autor);
        }
    }

    public void registraLivro(Livro livro){
         if (!livros.contains(livro)){
            livros.add(livro);
        }
    }

    public void registraLeitor(Leitor leitor){
        leitores.add(leitor);
    }

    public Leitor leitor_por_Id(int id) {
    for (Leitor l : leitores) {
        if (l.getId() == id) {
            return l;
        }
    }
    return null;
    }

    public Livro buscar_pro_ISBN(String isbn){
        for (Livro l : livros){
            if (l.getIsbn() == isbn){
                return l;
            }
        }
        return null;
    }

    public List<Livro> livros_por_titulos() {
        List<Livro> copia = new ArrayList<>(livros);
        Collections.sort(copia, new Comparator<Livro>() {
            public int compare(Livro l1, Livro l2) {
                return l1.getTitulo().compareToIgnoreCase(l2.getTitulo());
            }
        });
        return copia;
    }

    public List<Livro> livros_por_Autor() {
        List<Livro> copia = new ArrayList<>(livros);
        Collections.sort(copia, new Comparator<Livro>() {
            public int compare(Livro l1, Livro l2) {
                // Considerando apenas o primeiro autor
                String a1 = l1.getAutores().isEmpty() ? "" : l1.getAutores().get(0).getNome();
                String a2 = l2.getAutores().isEmpty() ? "" : l2.getAutores().get(0).getNome();
                return a1.compareToIgnoreCase(a2);
            }
        });
        return copia;
    }

    public List<Livro> livros_por_ISBN() {
        List<Livro> copia = new ArrayList<>(livros);
        Collections.sort(copia, new Comparator<Livro>() {
            public int compare(Livro l1, Livro l2) {
                return l1.getIsbn().compareToIgnoreCase(l2.getIsbn());
            }
        });
        return copia;
    }

    public List<Emprestimo> emprestimos_por_Data() {
        List<Emprestimo> copia = new ArrayList<>(emprestimos);
        Collections.sort(copia, new Comparator<Emprestimo>() {
            public int compare(Emprestimo e1, Emprestimo e2) {
                return e1.getData().compareTo(e2.getData());
            }
        });
        return copia;
    }

     public List<Emprestimo> emprestimos_por_Leitor(int idLeitor) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getLeitor().getId() == idLeitor) {
                resultado.add(e);
            }
        }
        Collections.sort(resultado, new Comparator<Emprestimo>() {
            public int compare(Emprestimo e1, Emprestimo e2) {
                return e1.getData().compareTo(e2.getData());
            }
        });

        return resultado;
    }

    public List<Autor> alfAutor() {
        List<Autor> copia = new ArrayList<>(autores);
        Collections.sort(copia, new Comparator<Autor>() {
            public int compare(Autor a1, Autor a2) {
                return a1.getNome().compareToIgnoreCase(a2.getNome());
            }
        });
        return copia;
    }

    public List<Leitor> leitorNome() {
        List<Leitor> copia = new ArrayList<>(leitores);
        Collections.sort(copia, new Comparator<Leitor>() {
            public int compare(Leitor l1, Leitor l2) {
                return l1.getNome().compareToIgnoreCase(l2.getNome());
            }
        });
        return copia;
    }

    public List<Leitor> leitorId() {
        List<Leitor> copia = new ArrayList<>(leitores);
        Collections.sort(copia, new Comparator<Leitor>() {
            public int compare(Leitor l1, Leitor l2) {
                return Integer.compare(l1.getId(), l2.getId());
            }
        });
        return copia;
    }

    public boolean registrarEmprestimo(int idLeitor, String isbn, LocalDate data){
        Leitor leitor = leitor_por_Id(idLeitor);
        Livro livro = buscar_pro_ISBN(isbn);

        if(leitor == null || livro == null){
            throw new IllegalStateException("Nenhum leitor ou livro encontrado!");
        }

        if(!livro.verifica_disponivel()) {
            throw new IllegalStateException("Nenhum livro disponível para emprestimo!");
        }

        if(leitor.temLivro(livro)) {
            throw new IllegalStateException("Você já tem este livro!");
        }

        if(leitor.emprestimosAtivos() >= 5){
            throw new IllegalStateException("Limite de emprestimos atingidos!");
        }

        Emprestimo e = new Emprestimo(leitor, livro, data);
            emprestimos.add(e);
            livro.registrar_emprestimo();
            leitor.setEmprestimo(e);
            return true;
        }
    

    public void mostrarResumo() {
        System.out.println("Autores cadastrados: " + autores.size());
        System.out.println("Livros cadastrados: " + livros.size());
        System.out.println("Leitores cadastrados: " + leitores.size());
        System.out.println("Empréstimos realizados: " + emprestimos.size());
    }
}
