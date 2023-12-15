/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

/*
 *
 * @author hontman
 */
import java.util.Scanner;

public class Managers {
    static Scanner scanner = new Scanner(System.in);

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
                            Ligas.imprime("Portuguesa");
                            break;
                        case 2:
                            Ligas.imprime("Alema");
                            break;
                        case 3:
                            Ligas.imprime("Espanhola");
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
                    for (int i = 0; i < Equipas.numberEquipas(); i++) {
                        System.out.println("| " + (i + 1) + ". " + Equipas.getEquipaName(i));
                    }
                    System.out.println("| " + (Equipas.numberEquipas()+1) + ". Editar a Liga /---------------|");
                    System.out.println("| " + (Equipas.numberEquipas()+2) + ". Inserir Equipa /--------------|");
                    System.out.println("| " + (Equipas.numberEquipas()+3) + ". Voltar /----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice3 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice3 > 0 && choice3 <= Equipas.numberEquipas()) {
                        Equipas.imprime(Equipas.getEquipaName(choice3-1));
                    }
                    else if (choice3 == Equipas.numberEquipas()+1){
                        Equipas.inserirEquipa();
                    }
                    else if (choice3 == Equipas.numberEquipas()+2){
                        Equipas.mudarLiga();
                    }
                    else if (choice3 == Equipas.numberEquipas()+3){
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
                    System.out.println("| " + (Treinador.treinadores.size()+1) + ". Voltar /----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice4 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice4 > 0 && choice4 <= Treinador.treinadores.size()) {
                        Treinador.imprime(Treinador.treinadores.get(choice4-1).getNome());
                    }
                    else if (choice4 == Treinador.treinadores.size()+1) {
                        break;
                    } else{
                        System.out.println("Opção inválida!");
                        repeat = true;
                    }
                    break;
                case "arbitros":
                    System.out.println("Selecione um Arbitro: ");
                    System.out.println("|----------------//----------------|");
                    for (int i = 0; i < Arbitros.arbitros.size(); i++) {
                        System.out.println("| " + (i + 1) + ". " + Arbitros.arbitros.get(i).getNome());
                    }
                    System.out.println("| 7.Voltar /-----------------------|");
                    System.out.println("|----------------//----------------|");

                    int choice5 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice5 > 0 && choice5 <= Arbitros.arbitros.size()) {
                        Arbitros.imprime(Arbitros.arbitros.get(choice5-1).getNome());
                    }
                    else if (choice5 == 7) {
                        break;
                    } else{
                        System.out.println("Opção inválida!");
                        repeat = true;
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