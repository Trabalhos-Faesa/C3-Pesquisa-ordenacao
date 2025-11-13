import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reserva> lista1kAlea = readAllReservas("reservas/Reserva1000alea.txt");
        ArrayList<Reserva> lista1kOrd = readAllReservas("reservas/Reserva1000ord.txt");
        ArrayList<Reserva> lista1kInv = readAllReservas("reservas/Reserva1000inv.txt");

        ArrayList<Reserva> lista5kInv = readAllReservas("reservas/Reserva5000inv.txt");
        ArrayList<Reserva> lista5kAlea = readAllReservas("reservas/Reserva5000alea.txt");
        ArrayList<Reserva> lista5kOrd = readAllReservas("reservas/Reserva5000ord.txt");

        ArrayList<Reserva> lista10kInv = readAllReservas("reservas/Reserva10000inv.txt");
        ArrayList<Reserva> lista10kAlea = readAllReservas("reservas/Reserva10000alea.txt");
        ArrayList<Reserva> lista10kOrd = readAllReservas("reservas/Reserva10000ord.txt");

        ArrayList<Reserva> lista50kInv = readAllReservas("reservas/Reserva50000inv.txt");
        ArrayList<Reserva> lista50kAlea = readAllReservas("reservas/Reserva50000alea.txt");
        ArrayList<Reserva> lista50kOrd = readAllReservas("reservas/Reserva50000ord.txt");

        montaABB(lista1kAlea);

    }

    // função para ler o arquivo e retornar uma lista de Reserva recebe como
    // parametro o caminho do arquivo
    public static ArrayList<Reserva> readAllReservas(String filePath) {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        Path path = Paths.get(filePath);
        reservas.addAll(readFromFile(path));
        return reservas;
    }

    // função que lê o arquivo e cria uma lista de Reserva n
    public static ArrayList<Reserva> readFromFile(Path file) {
        ArrayList<Reserva> list = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String reservaCode = parts[0];
                String nome = parts[1];
                String vooCode = parts[2];
                String data = parts[3];
                String assento = parts[4];
                list.add(new Reserva(nome, reservaCode, vooCode, data, assento));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + file);
        }
        return list;
    }

    // função para escrever a lista de reservas em um arquivo recebe como parametros
    // o caminho do arquivo e a lista de reservas ordenada
    public static void writeReservasToFile(String filePath, ArrayList<Reserva> reservas) throws IOException {
        Path path = Paths.get(filePath);
        ArrayList<String> lines = new ArrayList<>();
        for (Reserva r : reservas) {
            lines.add(r.getCodReserva() + ";" + r.getNome() + ";" + r.getCodVoo() + ";" + r.getData() + ";"
                    + r.getAssento());
        }
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
    }

    // função para exibir as reservas encontradas em algoritimos de pesquisa
    public static void exibirListaReservas(ArrayList<Reserva> reservas, String nomePesquisado) {
        if (reservas.size() == 0) {
            exibirReservaAusente(nomePesquisado);
            return;
        }
        for (Reserva reserva : reservas) {
            exibirReserva(reserva);
        }
        System.out.println("Total de reservas: " + reservas.size());
    }

    public static void exibirReserva(Reserva reserva) {
        System.out.println("Nome: " + reserva.getNome());
        System.out.println("Reserva: " + reserva.getCodReserva() + " Voo: " + reserva.getCodVoo() + " Data: "
                + reserva.getData() + " Assento: " + reserva.getAssento());
    }

    public static void exibirReservaAusente(String nome) {
        System.out.println("Nome: " + nome);
        System.out.println("Não tem reserva");
    }

    public static ABB montaABB(ArrayList<Reserva> reservas) {
        ABB arvore = new ABB();

        for (Reserva reserva : reservas) {
            arvore.inserir(reserva);
        }

        arvore.balancear();
        return arvore;
    }

}