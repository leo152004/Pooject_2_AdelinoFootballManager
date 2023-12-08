/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poojectfootballmanager;

import java.util.*;

/*
 *
 * @author hontman
 */
public class Partida {

    private static Map<String, Jogadores> jogadoresComCartao = new HashMap<>();
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

    private static void getCard(int Equipa1, int Equipa2, String color){
        int player = random.nextInt(Equipas.getEquipaSize(Equipa1)) + Equipas.getEquipaSize(Equipa2);
        if (player > Equipas.getEquipaSize(Equipa1)) {player -= Equipas.getEquipaSize(Equipa1);
            jogadoresComCartao.put(color, Equipas.getEquipaPlayer(Equipas.getEquipaName(Equipa2), player));
        }
        jogadoresComCartao.put(color, Equipas.getEquipaPlayer(Equipas.getEquipaName(Equipa1), player));

    }


    private static void startPartida(int Equipa1, int Equipa2) {
        // Simulate the match
        String EquipaVencedora = Equipas.getEquipaName(Equipa1);
        String EquipaVencedora1 = Equipas.getEquipaName(Equipa2);
        Random random = new Random();
        String vencedor ;
        String Amarelo = "Amarelo";
        String Vermelho = "Vermelho";
        /*for (int  i = 0; i < 90;i++){
            if(i<=45) {
                int probabilidade = random.nextInt(100);
                ((Equipas) ) = new Jogadores();
                if(probabilidade <= Jogadores.){
                    getCard(Equipa1,Equipa2,Amarelo);
                }

            }

        }*/
        int golosfeitos1 = random.nextInt(10);
        int golosfeitos2 = random.nextInt(10);
        if (golosfeitos1 > golosfeitos2) {
            vencedor = EquipaVencedora;
        } else if (golosfeitos2 > golosfeitos1) {
            vencedor = EquipaVencedora1;
        } else {
            vencedor = "Empate";
        }

        // Display the match result
        System.out.println("Resultado da partida:");
        System.out.println(EquipaVencedora+ ": " + golosfeitos1 + " golos");
        System.out.println(EquipaVencedora1 + ": "+ golosfeitos2 + " golos");
        System.out.println("Vencedor: " + vencedor);
    }
    
}

