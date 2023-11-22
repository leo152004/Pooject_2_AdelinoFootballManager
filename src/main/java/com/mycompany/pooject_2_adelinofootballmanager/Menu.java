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

public class Menu {
    public void theMenu() {
        int option, exit = 1;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nBem Vindo ao Adelino Football Manager 23");

        while (exit == 1) {
            System.out.println("Selecione uma opção:");
            System.out.println("|----------------//----------------|");
            System.out.println("| 1.Jogadores /--------------------|");
            System.out.println("| 2.Ligas /------------------------|");
            System.out.println("| 3.Equipas /----------------------|");
            System.out.println("| 4.Treinadores /------------------|");
            System.out.println("| 5.Arbitros /---------------------|");
            System.out.println("| 6.Criar uma partida /------------|");
            System.out.println("| 7.Sair /-------------------------|");
            System.out.println("|----------------//----------------|");

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    Managers.theManager("jogadores");
                    break;
            case 2:
                Managers.theManager("ligas");
                break;
            case 3:
                Managers.theManager("equipas");
                break;
            case 4:
                Managers.theManager("treinadores");
                break;
            case 5:
                Managers.theManager("arbitros");
                break;
            case 6:
                Managers.theManager("criarPartida");
                break;
            case 7:
                exit = 0;
               break;
            default:
                System.out.println("Opção inválida!");
            }
        }
    }
}
