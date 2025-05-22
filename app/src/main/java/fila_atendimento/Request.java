package fila_atendimento;

public class Request {
    private String descricao;
    private int tipo_atendimento;
    private String categoria ;

    public Request(String descricao, int tipo_atendimento){
        this.descricao = descricao;
        this.categoria = formatService(tipo_atendimento);
    }

     private String formatService(int tipo_atendimento){
        
        switch (tipo_atendimento){
            case 1:
                categoria = "Suporte Técnico";
                break;

            case 2:
                categoria = "Informação";
                break;

            case 3:
                categoria = "Atendimento Financeiro";
                break;

            default:
                System.out.println("Escolha um tipo existente!");
                return null;
        }
        return categoria;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getCategoria(){
        return this.categoria;
    }

}
