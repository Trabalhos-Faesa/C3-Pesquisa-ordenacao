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
        int i, soma = 0;
        char c;
        
        for (i = 0; i < nome.length(); i++) {//transforma o nome em um valor numerico
            c = nome.charAt(i);
            soma += Character.getNumericValue(c);
        }

        return soma%capacidade;
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
