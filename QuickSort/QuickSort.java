package QuickSort;
import java.util.ArrayList;

import ReservaType.Reserva;

public class QuickSort{
    ArrayList<Reserva> lista;

    public QuickSort(ArrayList<Reserva> data){
        this.lista = data;
    }

    public ArrayList<Reserva> getLista() {
        return lista;
    }

    public ArrayList<Reserva> ordena(){
        ordena(0, this.lista.size() -1);
        return this.lista;
    }

    public void ordena(int esq, int dir){

        int i = esq, j = dir;
        String pivo; 
        pivo = this.lista.get((i+j)/2).getCodReserva();

        do{
            while(this.lista.get(i).getCodReserva().compareTo(pivo) < 0){
                i++;
            }
            while(this.lista.get(j).getCodReserva().compareTo(pivo) > 0){
                j--;
            }

            if(i <= j){
                Reserva temp = this.lista.get(i);
                this.lista.set(i, this.lista.get(j));
                this.lista.set(j, temp);
                i++;
                j--; 
            }
        }while(i <= j);
        
        if(esq < j){
            ordena(esq, j);
        }

        if(dir > i){
            ordena(i, dir);
        }
    }
}