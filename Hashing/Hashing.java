package Hashing;

import ReservaType.Reserva;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashing {

    private ArrayList<LinkedList<Reserva>> lista;
    private final int capacidade;

    public Hashing(int quantidade) {
        this.capacidade = (int)(quantidade * 1.1);
        lista = new ArrayList<>(this.capacidade);

        for (int i = 0; i < this.capacidade; i++) {//preenche a lista com listas ligadas vazias
            lista.add(new LinkedList<Reserva>());
        }
    }
    
    private int calculaValorHash(String nome) {
        int hash = 0;
        int primo = 31; // Fator multiplicador
        for (int i = 0; i < nome.length(); i++) {
            hash = (primo * hash + nome.charAt(i)) % capacidade;// calcula o hash usando o fator da multiplicação
        }
        // Garante que o resultado é positivo
        if (hash < 0) {
            hash += capacidade;
        }
    
    return hash;
}

    public void inserir(Reserva data) {
        int index = calculaValorHash(data.getNome());
        lista.get(index).add(data);
    }

    public LinkedList<Reserva> searchByName(String nome) {
        int nameValue = calculaValorHash(nome);
        for (Reserva r : lista.get(nameValue)) {
            if (r.getNome().equals(nome)){//garante que o nome bate exatamente
                return lista.get(nameValue);
            }
        }
        return null;
    }
}
