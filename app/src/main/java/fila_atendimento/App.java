package fila_atendimento;

public class App{
    public static void main(String[] args){
        Client tiago = new Client("tiAgo", "996894938");
        Client marcus = new Client("marcus", "998523579");

        

        tiago.setRequest("Preciso de ajuda para configurar meu produto", 1);
        Service.listNumbers();
        System.out.println();
    }
}