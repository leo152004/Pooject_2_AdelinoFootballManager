package com.mycompany.pooject_2_adelinofootballmanager;

import java.util.*;
import java.util.stream.Collectors;

/*
 *
 * @author hontman
 */
public class Partida {

    private static Map<Jogadores, String> jogadoresComCartao = new HashMap<>();
    private String data, local;
    private static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    public static void start(){
        boolean repeat = true;
        while(repeat) {
            repeat = false;

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
                            System.out.println((i+1) + Ligas.LigaEquipas.get(i).getName());


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

                    startPartida(ChoosenEquipa, ChoosenEquipa2);
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

                    startPartida(ChoosenEquipa3, ChoosenEquipa4);
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


                    startPartida(ChoosenEquipa5, ChoosenEquipa6);
                    break;
                default:
                    System.out.println("Opção Inválida");
                    repeat = true;
                    break;
            }
        }
    }

    private static void getCard(Jogadores player){
        boolean redCard = random.nextBoolean();
        if (redCard)
            jogadoresComCartao.put(player, "vermelho");
        else
            jogadoresComCartao.put(player, "amarelo");
    }

    private static void chanceCard(int Equipa){
        for (int  i = 0; i < Equipas.getEquipaSize(Equipa);i++){
            int probabilidade = random.nextInt(100);

            if(probabilidade <= (Equipas.getEquipaPlayer(Equipa, i).getAnger()/2)){
                getCard(Equipas.getEquipaPlayer(Equipa, i));
            }

        }
    }

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

    private static void startPartida(int Equipa1, int Equipa2) {
        jogadoresComCartao.clear();
        // Simulate the match
        String EquipaVencedora1 = Equipas.getEquipaName(Equipa1);
        String EquipaVencedora2 = Equipas.getEquipaName(Equipa2);
        String vencedor;
        chanceCard(Equipa1);
        chanceCard(Equipa2);

        int golosfeitos1 = random.nextInt(100 - findCards(Equipa1));
        int golosfeitos2 = random.nextInt(100 - findCards(Equipa2));
        int golos1 = Math.round((float) golosfeitos1/10);
        int golos2 = Math.round((float) golosfeitos2/10);
        if (golos1 > golos2) {
            vencedor = EquipaVencedora1;
            Equipas.getFullEquipa(Equipa1).setVitorias();
            Equipas.getFullEquipa(Equipa2).setDerrotas();
        } else if (golos2 > golos1) {
            vencedor = EquipaVencedora2;
            Equipas.getFullEquipa(Equipa2).setVitorias();
            Equipas.getFullEquipa(Equipa1).setDerrotas();
        } else {
            vencedor = "Empate";
            Equipas.getFullEquipa(Equipa1).setEmpates();
            Equipas.getFullEquipa(Equipa2).setEmpates();
        }


        // Display the match result
        System.out.println("Resultado da partida:");
        System.out.println(EquipaVencedora1 + ": " + golos1 + " golos");
        System.out.println(EquipaVencedora2 + ": "+ golos2 + " golos");

        System.out.println("Vencedor: " + vencedor);
    }

}

