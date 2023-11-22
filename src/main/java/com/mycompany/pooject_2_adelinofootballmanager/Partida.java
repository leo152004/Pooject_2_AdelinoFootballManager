/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

import java.util.Scanner;

/**
 *
 * @author hontman
 */
public class Partida {
    static Scanner scan = new Scanner(System.in);

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
                            System.out.println((i + 1) + Ligas.LigaEquipas.get(i).getName());


                        ChoosenEquipa = scan.nextInt();
                        scan.nextLine();

                        if (ChoosenEquipa < 0 || ChoosenEquipa > 3)
                            System.out.println("Opção inválida!\nInsira novamente:");
                        else break;
                    }
                    while (true) {
                        for (int i = 0; i < 3; i++) {
                            if (i != ChoosenEquipa)
                                System.out.println((i + 1) + Ligas.LigaEquipas.get(i).getName());
                        }

                        ChoosenEquipa2 = scan.nextInt();
                        scan.nextLine();

                        if ((ChoosenEquipa2 < 0 || ChoosenEquipa2 > 3) || ChoosenEquipa2 == ChoosenEquipa)
                            System.out.println("Opção inválida!\nInsira novamente:");
                        else break;
                    }

                    Partida(ChoosenEquipa, ChoosenEquipa2);
                    break;

                case 2:
                    int ChoosenEquipa3;
                    while (true) {
                        System.out.println("Escolha a equipa:");
                        for (int i = 3; i < 6; i++)
                            System.out.println((i - 2) + Ligas.LigaEquipas.get(i).getName());


                        ChoosenEquipa3 = scan.nextInt();
                        scan.nextLine();

                        if (ChoosenEquipa3 < 0 || ChoosenEquipa3 > 3)
                            System.out.println("Opção inválida!\nInsira novamente:");
                        else break;
                    }

                    int ChoosenEquipa4;
                    while (true) {
                        for (int i = 3; i < 6; i++)
                            if (i != ChoosenEquipa3)
                                System.out.println((i - 2) + Ligas.LigaEquipas.get(i).getName());


                        ChoosenEquipa4 = scan.nextInt();
                        scan.nextLine();

                        if ((ChoosenEquipa4 < 0 || ChoosenEquipa4 > 3) || ChoosenEquipa4 == ChoosenEquipa3)
                            System.out.println("Opção inválida!\nInsira novamente:");
                        else break;
                    }

                    Partida(ChoosenEquipa3, ChoosenEquipa4);
                    break;
                case 3:
                    System.out.println("Escolha a equipa:");
                    for (int i = 6; i < 9; i++) {
                        System.out.println(Ligas.LigaEquipas.get(i).getName());
                    }

                    int ChoosenEquipa5 = scan.nextInt();

                    for (int i = 1; i < 9; i++) {
                        if (i != ChoosenEquipa5) {
                            System.out.println(Ligas.LigaEquipas.get(i).getName());
                        }
                    }

                    int ChoosenEquipa6 = scan.nextInt();

                    Partida(ChoosenEquipa5, ChoosenEquipa6);
                    break;
                default:
                    System.out.println("Opção Inválida");
                    repeat = true;
                    break;
            }
        }
    }

    private static void Partida(int Equipa1, int Equipa2) {

    }
    
}
