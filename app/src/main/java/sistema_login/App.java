package sistema_login;

public class App {
    public static void main(String[] args){
        
        Usuario user_one = new Usuario("HinaTA", "senha1");
        Usuario user_two = new Usuario("Tiago", "senha2");

        Gerenciador.cadastroUser(user_one);
        Gerenciador.cadastroUser(user_one);
        Gerenciador.cadastroUser(user_two);

        Gerenciador.listUsers();
        Gerenciador.removeUser("hinata");
        Gerenciador.listUsers();

        Gerenciador.autenticatorUser("tiago", "senha2");
    }
}
