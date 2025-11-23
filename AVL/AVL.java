import java.util.ArrayList;

import ReservaType.Reserva;

public class AVL {
    private NoAVL raiz;
    private boolean balancear;
    private int quantidade;

    public AVL(){
        this.raiz = null;
        this.quantidade = 0;
        this.balancear = false;
    }

    public NoAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NoAVL raiz) {
        this.raiz = raiz;
    }

    public boolean isBalancear() {
        return balancear;
    }

    public void setBalancear(boolean balancear) {
        this.balancear = balancear;
    }

    public void inserir(Reserva reserva){
        this.raiz = this.inserir(reserva, this.raiz);
    }

    public NoAVL inserir(Reserva reserva, NoAVL no){
        if(no == null){
            NoAVL novo = new NoAVL(reserva);
            this.quantidade++;
            this.balancear = true;
            return novo;
        }else{
            if(reserva.getCodReserva().compareTo(no.getReserva().getCodReserva()) > 0){
                no.setDir(inserir(reserva, no.getDir()));
                no = this.balancearEsq(no);
                return no;
            }else{
                no.setEsq(inserir(reserva, no.getEsq()));
                no = this.balancearDir(no);
                return no;
            }
        }
    }

    private NoAVL balancearEsq(NoAVL no){
        if(this.balancear){
            switch (no.getFatorBalanceamento()) {
                case 1:
                    no.setFatorBalanceamento(0);
                    this.balancear = false;
                    break;
            
                case 0:
                    no.setFatorBalanceamento(-1);
                    break;
                case -1:
                    no = this.rotacaoEsq(no);
            }
        }
        return no;
    }

    private NoAVL rotacaoEsq(NoAVL no){
        NoAVL temp1, temp2;
        temp1 = no.getDir();

        if(temp1.getFatorBalanceamento() == -1){
            no.setDir(temp1.getEsq());
            temp1.setEsq(no);
            no.setFatorBalanceamento(0);
            no = temp1;
        }
        else{
            temp2 = temp1.getEsq();
            
            no.setDir(temp2.getEsq());
            temp1.setEsq(temp2.getDir());
            temp2.setDir(temp1);
            temp2.setEsq(no);

            if(temp2.getFatorBalanceamento() == 1){
                no.setFatorBalanceamento(0);
                temp1.setFatorBalanceamento(-1);
            }else if(temp2.getFatorBalanceamento() == -1){
                no.setFatorBalanceamento(1);
                temp1.setFatorBalanceamento(0);
            }else{
                no.setFatorBalanceamento(0);
                temp1.setFatorBalanceamento(0);
            }
            
            no = temp2;
        }
        no.setFatorBalanceamento(0);
        this.balancear = false;
        return no;
    }

    private NoAVL balancearDir(NoAVL no){
        if(this.balancear){
            switch (no.getFatorBalanceamento()) {
                case -1:
                    no.setFatorBalanceamento(0);
                    this.balancear = false;
                    break;

                case 0:
                    no.setFatorBalanceamento(+1);
                    break;
                
                case 1:
                    no = this.rotacaoDir(no);
            }
        }
        return no;
    }

    private NoAVL rotacaoDir(NoAVL no){
        NoAVL temp1, temp2;
        temp1 = no.getEsq();

        if(temp1.getFatorBalanceamento() == 1){
            no.setEsq(temp1.getDir());
            temp1.setDir(no);
            no.setFatorBalanceamento(0);
            no = temp1;
        }
        else{
            temp2 = temp1.getDir(); 

            temp1.setDir(temp2.getEsq()); 
            no.setEsq(temp2.getDir()); 
            temp2.setEsq(temp1);
            temp2.setDir(no);
            
            if(temp2.getFatorBalanceamento() == 1){
                no.setFatorBalanceamento(-1);
                temp1.setFatorBalanceamento(0);
            }else if(temp2.getFatorBalanceamento() == -1){
                no.setFatorBalanceamento(0);
                temp1.setFatorBalanceamento(1);
            }
            else{
                no.setFatorBalanceamento(0);
                temp1.setFatorBalanceamento(0);
            }
            
            no = temp2;
        }
        no.setFatorBalanceamento(0);
        this.balancear = false;
        return no;
    }

    public ArrayList<Reserva> pesquisarNome(String nome) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        return pesquisarNome(this.raiz, nome, reservas);
    }

    private ArrayList<Reserva> pesquisarNome(NoAVL no, String nome, ArrayList<Reserva> reservas) {
        if (no != null) {
            pesquisarNome(no.getEsq(), nome, reservas);

            if (no.getReserva().getNome().equals(nome)) {
               reservas.add(no.getReserva()); 
            }
            
            pesquisarNome(no.getDir(), nome, reservas);
        }

        return reservas;
    }
}