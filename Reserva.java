public class Reserva {
    private String nome;
    private int reserva;
    private int codVoo;
    private String data;

    public Reserva(String nome, int reserva, int codVoo, String data, int assento) {
        this.nome = nome;
        this.reserva = reserva;
        this.codVoo = codVoo;
        this.data = data;
        this.assento = assento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getReserva() {
        return reserva;
    }
    public void setReserva(int reserva) {
        this.reserva = reserva;
    }
    public int getCodVoo() {
        return codVoo;
    }
    public void setCodVoo(int codVoo) {
        this.codVoo = codVoo;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getAssento() {
        return assento;
    }
    public void setAssento(int assento) {
        this.assento = assento;
    }
    private int assento;
}
