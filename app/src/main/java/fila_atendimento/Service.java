package fila_atendimento;
import java.util.*;

public class Service {
    private static Queue<Request> fila = new LinkedList<>();
    private static List<Request> atendidos = new ArrayList<>();
    private static List<Client> clientes = new ArrayList<>();

    public static void registerClient(Client cliente, Request r){
        clientes.add(cliente);
        fila.add(r);
    }

    public static void nextQueue(){

    }

    public static void listNumbers(){
        for(Client numeros : clientes){
            System.out.println(numeros.getNumber());
        }
    }
}
