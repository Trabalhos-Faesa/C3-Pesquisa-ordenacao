import java.util.ArrayList;

public class ABB {
    private NoArv raiz;
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }
    
    public NoArv getRaiz(){
        return this.raiz;
    }

    // pesquisa pelo codigo da reserva, a arvore será organizada pelo codigo da
    // reserva por ele ser unico.
    public NoArv pesquisarReserva(Reserva reserva) {
        return pesquisarReserva(raiz, reserva);
    }

    private NoArv pesquisarReserva(NoArv no, Reserva reserva) {
        if (no == null) {
            return null;
        }
        if (no.getReserva().getCodReserva().equals(reserva.getCodReserva())) {
            return no;
        }
        if (no.getReserva().getCodReserva().compareTo(reserva.getCodReserva()) > 0) {
            return pesquisarReserva(no.getDir(), reserva);
        }
        return pesquisarReserva(no.getEsq(), reserva);
    }

    // Pesquisa pelo nome da reserva
    public NoArv pesquisarNome(Reserva reserva) {
        return pesquisarNome(raiz, reserva);
    }

    private NoArv pesquisarNome(NoArv no, Reserva reserva) {
        if (no == null) {
            return null;
        }
        if (no.getReserva().getNome().equals(reserva.getNome())) {
            return no;
        }
        if (no.getReserva().getCodReserva().compareTo(reserva.getCodReserva()) > 0) {// navega usando como base a
                                                                                     // reserva pois a arvore é ordenada
                                                                                     // pela mesma
            return pesquisarNome(no.getDir(), reserva);
        }
        return pesquisarNome(no.getEsq(), reserva);
    }

    public boolean inserir(Reserva reserva) {
        if (this.pesquisarReserva(reserva) != null) {
            return false;
        }
        this.raiz = inserir(this.raiz, reserva);
        this.quantidade++;
        return true;

    }

    private NoArv inserir(NoArv no, Reserva reserva) {
        if (no == null) {
            NoArv novo = new NoArv(reserva);
            return novo;
        }
        if (reserva.getCodReserva().compareTo(no.getReserva().getCodReserva()) > 0){
            no.setDir(inserir(no.getDir(), reserva));
        }else if(reserva.getCodReserva().compareTo(no.getReserva().getCodReserva()) < 0){
            no.setEsq(inserir(no.getEsq(), reserva));
        }
        return no;
    }

    public ArrayList<Reserva> camninhoCentral(){
        ArrayList<Reserva> vetor = new ArrayList<Reserva>(this.quantidade);
        return fazCamCentral(this.raiz, vetor);
    }


    private ArrayList<Reserva> fazCamCentral(NoArv no, ArrayList<Reserva> vetor){
        if(no != null){
            vetor = this.fazCamCentral(no.getDir(), vetor);
            vetor.add(no.getReserva());
            vetor = this.fazCamCentral(no.getEsq(), vetor);
        }
        return vetor;
    }

    public ABB balancear(){
        ABB AbbBalanceada = new ABB();
        ArrayList<Reserva> vetor = camninhoCentral();
        balancearAbb(vetor, AbbBalanceada, 0, quantidade-1);
        
        return AbbBalanceada;
    }

    private void balancearAbb(ArrayList<Reserva> vetor, ABB arvAbb ,int inicio, int fim){
        int meio;
        if(inicio <= fim){
            meio = (fim + inicio)/2;
            arvAbb.inserir(vetor.get(meio));
            balancearAbb(vetor, arvAbb, inicio, meio -1);
            balancearAbb(vetor, arvAbb, meio + 1, fim);
        }
    }
}
