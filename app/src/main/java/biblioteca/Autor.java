package biblioteca;

public class Autor {
    private String nome;
    private String idioma;

    public Autor(String nome, String idioma){
        this.nome = nome;
        this.idioma = idioma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

}
