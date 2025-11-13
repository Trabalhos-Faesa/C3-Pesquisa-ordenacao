public class Reserva {
    private String nome;
    private String reserva;
    private String codVoo;
    private String data;
    private String assento;


    public Reserva(String nome, String reserva, String codVoo, String data, String assento) {
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
    public String getReserva() {
        return reserva;
    }
    public void setReserva(String reserva) {
        this.reserva = reserva;
    }
    public String getCodVoo() {
        return codVoo;
    }
    public void setCodVoo(String codVoo) {
        this.codVoo = codVoo;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getAssento() {
        return assento;
    }
    public void setAssento(String assento) {
        this.assento = assento;
    }
}
