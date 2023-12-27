package com.mycompany.pooject_2_adelinofootballmanager;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 *
 * @author hontman
 */
public class Partida {
    //Map dos jogadores com cartão
    private static Map<Jogadores, String> jogadoresComCartao = new HashMap<>();
    //variáveis String data e local do jogo
    private String data, local;
    // Importação da classe Scanner para permitir a interação com o utilizador
    private static final Scanner scan = new Scanner(System.in);
    // Importação da classe Random para gerar numeros aleatorios
    public static Random random = new Random();
    //Método que permite ao utilizador escolher o arbito da partida, a liga e as 2 equipas que irão se defrontar
    public static void start(){
        boolean repeat = true;
        while(repeat) {
            repeat = false;

            String arbitro = selectorDeArbitro();

            boolean coin = random.nextBoolean();

            System.out.println("Escolha a Liga:");
            System.out.println("1. Liga Portuguesa");
            System.out.println("2. Liga Alemã");
            System.out.println("3. Liga Espanhola");

            int ChoosenLiga = scan.nextInt();
            scan.nextLine();

            switch (ChoosenLiga) {
                case 1:
                    int ChoosenEquipa, ChoosenEquipa2;
                    while (true) {
                        System.out.println("Escolha a equipa:");
                        for (int i = 0; i < 3; i++)
                            System.out.println((i+1) + " " + Ligas.LigaEquipas.get(i).getName());


                        ChoosenEquipa = scan.nextInt() - 1;
                        scan.nextLine();

                        if (ChoosenEquipa < 0 || ChoosenEquipa > 3)
                            System.out.println("Opção inválida!\nInsira novamente:");
                        else break;
                    }
                    while (true) {
                        for (int i = 0; i < 3; i++) {
                            if (i != ChoosenEquipa)
                                System.out.println((i+1) + Ligas.LigaEquipas.get(i).getName());
                        }

                        ChoosenEquipa2 = scan.nextInt() -1 ;
                        scan.nextLine();

                        if ((ChoosenEquipa2 < 0 || ChoosenEquipa2 > 3) || ChoosenEquipa2 == ChoosenEquipa)
                            System.out.println("Opção inválida!\nInsira novamente:");
                        else break;
                    }

                    startPartida(arbitro, coin, Equipas.getFullEquipa(ChoosenEquipa), Equipas.getFullEquipa(ChoosenEquipa2));
                    break;

                case 2:
                    System.out.println("Escolha a equipa:");
                    for (int i = 3; i < 6; i++) {
                        System.out.println((i-2) + Ligas.LigaEquipas.get(i).getName());
                    }

                    int ChoosenEquipa3 = scan.nextInt() + 2;

                    for (int i = 3; i < 6; i++) {
                        if (i != ChoosenEquipa3) {
                            System.out.println((i - 2) +  Ligas.LigaEquipas.get(i).getName());
                        }
                    }

                    int ChoosenEquipa4 = scan.nextInt() +2 ;

                    startPartida(arbitro, coin, Equipas.getFullEquipa(ChoosenEquipa3), Equipas.getFullEquipa(ChoosenEquipa4));
                    break;
                case 3:
                    System.out.println("Escolha a equipa:");
                    for (int i = 6; i < 9; i++) {
                        System.out.println((i-5) + Ligas.LigaEquipas.get(i).getName());
                    }

                    int ChoosenEquipa5 = scan.nextInt() + 5;

                    for (int i = 6; i < 9; i++) {
                        if (i != ChoosenEquipa5) {
                            System.out.println((i - 5) +  Ligas.LigaEquipas.get(i).getName());
                        }
                    }

                    int ChoosenEquipa6 = scan.nextInt() +5 ;


                    startPartida(arbitro, coin, Equipas.getFullEquipa(ChoosenEquipa5), Equipas.getFullEquipa(ChoosenEquipa6));
                    break;
                default:
                    System.out.println("Opção Inválida");
                    repeat = true;
                    break;
            }
        }
    }
//Método que aplica is cartoes amarelos e vermelhos aos jogadores
    private static void getCard(Jogadores player){
        boolean redCard = random.nextBoolean();
        if (redCard)
            jogadoresComCartao.put(player, "vermelho");
        else
            jogadoresComCartao.put(player, "amarelo");
    }
//Método que verifica a probabilidade de um jogador de cada equipa reveber um cartão
    private static void chanceCard(int Equipa){
        for (int  i = 0; i < Equipas.getEquipaSize(Equipa);i++){
            int probabilidade = random.nextInt(100);

            if(probabilidade <= (Equipas.getEquipaPlayer(Equipa, i).getAnger()/2)){
                getCard(Equipas.getEquipaPlayer(Equipa, i));
            }

        }
    }
//Método inteiro que aumenta a chance de perder da equipa que estiver com mais cartoes na sua equipa
    private static int findCards(int Equipa){
        int EquipaLoss = 0;
        List<Map.Entry<Jogadores, String>> CartoesList = jogadoresComCartao.entrySet().stream().toList();

        for(int i = 0; i < CartoesList.size(); i++){
            if(CartoesList.get(i).getKey().getEquipa() == Equipa){
                if(CartoesList.get(i).getValue().equals("amarelo"))
                    EquipaLoss += 5;
                else
                    EquipaLoss += 10;
            }
        }
        return EquipaLoss;
    }
//Método que ajuda o utilizar a selecionar o arbitro para o jogo
    public static String selectorDeArbitro(){
        while (true) {
            System.out.println("Selecione o árbitro a usar:");
            for (int i = 0; i < Arbitros.arbitros.size(); i++) {
                System.out.println("| " + (i + 1) + ". " + Arbitros.arbitros.get(i).getNome());
            }
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice > 0 && choice <= Arbitros.arbitros.size()) {
                return Arbitros.arbitros.get(choice-1).getNome();
            }
            else {
                System.out.println("Por favor selecione um valor valido");
            }
        }
    }
    //Getters e Setters
    public void setData(String data){
        this.data = data;
    }
    public String getData(){return data;}

    //Método String que devolve uma data random para o jogo de futebol
    public static String defineData()
    {
        int dia, mes, ano;
        ano = 2023;
        mes = random.nextInt(1,12);
        dia = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> random.nextInt(1, 31);
            case 2 -> random.nextInt(1, 28);
            case 4, 6, 9, 11 -> random.nextInt(1, 30);
            default -> 1;
        };
        String data ="";
        data += "Data: " + dia + "/" + mes + "/" + ano+ ".\n";
        return data;
    }
