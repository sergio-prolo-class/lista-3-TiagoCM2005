package fila_atendimento;

public class App {

    public static void main(String[] args) {

        System.out.println("REGISTRANDO SOLICITAÇÕES...\n");

        Service.registroPedidos("Ana", "111111111", "Erro na tela", 1);     // Suporte Técnico
        //Service.registroPedidos("Carlos", "222222222", "Consulta boleto", 3); // Financeiro
        //Service.registroPedidos("Ana", "111111111", "Senha não funciona", 1); // Ana novamente
        //Service.registroPedidos("João", "333333333", "Informações do plano", 2); // Informação

        System.out.println("\nPRÓXIMO CLIENTE:");
        Service.nextCliente();

        System.out.println("\nATENDENDO CLIENTES...");
        Service.atenderCliente();

        System.out.println("\nLISTANDO TELEFONES DE CLIENTES CADASTRADOS:");
        Service.pedidosPendentes();

        System.out.println("\nLISTANDO CLIENTES ATENDIDOS:");
        Service.pedidosPendentes();

        System.out.println("\nLISTANDO TELEFONES EM ESPERA:");
        Service.pedidosPendentes();

        System.out.println("\nRELATÓRIO FINAL:");
        Service.getRelatorio();
    }
}