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
        
        if(numero == null || numero.isEmpty() || numero.length() > 9){
            throw new IllegalArgumentException("Número inválido");
        }

        return numero.trim();
    }

    // Cada cliente pode ter vários pedidos, todos adicionados à lista solicitacao
    public void addRequest(String description, int type){
        Request pedido = new Request(description, type);
        solicitacao.add(pedido); // solicitação é uma lista de pedidos
    }

    // Retorna a lista de pedidos do cliente
    public List<Request> getSolicitacao(){ 
        return this.solicitacao;
    }
    public String getNome(){
        return this.nome;
    }

    public String getNumber(){
        return this.numero;
    }

   


}
