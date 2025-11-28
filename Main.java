import java.util.ArrayList;
import java.util.LinkedList;

import ABB.ABB;
import Hashing.Hashing;
import Heap.Heap;
import QuickSort.QuickSort;
import QuickSortInsercao.QuickSortInsercao;
import ReservaType.Reserva;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {

        //para rodar o codigo insira a linha de baixo no launch.json da sua IDE
        //"vmArgs": "-Xmx2048m"
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
        ArrayList<String> nomes = readNames();

        // -------------Questão 1---------------------
        realizarQuestao1(lista1kAlea, "ReservasOrganizadas/HEAP/HEAP1000alea.txt");
        realizarQuestao1(lista1kOrd, "ReservasOrganizadas/HEAP/HEAP1000ord.txt");
        realizarQuestao1(lista1kInv, "ReservasOrganizadas/HEAP/HEAP1000inv.txt");

        realizarQuestao1(lista5kAlea, "ReservasOrganizadas/HEAP/HEAP5000alea.txt");
        realizarQuestao1(lista5kOrd, "ReservasOrganizadas/HEAP/HEAP5000ord.txt");
        realizarQuestao1(lista5kInv, "ReservasOrganizadas/HEAP/HEAP5000inv.txt");

        realizarQuestao1(lista10kAlea, "ReservasOrganizadas/HEAP/HEAP10000alea.txt");
        realizarQuestao1(lista10kOrd, "ReservasOrganizadas/HEAP/HEAP10000ord.txt");
        realizarQuestao1(lista10kInv, "ReservasOrganizadas/HEAP/HEAP10000inv.txt");

        realizarQuestao1(lista50kAlea, "ReservasOrganizadas/HEAP/HEAP50000alea.txt");
        realizarQuestao1(lista50kOrd, "ReservasOrganizadas/HEAP/HEAP50000ord.txt");
        realizarQuestao1(lista50kInv, "ReservasOrganizadas/HEAP/HEAP50000inv.txt");

        // -------------Questão 2---------------------
        realizarQuestao2(lista1kAlea, "ReservasOrganizadas/QuickSort/QuickSort1000alea.txt");
        realizarQuestao2(lista1kOrd, "ReservasOrganizadas/QuickSort/QuickSort1000ord.txt");
        realizarQuestao2(lista1kInv, "ReservasOrganizadas/QuickSort/QuickSort1000inv.txt");

        realizarQuestao2(lista5kAlea, "ReservasOrganizadas/QuickSort/QuickSort5000alea.txt");
        realizarQuestao2(lista5kOrd, "ReservasOrganizadas/QuickSort/QuickSort5000ord.txt");
        realizarQuestao2(lista5kInv, "ReservasOrganizadas/QuickSort/QuickSort5000inv.txt");

        realizarQuestao2(lista10kAlea,"ReservasOrganizadas/QuickSort/QuickSort10000alea.txt");
        realizarQuestao2(lista10kOrd,"ReservasOrganizadas/QuickSort/QuickSort10000ord.txt");
        realizarQuestao2(lista10kInv,"ReservasOrganizadas/QuickSort/QuickSort10000inv.txt");

        realizarQuestao2(lista50kAlea,"ReservasOrganizadas/QuickSort/QuickSort50000alea.txt");
        realizarQuestao2(lista50kOrd,"ReservasOrganizadas/QuickSort/QuickSort50000ord.txt");
        realizarQuestao2(lista50kInv,"ReservasOrganizadas/QuickSort/QuickSort50000inv.txt");

        // -------------Questão 3---------------------
        realizarQuestao2(lista1kAlea, "ReservasOrganizadas/QuickSortInsercao/QuickSort1000alea.txt");
        realizarQuestao2(lista1kOrd, "ReservasOrganizadas/QuickSortInsercao/QuickSort1000ord.txt");
        realizarQuestao2(lista1kInv, "ReservasOrganizadas/QuickSortInsercao/QuickSort1000inv.txt");

        realizarQuestao2(lista5kAlea, "ReservasOrganizadas/QuickSortInsercao/QuickSort5000alea.txt");
        realizarQuestao2(lista5kOrd, "ReservasOrganizadas/QuickSortInsercao/QuickSort5000ord.txt");
        realizarQuestao2(lista5kInv, "ReservasOrganizadas/QuickSortInsercao/QuickSort5000inv.txt");

        realizarQuestao3(lista10kAlea,"ReservasOrganizadas/QuickSortInsercao/QuickSort10000alea.txt");
        realizarQuestao3(lista10kOrd,"ReservasOrganizadas/QuickSortInsercao/QuickSort10000ord.txt");
        realizarQuestao3(lista10kInv,"ReservasOrganizadas/QuickSortInsercao/QuickSort10000inv.txt");

        realizarQuestao3(lista50kAlea,"ReservasOrganizadas/QuickSortInsercao/QuickSort50000alea.txt");
        realizarQuestao3(lista50kOrd,"ReservasOrganizadas/QuickSortInsercao/QuickSort50000ord.txt");
        realizarQuestao3(lista50kInv,"ReservasOrganizadas/QuickSortInsercao/QuickSort50000inv.txt");

        // -------------Questão 4---------------------
        realizarQuestao4(lista1kAlea, "ReservasOrganizadas/ABB/ABB1000alea.txt", nomes);
        realizarQuestao4(lista1kOrd, "ReservasOrganizadas/ABB/ABB1000ord.txt", nomes);
        realizarQuestao4(lista1kInv, "ReservasOrganizadas/ABB/ABB1000inv.txt", nomes);

        realizarQuestao4(lista5kAlea, "ReservasOrganizadas/ABB/ABB5000alea.txt", nomes);
        realizarQuestao4(lista5kOrd, "ReservasOrganizadas/ABB/ABB5000ord.txt", nomes);
        realizarQuestao4(lista5kInv, "ReservasOrganizadas/ABB/ABB5000inv.txt", nomes);

        realizarQuestao4(lista10kAlea, "ReservasOrganizadas/ABB/ABB10000alea.txt",nomes);
        realizarQuestao4(lista10kOrd, "ReservasOrganizadas/ABB/ABB10000ord.txt",nomes);
        realizarQuestao4(lista10kInv, "ReservasOrganizadas/ABB/ABB10000inv.txt",nomes);

        realizarQuestao4(lista50kAlea, "ReservasOrganizadas/ABB/ABB50000alea.txt",nomes);
        realizarQuestao4(lista50kOrd, "ReservasOrganizadas/ABB/ABB50000ord.txt",nomes);
        realizarQuestao4(lista50kInv, "ReservasOrganizadas/ABB/ABB50000inv.txt",nomes);

        // -------------Questão 5---------------------
        realizarQuestao5(lista1kAlea, "ReservasOrganizadas/AVL/AVL1000alea.txt", nomes);
        realizarQuestao5(lista1kOrd, "ReservasOrganizadas/AVL/AVL1000ord.txt", nomes);
        realizarQuestao5(lista1kInv, "ReservasOrganizadas/AVL/AVL1000inv.txt", nomes);

        realizarQuestao5(lista5kAlea, "ReservasOrganizadas/AVL/AVL5000alea.txt", nomes);
        realizarQuestao5(lista5kOrd, "ReservasOrganizadas/AVL/AVL5000ord.txt", nomes);
        realizarQuestao5(lista5kInv, "ReservasOrganizadas/AVL/AVL5000inv.txt", nomes);

        realizarQuestao5(lista10kAlea, "ReservasOrganizadas/AVL/AVL10000alea.txt",nomes);
        realizarQuestao5(lista10kOrd, "ReservasOrganizadas/AVL/AVL10000ord.txt",nomes);
        realizarQuestao5(lista10kInv, "ReservasOrganizadas/AVL/AVL10000inv.txt",nomes);

        realizarQuestao5(lista50kAlea, "ReservasOrganizadas/AVL/AVL50000alea.txt",nomes);
        realizarQuestao5(lista50kOrd, "ReservasOrganizadas/AVL/AVL50000ord.txt",nomes);
        realizarQuestao5(lista50kInv, "ReservasOrganizadas/AVL/AVL50000inv.txt",nomes);

        // -------------Questão 6---------------------
        realizarQuestao6(lista1kAlea, "ReservasOrganizadas/Hashing/Hashing1000alea.txt", nomes);
        realizarQuestao6(lista1kOrd, "ReservasOrganizadas/Hashing/Hashing1000ord.txt", nomes);
        realizarQuestao6(lista1kInv, "ReservasOrganizadas/Hashing/Hashing1000inv.txt", nomes);

        realizarQuestao6(lista5kAlea, "ReservasOrganizadas/Hashing/Hashing5000alea.txt", nomes);
        realizarQuestao6(lista5kOrd, "ReservasOrganizadas/Hashing/Hashing5000ord.txt", nomes);
        realizarQuestao6(lista5kInv, "ReservasOrganizadas/Hashing/Hashing5000inv.txt", nomes);

        realizarQuestao6(lista10kAlea, "ReservasOrganizadas/Hashing/Hashing10000alea.txt", nomes);
        realizarQuestao6(lista10kOrd, "ReservasOrganizadas/Hashing/Hashing10000ord.txt", nomes);
        realizarQuestao6(lista10kInv, "ReservasOrganizadas/Hashing/Hashing10000inv.txt", nomes);

        realizarQuestao6(lista50kAlea, "ReservasOrganizadas/Hashing/Hashing50000alea.txt", nomes);
        realizarQuestao6(lista50kOrd, "ReservasOrganizadas/Hashing/Hashing50000ord.txt", nomes);
        realizarQuestao6(lista50kInv, "ReservasOrganizadas/Hashing/Hashing50000inv.txt", nomes);
    }

    // -------------------------Metodos de lidar com os arquivos:---------------------------------

    // função para ler o arquivo e retornar uma lista de Reserva recebe como parametro o caminho do arquivo
    public static ArrayList<Reserva> readAllReservas(String arquivoOrigem) {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        Path path = Paths.get(arquivoOrigem);
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
        } catch (IOException e) {// colocando para o java não reclamar
            System.out.println("Erro ao ler o arquivo: " + file);
        }
        return list;
    }

    // função para ler os nomes do arquivo nome.txt e criar uma arraylist com os mesmos
    public static ArrayList<String> readNames() {
        ArrayList<String> list = new ArrayList<String>();
        Path path = Paths.get("reservas/nome.txt");
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line.trim());
            }
        } catch (IOException e) {// colocando para o java não reclamar
            System.out.println("Erro ao ler o arquivo: " + path);
        }

        return list;
    }

    // função para escreve lista de reservas o arquivo para as questões de pesquisa
    public static void writeSearchResultToFile(String arquivoDestino, ArrayList<Reserva> reservas, String nome)
            throws IOException {

        Path path = Paths.get(arquivoDestino);
        ArrayList<String> lines = new ArrayList<>();
        lines.add("\n---------------------------");

        if (reservas == null || reservas.isEmpty()) {// caso o cliente não tenha reservas escreve no arquivo que não
                                                     // encontrou
            if (nome != null) {
                lines.add("Nome: " + nome);
                lines.add("Não tem reserva");
            }
        } else {
            lines.add("NOME: " + reservas.get(0).getNome());

            for (Reserva r : reservas) {
                lines.add("Reserva: " + r.getCodReserva() + " Voo: " + r.getCodVoo() + " Data: " + r.getData()
                        + " Assento: " + r.getAssento());
            }
            lines.add("Total: " + reservas.size() + " reserva(s) adicionada(s)");
        }
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    // variacao da função acima adaptada para as questoes de ordenaçao
    public static void writeSortResultToFile(String arquivoDestino, ArrayList<Reserva> reservas) throws IOException {
        Path path = Paths.get(arquivoDestino);
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("\n---------------------------");

        for (Reserva reserva : reservas) {
            lines.add("Nome: " + reserva.getNome() + " Reserva: " + reserva.getCodReserva() + " Voo: "
                    + reserva.getCodVoo() + " Data: " + reserva.getData() + " Assento: " + reserva.getAssento());
        }
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    
    //limpa o arquivo antes de cada nova escrita
    public static void cleanFile(String arquivoDestino) {
        Path path = Paths.get(arquivoDestino);
        try {
            Files.write(path, new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {// colocando para o java não reclamar

        }
    }

    public static void writeOperationTimer(long tempoExecucao, String arquivoDestino) {
        Path path = Paths.get(arquivoDestino);
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("\n");
        lines.add("\n-------------------Tempo Execução------------------");
        lines.add("Tempo total de execução (ms): " + tempoExecucao/5);
        try {
            Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {// colocando para o java não reclamar

        }
    }

    // -------------------Questão 1-----------------------
    public static void realizarQuestao1(ArrayList<Reserva> data, String arquivoDestino) {
        Heap sorter = new Heap(data);
        long initialTime = System.currentTimeMillis(), finalTime;

        for (int i = 0; i < 5; i++) {
            principalQuestao1(sorter, arquivoDestino);
            if (i != 4) {
                cleanFile(arquivoDestino);
            }
        }
        finalTime = System.currentTimeMillis();
        long totalTime = finalTime - initialTime;
        writeOperationTimer(totalTime, arquivoDestino);
    }

    public static void principalQuestao1(Heap sorter, String arquivoDestino) {
        try {
            writeSortResultToFile(arquivoDestino, sorter.ordenar());
        } catch (IOException e) {

        }
    }

    // -------------------Questão 2-----------------------
    public static void realizarQuestao2(ArrayList<Reserva> data, String arquivoDestino) {
        QuickSort sorter = new QuickSort(data);
        long initialTime = System.currentTimeMillis(), finalTime;

        for (int i = 0; i < 5; i++) {
            principalQuestao2(sorter, arquivoDestino);
            if (i != 4) {
                cleanFile(arquivoDestino);
            }
        }

        finalTime = System.currentTimeMillis();
        long totalTime = finalTime - initialTime;
        writeOperationTimer(totalTime, arquivoDestino);
    }

    public static void principalQuestao2(QuickSort sorter, String arquivoDestino) {
        try {
            writeSortResultToFile(arquivoDestino, sorter.ordena());
        } catch (IOException e) {

        }
    }

    // -------------------Questão 3-----------------------
    public static void realizarQuestao3(ArrayList<Reserva> data, String arquivoDestino) {
        long initialTime = System.currentTimeMillis(), finalTime;
        for (int i = 0; i < 5; i++) {
            principalQuestao3(data, arquivoDestino);
            if (i != 4) {
                cleanFile(arquivoDestino);
            }
        }
        finalTime = System.currentTimeMillis();
        long totalTime = finalTime - initialTime;
        writeOperationTimer(totalTime, arquivoDestino);
    }

    public static void principalQuestao3(ArrayList<Reserva> data, String arquivoDestino) {
        QuickSortInsercao sorter = new QuickSortInsercao(data);
        sorter.ordena();
        try {
            writeSortResultToFile(arquivoDestino, sorter.getLista());
        } catch (IOException e) {

        }
    }

    // -------------------Questão 4-----------------------
    public static void realizarQuestao4(ArrayList<Reserva> data, String arquivoDestino, ArrayList<String> nomesPesquisa) {
        ABB arvoreAbb = montaABB(data);
        long initialTime = System.currentTimeMillis(), finalTime;
        for (int i = 0; i < 5; i++) {
            principalQuestao4(arquivoDestino, nomesPesquisa, arvoreAbb);
            if (i != 4) {// caso queira testar
                cleanFile(arquivoDestino);
            }
        }
        finalTime = System.currentTimeMillis();
        long totalTime = finalTime - initialTime;
        writeOperationTimer(totalTime, arquivoDestino);
    }

    public static void principalQuestao4(String arquivoDestino, ArrayList<String> nomesPesquisa, ABB arvoreAbb) {

        for (String cliente : nomesPesquisa) {
            ArrayList<Reserva> reservasCliente = new ArrayList<>();
            reservasCliente = arvoreAbb.pesquisarNome(cliente);// pesquisa na abb pelo nome de cada cliente

            try {
                if (reservasCliente.size() > 0) {
                    writeSearchResultToFile(arquivoDestino, reservasCliente, null);
                } else {
                    writeSearchResultToFile(arquivoDestino, null, cliente);
                }
            } catch (IOException e) {

            }
        }
    }

    public static ABB montaABB(ArrayList<Reserva> reservas) {
        ABB arvore = new ABB();

        for (Reserva reserva : reservas) {
            arvore.inserir(reserva);
        }

        arvore.balancear();
        return arvore;
    }

    // ----------------------Questão 5-----------------------------
    public static void realizarQuestao5(ArrayList<Reserva> data, String arquivoDestino, ArrayList<String> nomesPesquisa) {
        AVL arvoreAVL = montaAVL(data);
        long initialTime = System.currentTimeMillis(), finalTime;
        for (int i = 0; i < 5; i++) {
            principalQuestao5(arquivoDestino, nomesPesquisa, arvoreAVL);
            if (i != 4) {
                cleanFile(arquivoDestino);
            }
        }
        finalTime = System.currentTimeMillis();
        long totalTime = finalTime - initialTime;
        writeOperationTimer(totalTime, arquivoDestino);
    }

    // metodo pricipal da questao 5
    public static void principalQuestao5(String arquivoDestino, ArrayList<String> nomesPesquisa, AVL arvoreAVL) {
        ArrayList<Reserva> reservasCliente;

        for (String cliente : nomesPesquisa) {
            reservasCliente = new ArrayList<>();
            reservasCliente = arvoreAVL.pesquisarNome(cliente);
            try {
                if (reservasCliente.size() > 0) {// se encontrou reservas para o cliente escreve diretamente no arquivo
                    writeSearchResultToFile(arquivoDestino, reservasCliente, null);
                } else {// caso o cliente não tenha reservas escreve no arquivo que não encontrou
                    writeSearchResultToFile(arquivoDestino, null, cliente);
                }
            } catch (IOException e) {

            }
        }
    }

    public static AVL montaAVL(ArrayList<Reserva> reservas) {
        AVL arvore = new AVL();

        for (Reserva reserva : reservas) {
            arvore.inserir(reserva);
        }

        return arvore;
    }

    // ----------------------Questão 6-----------------------------
    public static void realizarQuestao6(ArrayList<Reserva> data, String arquivoDestino, ArrayList<String> nomesPesquisa) {
        Hashing hash = montaHashing(data);
        long initialTime = System.currentTimeMillis(), finalTime;

        for (int i = 0; i < 5; i++) {
            principalQuestao6(arquivoDestino, nomesPesquisa, hash);
            if (i != 4) {
                cleanFile(arquivoDestino);
            }
        }
        finalTime = System.currentTimeMillis();
        long totalTime = finalTime - initialTime;
        writeOperationTimer(totalTime, arquivoDestino);
    }

    // metodo pricipal da questao 6
    public static void principalQuestao6(String arquivoDestino, ArrayList<String> nomesPesquisa, Hashing hash) {
        ArrayList<Reserva> reservasCliente;
        for (String cliente : nomesPesquisa) {
            reservasCliente = parseToArrayList(hash.searchByName(cliente));
            
            try {
                if (reservasCliente.size() > 0) {// se encontrou reservas para o cliente escreve diretamente no arquivo
                    writeSearchResultToFile(arquivoDestino, reservasCliente, null);
                } else {// caso o cliente não tenha reservas escreve no arquivo que não encontrou
                    writeSearchResultToFile(arquivoDestino, null, cliente);
                }
            } catch (IOException e) {

            }
        }
    }

    public static ArrayList<Reserva> parseToArrayList(LinkedList<Reserva> list) {
       ArrayList<Reserva> arrayList = new ArrayList<>();

        if(list != null){
            for(Reserva r: list){
                arrayList.add(r);
            }
        }
        
        return arrayList;
    }

    public static Hashing montaHashing(ArrayList<Reserva> reservas) {
        Hashing hash = new Hashing(reservas.size());

        for (Reserva reserva : reservas) {
            hash.inserir(reserva);
        }

        return hash;
    }
}