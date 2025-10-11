import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Reserva> reservas = new LinkedList<>();
        //TODO remover essa parte
        //elementos para testar o funcionamento dos algoritimos
        reservas.add(new Reserva("John Doe", 1, 101, "2023-10-01", 12));
        reservas.add(new Reserva("Jane Smith", 2, 102, "2023-10-02", 15));
        reservas.add(new Reserva("Alice Johnson", 3, 103, "2023-10-03", 20));
        reservas.add(new Reserva("Bob Brown", 4, 104, "2023-10-04", 25));
        reservas.add(new Reserva("Charlie Davis", 5, 105, "2023-10-05", 30));
        reservas.add(new Reserva("Diana Evans", 6, 106, "2023-10-06", 35));

    }
}