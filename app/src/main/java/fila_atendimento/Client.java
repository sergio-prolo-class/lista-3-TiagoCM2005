package fila_atendimento;
import java.util.*;

public class Client {
    private String nome;
    private String numero;
    private String descricao;
    private int atendimento; // 1 - Suporte Técnico // 2 - Informação // 3 - Atendimento Financeiro //
    private String tipo;
    final private String erro = "Erro";
    
    static private  List<String> telefone = new ArrayList<>();
    static private List<String> nomes = new ArrayList<>();
    static private List<Request> solicitacao = new ArrayList<Request>();

    public Client(String name, String numero){
        this.nome = formatName(name);
        nomes.add(this.nome);
        this.numero = formatNumber(numero);
        telefone.add(numero);
  
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


    static public void getNumbers(){
        for(String numeros : telefone){
            System.out.println(numeros);
        }
    }

    static public void getNames(){
        for(String names : nomes){
            System.out.println(names);
        }
    }



}
