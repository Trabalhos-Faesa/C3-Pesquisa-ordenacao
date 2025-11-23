package Heap;

import java.util.ArrayList;

import ReservaType.Reserva;

public class Heap {
    private int quantidade;
    private ArrayList<Reserva> data;

    public Heap(ArrayList<Reserva> data){
        this.data = data;
        this.quantidade = data.size();
    }

    public ArrayList<Reserva> ordenar(){
        int dir = quantidade -1;
        int esq = (dir -1)/2;
        Reserva temp;

        while(esq >= 0){
            ordenar(esq, this.quantidade-1);
            esq--;
        }
        while (dir > 0) {
            temp = this.data.get(0);
            this.data.set(0, this.data.get(dir));
            this.data.set(dir, temp);
            dir--;
            ordenar(0, dir);
        }

        return this.data;
    }

    public void ordenar(int esq, int dir){
        int i = esq;
        int maior = 2*i+1;  
        Reserva raiz = this.data.get(i);
        boolean heap= false;

        while((maior <= dir) && !heap){
            if(maior < dir){
                if(comparaElementos(this.data.get(maior), this.data.get(maior+1)) < 0){
                    maior++;
                }
            }
            if(comparaElementos(raiz, this.data.get(maior)) < 0){
                this.data.set(i, this.data.get(maior));
                i = maior;
                maior = 2*i + 1;
            }else heap = true;
        }
        this.data.set(i, raiz);
    }


    public int comparaElementos(Reserva elem1, Reserva elem2){
        int resultado = elem1.getNome().compareTo(elem2.getNome());

        if(resultado == 0){
            resultado = elem1.getCodReserva().compareTo(elem2.getCodReserva());
        }

        return resultado;
    }
}
