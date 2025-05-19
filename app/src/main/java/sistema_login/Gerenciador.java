package sistema_login;
import java.util.*;

public class Gerenciador{

    private static List<Usuario> user = new ArrayList<Usuario>();
    private static int contador;
    
    // Adiciona apenas se o usuario não existe na lista;
    public static void cadastroUser(Usuario user0){
        if(!verificaUser(user0)){
            user.add(user0);
            contador++;

            System.out.println("Adicionado com sucesso!");
            System.out.println(contador);
            
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
    
    
    public static void listUsers(){
        String usuarios;
        for(int i = 0; i < user.size(); i++){
            usuarios = user.get(i).getLogin();
            System.out.println(usuarios);
        }
    }
    }


    
