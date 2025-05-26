package fila_atendimento;
import java.util.*;

public class Client {
    private List<Request> solicitacao = new ArrayList<Request>();
    private String nome;
    private String numero;
    final private String erro = "Erro";


    public Client(String name, String numero){
        this.nome = formatName(name);
        this.numero = formatNumber(numero);
   
  
    }

    private String formatName(String name){ 
        if(name == null || name.isEmpty()){
            return erro;
        }
        name = name.toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private String formatNumber(String numero){
        int len = numero.length();
        if(numero == null || numero.isEmpty() || len > 9){
            System.out.println("Número inválido!");
        }

        return numero;
    }

    public void setRequest(String description, int request){
        Request pedido = new Request(description, request);
        solicitacao.add(pedido);
    }


    public String getNome(){
        return this.nome;
    }

    public String getNumber(){
        return this.numero;
    }

   


}
