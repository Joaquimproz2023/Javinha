import java.util.Date;

class Show {
    private String nomeArtista;
    private Date data;
    private int capacidade;
    private double precoIngresso;

    public Show(String nomeArtista, Date data, int capacidade, double precoIngresso) {
        this.nomeArtista = nomeArtista;
        this.data = data;
        this.capacidade = capacidade;
        this.precoIngresso = precoIngresso;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public Date getData() {
        return data;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    @Override
    public String toString() {
        return "Show de " + nomeArtista + " em " + data + ", Ingresso: R$" + precoIngresso;
    }
}

class CasaNoturna {
    private String nome;
    private String endereco;
    private int capacidadeMaxima;

    public CasaNoturna(String nome, String endereco, int capacidadeMaxima) {
        this.nome = nome;
        this.endereco = endereco;
        this.capacidadeMaxima = capacidadeMaxima;
    }


    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
}

class Agendamento {
    private CasaNoturna casa;
    private Show show;

    public Agendamento(CasaNoturna casa, Show show) {
        this.casa = casa;
        this.show = show;
    }

    public void exibirDetalhesAgendamento() {
        System.out.println("Agendamento para a casa noturna " + casa.getNome());
        System.out.println("Show de " + show.getNomeArtista());
        System.out.println("Data: " + show.getData());
        System.out.println("Capacidade: " + show.getCapacidade() + " pessoas");
        System.out.println("Preço do Ingresso: R$" + show.getPrecoIngresso());
    }
}

public class Main {
    public static void main(String[] args) {

        CasaNoturna casaNoturna = new CasaNoturna("Casa da Música", "Rua Principal, 123", 500);


        Show show = new Show("Banda Legal", new Date(), 300, 50.0);


        Agendamento agendamento = new Agendamento(casaNoturna, show);


        agendamento.exibirDetalhesAgendamento();
    }
}
