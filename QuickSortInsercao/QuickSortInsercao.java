package QuickSortInsercao;

import java.util.ArrayList;

import ReservaType.Reserva;

public class QuickSortInsercao {
    ArrayList<Reserva> lista;

    public QuickSortInsercao(ArrayList<Reserva> data) {
        this.lista = data;
    }

    public ArrayList<Reserva> getLista() {
        return lista;
    }

    public ArrayList<Reserva> ordena() {
        ordena(0, this.lista.size() - 1);
        return this.lista;
    }

    public void ordena(int esq, int dir) {
        if ((dir - esq) == 20) {

        }
        int i = esq, j = dir;
        Reserva pivo, temp;

        pivo = this.lista.get((i + j) / 2);

        do {
            while (comparaElementos(pivo, this.lista.get(i)) < 0) {// compara por nome se o pivo é menor ou igual ao
                                                                   // indice atual de i (elemento), caso menor
                                                                   // incrementa i
                i++;
            }
            while (comparaElementos(pivo, this.lista.get(j)) > 0) {// incrementa J caso o elemento de indice J seja
                                                                   // maior que o pivo
                j--;
            }

            if (i <= j) {
                temp = this.lista.get(i);
                this.lista.set(i, this.lista.get(j));
                this.lista.set(j, temp);
                i++;
                j--;
            }
        } while (i <= j);

        if (esq < j) {
            ordena(esq, j);
        }

        if (dir > i) {
            ordena(i, dir);
        }
    }

    public int comparaElementos(Reserva pivo, Reserva elemento) {
        int comparacao = elemento.getNome().compareTo(pivo.getNome());
        if (comparacao == 0) {
            comparacao = pivo.getCodReserva().compareTo(pivo.getCodReserva());
        }
        return comparacao;
    }

    public void ordenaInsercao() {
        int i, j;
        Reserva temp;

        for (i = 1; i < this.lista.size(); i++) {
            temp = this.lista.get(i);
            j = i - 1;
            while ((j >= 0) && (comparaElementos(temp, temp) > 0)) {
                this.lista.set(j + 1, this.lista.get(j));
                j--;
            }
            this.lista.set(j + 1, temp);
        }
    }
}