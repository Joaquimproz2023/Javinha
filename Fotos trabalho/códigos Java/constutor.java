class Evento {
    public Evento(String nome, Date data) {
        this.nome = nome;
        this.data = data;
    }
}

class ShowDeMusica extends Evento {
    public ShowDeMusica(String nome, Date data, int capacidade, double precoIngresso) {
        super(nome, data);
        this.capacidade = capacidade;
        this.precoIngresso = precoIngresso;
    }
}

class ShowDeComedia extends Evento {
    public ShowDeComedia(String nome, Date data, int faixaEtaria) {
        super(nome, data);
        this.faixaEtaria = faixaEtaria;
    }
}
