/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

import java.io.*;
import java.io.IOException;
import java.util.*;

import static com.mycompany.pooject_2_adelinofootballmanager.Jogadores.scan;

/**
 *
 * @author hontman
 */
public abstract class Equipas {
    //Array das equipas
    static ArrayList<Liga> equipaList = new ArrayList<Liga>(9);

    //Metodos abstratos
    public abstract void addEquipa();
    public abstract  void addToEquipa(Jogadores jogador);
    public abstract int pain();

    public abstract int getInt();

    public abstract ArrayList<Jogadores> getEquipaPlayers();

    public abstract Jogadores getPlayer(int player);
    //Metodos da classe
    public static int numberEquipas(){
        return equipaList.size();
    }

    public static int getMinEquipaSize(){
        int min = 0;
        for (int i = 0; i < numberEquipas(); i++)
            if (min < getFullEquipa(i).getSize())
                min = getFullEquipa(i).getSize();
        return min;
    }

    public static Liga getFullEquipa(int Equipa) {
        return equipaList.get(Equipa);
    }

    public static Liga getFullEquipa(String Equipa) {
        for (Liga equipa : equipaList) {
            if (equipa.getNome().equals(Equipa)) {
                return equipa;
            }
        }
        return null;
    }

    public static void mudarLiga(){
        while(true){
            System.out.println("Que equipa gostaria de mudar de liga?\n");
            for (int i = 0; i < numberEquipas(); i++) {
                System.out.println((i + 1) + ". " + equipaList.get(i).getNome());
            }
            int choice = scan.nextInt();
            scan.nextLine();
            if(choice > 0 && choice < numberEquipas())
                getFullEquipa(choice).mudarLigaMini();
            else
                System.out.println("Escolha uma opção valida");
        }
    }

    public static void imprime(String equipa) {
        Liga a = getFullEquipa(equipa);
        if (a != null) {
            System.out.println(a.imprime());
        }
        else {
            System.out.println("A equipa não existe");
        }
    }

    //M´

    public void inserirEquipa() {
        System.out.println("Insira o nome da equipa: ");
        String nome = scan.nextLine();
        System.out.println("Gostaria de inserir o Treinador manualmente?(s/n)");
        char choiceT = scan.next().charAt(0);
        scan.nextLine();
        Treinador trainer;
        if(choiceT == 's')
            trainer = Treinador.inserirTreinador();
        else
            trainer = Treinador.autoTraining(Equipas.equipaList.size());
        System.out.println("Que cidade pertence a equipa?");
        String cidade = scan.nextLine();
        System.out.println("Insira a Liga a que pertence: ");
        System.out.println("1. Portuguesa");
        System.out.println("2. Espanhola");
        System.out.println("3. Alemã");
        int liga = scan.nextInt();
        scan.nextLine();

        switch(liga){
            case 1:
                new EquipaPT(nome, trainer, cidade);
                break;
            case 2:
                new EquipaES(nome, trainer, cidade);
                break;
            case 3:
                new EquipaAL(nome, trainer, cidade);
                break;
            default:
                System.out.println("Selecione uma Liga valida por favor.");
                break;
        }
        addPlayers();
    }

    private static void addPlayers() {
        System.out.println("Gostaria de inserir jogadores manualmente?");
        System.out.println("1. Sim, inserir os 11 jogadores manualmente");
        System.out.println("2. Inserir alguns manualmente e autocompletar");
        System.out.println("3. Inserir automaticamente");
        int choice = scan.nextInt();
        switch(choice) {
            case 1:
                for (int i = 0; i <= 11; i++) {
                    Jogadores.inserirJogador(equipaList.size());
                }
                break;
            case 2:
                System.out.println("Quantos gostaria de inserir ?");
                int playerMaking = scan.nextInt();
                scan.nextLine();
                for (int i = 0; i < playerMaking; i++) {
                    Jogadores.inserirJogador(equipaList.size());
                }
                for (int i = 0; i < 11 - playerMaking; i++) {
                    Jogadores.autoPlayer(equipaList.size());
                }
                break;
            case 3:
                for (int i = 0; i < 11; i++) {
                    Jogadores.autoPlayer(equipaList.size());
                }
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public static void writer() throws IOException {
        String classe;
        for (Liga equipa : equipaList) {
            classe = equipa.getLigaNome();
            switch (classe) {
                case "Portuguesa":
                    FileWriter PTFW = new FileWriter("equipasPT.txt");
                    BufferedWriter PTBW = new BufferedWriter(PTFW);
                    PrintWriter PT = new PrintWriter(PTBW);
                    PT.println(equipa.printable());
                    PT.close();
                    break;
                case "Espanhola":
                    FileWriter ESFW = new FileWriter("equipasES.txt");
                    BufferedWriter ESBW = new BufferedWriter(ESFW);
                    PrintWriter ES = new PrintWriter(ESBW);
                    ES.println(equipa.printable());
                    ES.close();
                    break;
                case "Alema":
                    FileWriter ALFW = new FileWriter("equipasAL.txt");
                    BufferedWriter ALBW = new BufferedWriter(ALFW);
                    PrintWriter AL = new PrintWriter(ALBW);
                    AL.println(equipa.printable());
                    AL.close();
                    break;
                default:
                    System.out.println("Equipa de Liga não reconhecida");
            }

        }
    }
}
