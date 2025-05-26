package fila_atendimento;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Service {
    private static Queue<Request> fila = new LinkedList<>(); // Fila de espera
    private static List<Request> atendidos = new ArrayList<>(); // Lista de pedidos atendidos
    private static List<Client> clientes = new ArrayList<>(); // Lista de clientes

    public static Client seachClient(String number){
        for(Client x : clientes){
            if(x.getNumber().equals(number)){
                return x;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
    
    public static void registerRequest(String nome, String numero, String descricao, int tipo_atendimento){
        
        numero = numero.trim(); 
        Client cliente = seachClient(numero);
        if(cliente == null){
            cliente = new Client(nome, numero);
            clientes.add(cliente);
        }
        Request pedido = new Request(descricao, tipo_atendimento);
        cliente.getSolicitacao().add(pedido); // Adiciona o pedido à lista de solicitações do cliente
        fila.add(pedido);

        System.out.println("Pedido registrado com sucesso!");
    }

    public static void listNumbers(){
        for(Client x : clientes){
            System.out.println(x.getNumber());
        }
    }

    public static void meetClient(){ 
        if(fila.isEmpty()){
            System.out.println("Nenhum pedido na fila.");
            return;
        }
        
        Request next = fila.peek(); // Recebe o próximo pedido na fila
        atendidos.add(next); // Adiciona o pedido à lista de atendidos
        System.out.println("Atendendo: " + next.getDescricao() + " - Categoria: " + next.getCategoria());
    }

    public static void listAttendedRequests(){
        if(atendidos.isEmpty()){
            System.out.println("Nenhum pedido atendido.");
            return;
        }
        
        for(Request x : atendidos){
            System.out.println("Pedido: " + x.getDescricao() + " - Categoria: " + x.getCategoria());
        }
    }

    
}
