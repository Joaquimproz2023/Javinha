class Evento {
    private String nome;
    private Date data;

    public Evento(String nome, Date data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

class ShowDeMusica extends Evento {
    private int capacidade;
    private double precoIngresso;

    public ShowDeMusica(String nome, Date data, int capacidade, double precoIngresso) {
        super(nome, data);
        this.capacidade = capacidade;
        this.precoIngresso = precoIngresso;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }
}