//Método que verifica quantos avançados tem cada equipa
    private static int NAtaque(Equipas equipa){
        int size = equipa.getEquipaPlayers().size();
        int count = 0;
        for (int i = 0; i < size; i++){
            if(equipa.getEquipaPlayers().get(i).getPos().equals("Avançado"))
                count++;
        }
        return size-count;
    }
    //Método que simula a partida de futebol, demonstrando o resultado, dependente de todas as probabilidades impostas
    private static void startPartida(String arbitro, boolean coin, Equipas Equipa1, Equipas Equipa2) {
        jogadoresComCartao.clear();
        // Simulate the match
        String EquipaVencedora1 = Equipa1.getName();
        String EquipaVencedora2 = Equipa1.getName();
        String vencedor;
        chanceCard(Equipa1.getInt());
        chanceCard(Equipa2.getInt());

        int actualPlayers1 = (Equipa1.getEquipaPlayers().size()-Equipa1.pain())*2 - NAtaque(Equipa1);
        int actualPlayers2 = (Equipa2.getEquipaPlayers().size()-Equipa1.pain())*2 - NAtaque(Equipa2);
        int chance1 = switch (Equipa1.getTrainer().getTaticasFavo()) {
            case "4-3-3" -> 10;
            case "4-2-2" -> 8;
            case "4-5-1" -> 6;
            case "3-5-2" -> 5;
            case "4-3-2-1" -> 4;
            case "4-2-3-1" -> 3;
            case "4-2-4" -> 2;
            case "5-3-2" -> 1;
            default -> 0;
        };
        int chance2 = switch (Equipa2.getTrainer().getTaticasFavo()) {
            case "4-3-3" -> 10;
            case "4-2-2" -> 8;
            case "4-5-1" -> 6;
            case "3-5-2" -> 5;
            case "4-3-2-1" -> 4;
            case "4-2-3-1" -> 3;
            case "4-2-4" -> 2;
            case "5-3-2" -> 1;
            default -> 0;
        };
        int chanceWin1 = 100 - findCards(Equipa1.getInt()) + actualPlayers1 + chance1;
        int chanceWin2 = 100 - findCards(Equipa2.getInt()) + actualPlayers2 + chance2;

        if (coin)
            chanceWin1 += 5;
        else
            chanceWin2 += 5;

        if(Objects.requireNonNull(Arbitros.getArbitro(arbitro)).getExperiencia() > 50) {
            if (chanceWin1 > chanceWin2)
                chanceWin1 += 10;
            else
                chanceWin2 += 10;
        } else {
            if (chanceWin1 > chanceWin2)
                chanceWin1 -= 10;
            else
                chanceWin2 -= 10;
        }

        int golos1 = Math.round((float) random.nextInt(chanceWin1)/10);
        int golos2 = Math.round((float) random.nextInt(chanceWin2)/10);
        if (golos1 > golos2) {
            vencedor = EquipaVencedora1;
            Equipa1.setVitorias();
            Equipa2.setDerrotas();
            Equipa1.setDesempenho((5));
            Equipa2.setDesempenho((-5));


        } else if (golos2 > golos1) {
            vencedor = EquipaVencedora2;
            Equipa2.setVitorias();
            Equipa1.setDerrotas();
            Equipa1.setDesempenho((-5));
            Equipa2.setDesempenho((5));
        } else {
            vencedor = "Empate";
            Equipa1.setEmpates();
            Equipa2.setEmpates();
            Equipa1.setDesempenho((0));
            Equipa2.setDesempenho((0));

        }

        System.out.println("\n");
        System.out.println(Equipa1.getName() + " vs " + Equipa2.getName());
        System.out.println("Árbitro: " + arbitro);
        System.out.println("Local: " + Equipa1.getCidade());
        System.out.println(defineData());
        System.out.println("Resultado da partida:");
        System.out.println(EquipaVencedora1 + ": " + golos1 + " golos");
        System.out.println(EquipaVencedora2 + ": "+ golos2 + " golos");
        System.out.println("Vencedor: " + vencedor + "\n");
        Equipa1.setGolosMarcados(golos1);
        Equipa2.setGolosMarcados(golos2);
        Equipa1.setGolosSofridos(golos2);
        Equipa2.setGolosSofridos(golos1);
    }

}

