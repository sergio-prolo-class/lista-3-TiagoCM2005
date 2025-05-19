package sistema_login;

public class App {
    public static void main(String[] args){
        Usuario user_one = new Usuario("teste1", "teste1");
        Usuario user_two = new Usuario("TESTE", "null");
        Gerenciador.cadastroUser(user_one);
        Gerenciador.cadastroUser(user_one);
        Gerenciador.cadastroUser(user_two);

        Gerenciador.listUsers();
    }
}
