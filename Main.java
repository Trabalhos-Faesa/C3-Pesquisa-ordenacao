import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reserva> listaAlea = readAllReservas("reservas/Reserva1000alea.txt");
        ArrayList<Reserva> listaOrd = readAllReservas("reservas/Reserva1000ord.txt");
        ArrayList<Reserva> listaInv = readAllReservas("reservas/Reserva1000inv.txt");
    }


    public static ArrayList<Reserva> readAllReservas(String filePath) {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        Path path = Paths.get(filePath);
        try{
            reservas.addAll(readFromFile(path));
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo: " + path);
        }
        return reservas;
    }

    public static ArrayList<Reserva> readFromFile(Path file) throws IOException {
        ArrayList<Reserva> list = new ArrayList<>();
        String line;
        BufferedReader conteudo = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            while ((line = conteudo.readLine()) != null) {
                String[] parts = line.split(";");

                String reservaCode = parts[0];
                String nome = parts[1];
                String vooCode = parts[2];
                String data = parts[3];
                String assento = parts[4];

                list.add(new Reserva(nome, reservaCode, vooCode, data, assento));
        }
        return list;
    }

    public static void exibirListaReservas(ArrayList<Reserva> reservas, String nomePesquisado){
        if(reservas.size() == 0){
            exibirReservaAusente(nomePesquisado);
            return;
        }
        for(Reserva reserva : reservas){
            exibirReserva(reserva);
        }
        System.out.println("Total de reservas: " + reservas.size());
    }

    public static void exibirReserva(Reserva reserva){
        System.out.println("Nome: " + reserva.getNome());
        System.out.println("Reserva: " + reserva.getReserva() + " Voo: " + reserva.getCodVoo() +" Data: " + reserva.getData() + " Assento: " + reserva.getAssento());
    }

    public static void exibirReservaAusente(String nome){
        System.out.println("Nome: " + nome);
        System.out.println("Não tem reserva");
    }
}