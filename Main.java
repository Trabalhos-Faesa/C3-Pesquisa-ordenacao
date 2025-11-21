import java.util.ArrayList;

import ABB.ABB;
import QuickSort.QuickSort;
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

        //-------------Questão 2---------------------
        realizarQuestao2(lista1kAlea, "ReservasOrganizadas/QuickSort/QuickSort1000alea.txt");
        realizarQuestao2(lista1kOrd, "ReservasOrganizadas/QuickSort/QuickSort1000ord.txt");
        realizarQuestao2(lista1kInv, "ReservasOrganizadas/QuickSort/QuickSort1000inv.txt");
        
        realizarQuestao2(lista5kAlea, "ReservasOrganizadas/QuickSort/QuickSort5000alea.txt");
        realizarQuestao2(lista5kOrd, "ReservasOrganizadas/QuickSort/QuickSort5000ord.txt");
        realizarQuestao2(lista5kInv, "ReservasOrganizadas/QuickSort/QuickSort5000inv.txt");

        //-------------Questão 4---------------------
        realizarQuestao4(lista1kAlea, "ReservasOrganizadas/ABB/ABB1000alea.txt", nomes);
        realizarQuestao4(lista1kOrd, "ReservasOrganizadas/ABB/ABB1000ord.txt", nomes);
        realizarQuestao4(lista1kInv, "ReservasOrganizadas/ABB/ABB1000inv.txt", nomes);
        
        realizarQuestao4(lista5kAlea, "ReservasOrganizadas/ABB/ABB5000alea.txt", nomes);
        realizarQuestao4(lista5kOrd, "ReservasOrganizadas/ABB/ABB5000ord.txt", nomes);
        realizarQuestao4(lista5kInv, "ReservasOrganizadas/ABB/ABB5000inv.txt", nomes);
        {/*TODO descomentar */}

        //realizarQuestao4(lista10kAlea, "ReservasOrganizadas/ABB/ABB10000alea.txt", nomes);
        //realizarQuestao4(lista10kOrd, "ReservasOrganizadas/ABB/ABB10000ord.txt", nomes);
        //realizarQuestao4(lista10kInv, "ReservasOrganizadas/ABB/ABB10000inv.txt", nomes);
        
        //realizarQuestao4(lista50kAlea, "ReservasOrganizadas/ABB/ABB50000alea.txt", nomes);
        //realizarQuestao4(lista50kOrd, "ReservasOrganizadas/ABB/ABB50000ord.txt", nomes);
        //realizarQuestao4(lista50kInv, "ReservasOrganizadas/ABB/ABB50000inv.txt", nomes);
        
        //-------------Questão 5---------------------
        realizarQuestao4(lista1kAlea, "ReservasOrganizadas/AVL/AVL1000alea.txt", nomes);
        realizarQuestao4(lista1kOrd, "ReservasOrganizadas/AVL/AVL1000ord.txt", nomes);
        realizarQuestao4(lista1kInv, "ReservasOrganizadas/AVL/AVL1000inv.txt", nomes);
        
        realizarQuestao4(lista5kAlea, "ReservasOrganizadas/AVL/AVL5000alea.txt", nomes);
        realizarQuestao4(lista5kOrd, "ReservasOrganizadas/AVL/AVL5000ord.txt", nomes);
        realizarQuestao4(lista5kInv, "ReservasOrganizadas/AVL/AVL5000inv.txt", nomes);
        
        //realizarQuestao4(lista10kAlea, "ReservasOrganizadas/AVL/AVL10000alea.txt", nomes);
        //realizarQuestao4(lista10kOrd, "ReservasOrganizadas/AVL/AVL10000ord.txt", nomes);
        //realizarQuestao4(lista10kInv, "ReservasOrganizadas/AVL/AVL10000inv.txt", nomes);

        //realizarQuestao4(lista50kAlea, "ReservasOrganizadas/AVL/AVL50000alea.txt", nomes);
        //realizarQuestao4(lista50kOrd, "ReservasOrganizadas/AVL/AVL50000ord.txt", nomes);
        //realizarQuestao4(lista50kInv, "ReservasOrganizadas/AVL/AVL50000inv.txt", nomes);
        
    }

    //-------------------------Metodos de lidar com os arquivos:---------------------------------

    // função para ler o arquivo e retornar uma lista de Reserva recebe como
    // parametro o caminho do arquivo
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
        } catch (IOException e) {//colocando para o java não reclamar
            System.out.println("Erro ao ler o arquivo: " + file);
        }
        return list;
    }
    // função para ler os nomes do arquivo nome.txt e criar uma arraylist com os mesmos
    public static ArrayList<String> readNames(){
        ArrayList<String> list = new ArrayList<String>();
        Path path = Paths.get("reservas/nome.txt");
        try{
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line.trim());
            }
        } catch (IOException e) {//colocando para o java não reclamar
            System.out.println("Erro ao ler o arquivo: " + path);
        }

        return list;
    }

    // função para escreve o arquivo, conforme padronizado na descrição do trabalho
   public static void writeReservasToFile(String arquivoDestino, ArrayList<Reserva> reservas, String nome) throws IOException {
       
       Path path = Paths.get(arquivoDestino);
       ArrayList<String> lines = new ArrayList<>();
       lines.add("\n---------------------------");
    
        if(reservas == null || reservas.isEmpty()){
            if(nome != null){//caso o cliente não tenha reservas escreve no arquivo que não encontrou
                lines.add("Nome: " + nome);
                lines.add("Não tem reserva");

                Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND); 
            }

            return;
            
        }else{
            lines.add("NOME: " + reservas.get(0).getNome());
    
            for (Reserva r : reservas) {
                lines.add("Reserva: " + r.getCodReserva() + " Voo: " + r.getCodVoo() + " Data: " + r.getData() + " Assento: " + r.getAssento());
            }
            lines.add("Total: " + reservas.size() + " reserva(s) adicionada(s)");
    
            Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }

    //cuidado para não passar o path de um arquivo na pasta /reservas
    public static void cleanFile(String arquivoDestino){
        Path path = Paths.get(arquivoDestino);
        try{
            Files.write(path, new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }catch(IOException e){//colocando para o java não reclamar

        }
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

    //-------------------Questão 2-----------------------
    public static void realizarQuestao2(ArrayList<Reserva> data, String caminhoDestino){
        for(int i = 0; i < 5; i++){
            principalQuestao2(data, caminhoDestino);
            if(i != 4){//caso queira testar 
                cleanFile(caminhoDestino);
            }
        }
    }

    public static void principalQuestao2(ArrayList<Reserva> data, String caminhoDestino){
        QuickSort sorter = new QuickSort(data);
        sorter.ordena();
        try{
            writeReservasToFile(caminhoDestino, sorter.getLista(), null);
        }catch(IOException e){

        }
    }

    //-------------------Questão 4-----------------------
    public static void realizarQuestao4(ArrayList<Reserva> data, String caminhoDestino, ArrayList<String> nomesPesquisa){
        ABB arvoreAbb = montaABB(data);

        for(int i = 0; i < 5; i++){
            principalQuestao4(caminhoDestino, nomesPesquisa, arvoreAbb);
            if(i != 4){//caso queira testar 
                cleanFile(caminhoDestino);
            }
        }
    }

    public static void principalQuestao4(String caminhoDestino, ArrayList<String> nomesPesquisa, ABB arvoreAbb){

        for(String cliente: nomesPesquisa){
            ArrayList<Reserva> reservasCliente = new ArrayList<>();
            reservasCliente = arvoreAbb.pesquisarNome(cliente);//pesquisa na abb pelo nome de cada cliente

            try{
                if(reservasCliente.size() > 0){
                    writeReservasToFile(caminhoDestino, reservasCliente, null);
                }else{
                    writeReservasToFile(caminhoDestino, null, cliente);
                }
            }catch(IOException e){
                
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

    //----------------------Questão 5-----------------------------
    public static void realizarQuestao5(ArrayList<Reserva> data, String caminhoDestino, ArrayList<String> nomesPesquisa){
        AVL arvoreAVL = montaAVL(data);

        for(int i = 0; i < 5; i++){
            principalQuestao5( caminhoDestino, nomesPesquisa, arvoreAVL);
            if(i != 4){//caso queira testar com um menor numero de repetições lembrar de mudar aqui também
                cleanFile(caminhoDestino);
            }
        }
    }

    //metodo pricipal da questao 5
    public static void principalQuestao5(String arquivoDestino, ArrayList<String> nomesPesquisa, AVL arvoreAVL){
        for(String cliente: nomesPesquisa){
            ArrayList<Reserva> reservasCliente = new ArrayList<>();
            reservasCliente = arvoreAVL.pesquisarNome(cliente);
            try{
                if(reservasCliente.size() > 0){//se encontrou reservas para o cliente escreve diretamente no arquivo
                    writeReservasToFile(arquivoDestino, reservasCliente, null);
                }else{//caso o cliente não tenha reservas escreve no arquivo que não encontrou
                    writeReservasToFile(arquivoDestino, null, cliente);
                }
            }catch(IOException e){

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
}