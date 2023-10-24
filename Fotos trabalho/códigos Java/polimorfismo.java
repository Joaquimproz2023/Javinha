ArrayList<Evento> eventos = new ArrayList<Evento>();

eventos.add(new ShowDeMusica("Show de Música", data, capacidade, precoIngresso));
eventos.add(new ShowDeComedia("Show de Comédia", data, faixaEtaria));

for (Evento evento : eventos) {
    System.out.println("Nome: " + evento.getNome());
    System.out.println("Data: " + evento.getData());

}
