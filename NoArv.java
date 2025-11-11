public class NoArv {
    private Reserva reserva;
    private NoArv proximo;

    public NoArv getProximo() {
        return proximo;
    }

    public void setProximo(NoArv proximo) {
        this.proximo = proximo;
    }

    public NoArv(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
