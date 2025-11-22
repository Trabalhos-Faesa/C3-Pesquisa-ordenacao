package ABB;

import ReservaType.Reserva;

public class NoArv {
    private Reserva reserva;
    private NoArv esq;
    private NoArv dir;

    public NoArv getDir() {
        return dir;
    }

    public void setDir(NoArv dir) {
        this.dir = dir;
    }

    public NoArv getEsq() {
        return esq;
    }

    public void setEsq(NoArv proximo) {
        this.esq = proximo;
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