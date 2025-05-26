package fila_atendimento;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class Service {
    private static Queue<Request> fila = new LinkedList<>(); // Fila de espera
    private static List<Request> atendidos = new ArrayList<>(); // Lista de pedidos atendidos
    private static List<Client> clientes = new ArrayList<>(); // Lista de clientes

    // Função auxiliar para procurar um cliente pelo número
    public static Client procuraCliente(String number){
        for(Client x : clientes){
            if(x.getNumber().equals(number)){
                return x;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
    
    // Registra um novo pedido ou atualiza o existente
    public static void registroPedidos(String nome, String numero, String descricao, int tipo_atendimento){
        numero = numero.trim(); // ajusta o número de telefone para remover espaços em branco 
        Client cliente = procuraCliente(numero); // Procura o cliente pelo número de telefone
        if(cliente == null){
            cliente = new Client(nome, numero); // Caso o cliente seja novo, cria um novo objeto Client
            clientes.add(cliente);
        }
        Request pedido = new Request(descricao, tipo_atendimento);
        cliente.getSolicitacao().add(pedido); // Adiciona o pedido à lista de solicitações do cliente
        fila.add(pedido);

        System.out.println("Pedido registrado com sucesso!");
    }
    
    // Lista todos os números de telefone dos clientes cadastrados
    public static void listNumbers(){
        for(Client x : clientes){
            System.out.println(x.getNumber());
        }
    }
    
    // Returna o próximo cliente na fila sem removê-lo
    public static void nextCliente(){ 
        if(fila.isEmpty()){
            System.out.println("Nenhum pedido na fila.");
            return;
        }
        
        Request next_pedido = fila.peek(); // Recebe o próximo pedido na fila
        for (Client c : clientes) {
            if (c.getSolicitacao().contains(next_pedido)) {
                System.out.println("Próximo cliente: " + c.getNome());
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    // Atende o próximo cliente na fila, removendo-o da fila e adicionando à lista de atendidos
    public static void atenderCliente(){ 
        if(fila.isEmpty()){
            System.out.println("Nenhum cliente na fila.");
            return;
        }
        
        Request pedido_atual = fila.poll(); // Recebe o próximo pedido na fila e o remove da fila
        atendidos.add(pedido_atual); // Adiciona o pedido à lista de atendidos
        System.out.println("Atendendo: " + pedido_atual.getDescricao() + " - Categoria: " + pedido_atual.getCategoria());
    }

    // Lista todos os pedidos atendidos
    public static void pedidosAtendidos(){
        if(atendidos.isEmpty()){
            System.out.println("Nenhum pedido atendido.");
            return;
        }
        // Se um pedido faz parte desta lista, que dizer que ele já foi atendido.
        for(Request x : atendidos){
            System.out.println("Pedido: " + x.getDescricao() + " - Categoria: " + x.getCategoria());
        }
    }
    // Lista todos os pedidos pendentes de atendimento;
    public static void pedidosPendentes(){
        
        Set<String> telefones = new HashSet<>();

        if(fila.isEmpty()){
            System.out.println("Nenhum pedido pendente.");
            return;
        }

        for(Request y : fila){
            for(Client x : clientes){
                if(x.getSolicitacao().contains(y)){
                    telefones.add(x.getNumber());
                }
            }
        }

        System.out.println("Pedidos pendentes de atendimento:");
        for(String t : telefones){
            System.out.println("Telefone: " + t);
        }
        
        
    }

    public static void getRelatorio(){

        int total = fila.size() + atendidos.size();
        int suporte = 0, info = 0, financeiro = 0;

        List<Request> all = new ArrayList<>(fila);
        all.addAll(atendidos);

        for(Request r : all){
            switch (r.getCategoria()) {
                case "Suporte Técnico":
                    suporte++;
                    break;
                case "Informação":
                    info++;
                    break;
                case "Atendimento Financeiro":
                    financeiro++;
                    break;

            }
        }
        System.out.println("\n----- RELATÓRIO -----");
        System.out.println("Total de solicitações: " + total);
        System.out.println("Solicitações atendidas: " + atendidos.size());
        System.out.println("Solicitações em espera: " + fila.size());

        if (total > 0) {
            System.out.printf("Suporte Técnico: %.2f%%\n", (suporte * 100.0 / total));
            System.out.printf("Informação: %.2f%%\n", (info * 100.0 / total));
            System.out.printf("Atendimento Financeiro: %.2f%%\n", (financeiro * 100.0 / total));
        }
    }
}
