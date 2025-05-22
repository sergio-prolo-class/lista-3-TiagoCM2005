package sistema_login;

public class Usuario {
    String login; 
    String senha;

    public Usuario(String login, String senha){
        this.login = formatLogin(login);
        this.senha = senha;
    }

    private String formatLogin(String str){ // Deixa o login sempre no mesmo padrão
        return str.toLowerCase();
    }
    
    public String getLogin(){
        return this.login;
    }

    public String getSenha(){
        return this.senha;
    }
    
    
}
