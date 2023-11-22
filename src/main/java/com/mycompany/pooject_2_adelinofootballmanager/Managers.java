/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

/**
 *
 * @author hontman
 */
import java.util.Scanner;

public class Managers {
    static Scanner scanner = new Scanner(System.in);
    private String managerChosen;

    public Managers() {
        this.managerChosen = "";
    }

    public static void theManager(String managerChosen) {
        boolean repeat = true;

        while (repeat) {
            repeat = false;
            switch (managerChosen) {
                case "jogadores":
                    System.out.println("Selecione uma opção para o jogador: ");
                    System.out.println("|----------------//----------------|");
                    System.out.println("| 1.Dados dos jogadores /----------|");
                    System.out.println("| 2.Dados de um jogador /----------|");
                    System.out.println("| 3.Inserir jogador /--------------|");
                    System.out.println("| 4.Voltar /-----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice1 = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice1) {
                        case 1:
                            Jogadores.allData();
                            break;
                        case 2:
                            System.out.println("Selecione o jogador (nome): ");
                            String player = scanner.nextLine();
                            Jogadores.Data(player);
                            break;
                        case 3:
                            Jogadores.inserirJogador();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            repeat = true;
                            break;
                    }
                    break;
                case "ligas":
                    System.out.println("Selecione uma em Ligas: ");
                    System.out.println("|----------------//----------------|");
                    System.out.println("| 1.Liga Portuguesa /--------------|");
                    System.out.println("| 2.Liga Alemã /-------------------|");
                    System.out.println("| 3.Liga Espanhola /---------------|");
                    System.out.println("| 4.Voltar /-----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice2) {
                        case 1:
                            Ligas.imprime("pt");
                            break;
                        case 2:
                            Ligas.imprime("ale");
                            break;
                        case 3:
                            Ligas.imprime("esp");
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            repeat = true;
                            break;
                    }
                    break;
                case "equipas":
                    System.out.println("Selecione uma Equipa: ");
                    System.out.println("|----------------//----------------|");
                    for (int i = 0; i < Equipas.equipaList.size(); i++) {
                        System.out.println("| " + (i + 1) + ". " + Equipas.equipaList.get(i).getName());
                    }
                    System.out.println("| " + Equipas.equipaList.size() + ".Inserir Equipa /--------------|");
                    System.out.println("| " + (Equipas.equipaList.size() + 1) + ".Voltar /----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice3 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice3 > 0 && choice3 < Equipas.equipaList.size()) {
                        Equipas.imprime(Equipas.equipaList.get(choice3-1).getName());
                    }
                    else if (choice3 == Equipas.equipaList.size()){
                        Equipas.inserirEquipa();
                    }
                    else if (choice3 == Equipas.equipaList.size()+1){
                        break;
                    }
                    else {
                        System.out.println("Opção inválida!");
                        repeat = true;
                    }
                    break;
                case "treinadores":
                    System.out.println("Selecione um Treinador: ");
                    System.out.println("|----------------//----------------|");
                    for (int i = 0; i < Treinador.treinadores.size(); i++) {
                        System.out.println("| " + (i + 1) + ". " + Treinador.treinadores.get(i).getNome());
                    }
                    System.out.println("| " + Treinador.treinadores.size() + ".Voltar /----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice4 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice4 > 0 && choice4 < Treinador.treinadores.size()) {
                        Treinador.imprime(Treinador.treinadores.get(choice4-1).getNome());
                    }
                    else if (choice4 == Treinador.treinadores.size()) {
                        break;
                    } else{
                        System.out.println("Opção inválida!");
                        repeat = true;
                    }
                    break;
                case "arbitros":
                    System.out.println("Selecione um Arbitro: ");
                    System.out.println("|----------------//----------------|");
                    System.out.println("| 1.Adelino Henriques /------------|");
                    System.out.println("| 2.Catarina Freitas /-------------|");
                    System.out.println("| 3.Milena Carreira /--------------|");
                    System.out.println("| 4.Afonso PHP edition /-----------|");
                    System.out.println("| 5.Lucas Waddlle /----------------|");
                    System.out.println("| 6.Voltar /-----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice5 = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice5) {
                        case 1:
                            Treinador.imprime("Adelino Henriques");
                            break;
                        case 2:
                            Treinador.imprime("Catarina Freitas");
                            break;
                        case 3:
                            Treinador.imprime("Milena Carreira");
                            break;
                        case 4:
                            Treinador.imprime("Afonso Java edition");
                            break;
                        case 5:
                            Treinador.imprime("Lucas Waddlle");
                            break;
                        case 6:
                            Partida.start();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            repeat = true;
                            break;
                    }
                    break;
                case "criarPartida":
                    Partida.start();
                    break;
                default:
                    break;
            }
        }
    }
}