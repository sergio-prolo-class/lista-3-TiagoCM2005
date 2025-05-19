package sistema_login;
import java.util.*;

public class Gerenciador{

    private static List<Usuario> user = new ArrayList<Usuario>(); // Cria uma lista de usuários;
    

    // Adiciona apenas se o usuario não existe na lista;
    public static void cadastroUser(Usuario user0){
        if(!verificaUser(user0)){
            user.add(user0);
            
            System.out.println("Adicionado com sucesso!");
            
        } else System.out.println("Este usuário já foi adicionado!");
        

    }
    
    // Verifica se o usuário já existe dentro da lista;
    //return true caso existe ou false caso não exista;
    private static boolean verificaUser(Usuario user1){
        if(user.contains(user1)){
            return true;
        }
        return false;
    }
    
    // Percorre toda a lista de usuários e imprime todos os logins;
    public static void listUsers(){
        String usuarios;
        for(int i = 0; i < user.size(); i++){
            usuarios = user.get(i).getLogin();
            System.out.println(usuarios);
        }
    }
    // Percorre toda a lista de usuários, verifica se o login testado já existe e o remove;
    public static void removeUser(String login){
        for(int i = 0; i < user.size(); i++){
            if(user.get(i).getLogin().equals(login)){
                user.remove(i);
                System.out.println("Removido com sucesso!");
                return;
            }
        }
        System.out.println("Este usuário não existe!");

    }
    // Mesma lógica do removeUser, mas não remove o usuário, apenas verifica se existe aquele login e senha, e retorna true ou false;
    public static boolean autenticatorUser(String login, String senha){
        for(int i = 0; i < user.size(); i++){
            if(user.get(i).getLogin().equals(login) && user.get(i).getSenha().equals(senha)){
                System.out.println("Conta logado com sucesso!");
                return true;
            }
        }
                System.out.println("Senha/Login incorretos!");
                return false;
        }
    }
    

    


    
