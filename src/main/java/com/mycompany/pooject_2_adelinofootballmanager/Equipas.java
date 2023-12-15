/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hontman
 */
public class Equipas {
    private final String nome, Liga;
    private static Treinador trainer;
    private int vitorias, derrotas, empates, pontos;

    private static final Scanner scan = new Scanner(System.in);

    private static final ArrayList<Equipas> equipaList = new ArrayList<Equipas>(9);
    private final ArrayList<Jogadores> equipaPlayers = new ArrayList<Jogadores>(11);

    //Construtor
    public Equipas(String nome, Treinador treinador, String Liga) {
        this.nome = nome;
        this.trainer = treinador;
        this.Liga = Liga;
        equipaList.add(this);
    }

    //Funções dos ArrayLists
    public static void addToEquipa(int Equipa, Jogadores jogador) {
        equipaList.get(Equipa).equipaPlayers.add(jogador);
    }

    public static int numberEquipas(){
        return equipaList.size();
    }

    public static Jogadores getEquipaPlayer(int equipa, int player) {
        return equipaList.get(equipa).equipaPlayers.get(player);
    }

    public static String getEquipaName(int Equipa) {
        return equipaList.get(Equipa).nome;
    }

    public static int getEquipaSize(int Equipa) {
        return equipaList.get(Equipa).equipaPlayers.size();
    }

    public static String getEquipaLiga(int Equipa) {
        return equipaList.get(Equipa).Liga;
    }

    public static int getMinEquipaSize(){
        int min = 0;
        for (int i = 0; i < numberEquipas(); i++)
            if (min < getEquipaSize(i))
                min = getEquipaSize(i);
        return min;
    }

    public static Equipas getFullEquipa(int Equipa) {
        return equipaList.get(Equipa);
    }

    //Getters e setters
    public String getName() {
        return nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public String getLiga(){
        return Liga;
    }

    public void setVitorias(){
        this.vitorias++;
        this.pontos += 3;
    }
    public void setDerrotas(){
        this.derrotas++;
    }
    public void setEmpates(){
        this.empates++;
        this.pontos++;
    }

    public static void mudarLiga(){
        boolean mudada = false;
        while(mudada){
            System.out.println("Que liga gostaria de editar?\n");
            for (int i = 0; i < numberEquipas(); i++) {
                System.out.println((i + 1) + ". " + Equipas.getEquipaName(i));
            }
            int choice = scan.nextInt();
            scan.nextLine();

            if (choice > 0 && choice <= numberEquipas()) {
                System.out.println("A equipa " + equipaList.get(choice - 1).getName() + " pertence à Liga + " + equipaList.get(choice - 1).getLiga() + ", para qual deseja mudar?");
                for (int i = 0; i < 3; i++)
                    if(Ligas.getLiga(i).getLigaName().equals(equipaList.get(choice).getName()))
                        System.out.println(i + ". " + Ligas.getLiga(i).getLigaName());
                mudada = true;
            } else {
                System.out.println("Opção invalida!");
            }
        }
    }

    //Funções normais da classe
    public static void imprime(String equipa) {
        ArrayList<Equipas> e = new ArrayList<>();
        for (Equipas equipas : equipaList) {
            if (equipas.getName().equals(equipa)) {
                e.add(equipas);
            }
        }
        if(e.isEmpty())
            System.out.println("Não há equipas!");

        for (Equipas equipas : e){
            System.out.println(equipas.getName() + "(liga: " + equipas.getLiga() + ")" + ": "+ equipas.getVitorias() + " vitorias, " + equipas.getDerrotas() + " derrotas, " + equipas.getEmpates() + " empates");
            System.out.println("Treinador: " + trainer.getNome() + "\nJogadores:");
            for (Jogadores players : equipas.equipaPlayers)
                System.out.println(players.getNome());

        }
    }

//    public static String VerifyEquipa(String nome){
//        if(nome.length() <= 30){
//            if(nome.length() < 30){
//                VerifyEquipa(nome + " ");
//            }
//            else
//                return nome;
//        }
//        else{
//            System.out.println("Nome demasiado grande, por fazer escolher um até 15 caracteres!");
//            nome = scan.nextLine();
//            VerifyEquipa(nome);
//        }
//        return null;
//    }

    public static void inserirEquipa() {
            System.out.println("Insira o nome da equipa: ");
            String nome = scan.nextLine();
//            nome = VerifyEquipa(nome);
            System.out.println("Insira a Liga a que pertence: ");
            for (int i = 0; i < Ligas.AllLigas.size(); i++){
                System.out.println((i+1) + ". " + Ligas.getLiga(i).getLigaName());
            }
            int liga = scan.nextInt();
            scan.nextLine();
            String Liga = Ligas.getLiga(liga-1).getLigaName();
            System.out.println("Gostaria de inserir o Treinador manualmente?(s/n)");
            char choiceT = scan.next().charAt(0);
            scan.nextLine();
            Treinador trainer;
            if(choiceT == 's')
                trainer = Treinador.inserirTreinador();
            else
                trainer = Treinador.autoTraining(Equipas.equipaList.size());
            new Equipas(nome, trainer, Liga);
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

    @Override
    public String toString() {
        return nome + " - " + vitorias + " Vitorias, " + empates + " Empates, " + derrotas + " Derrotas," + pontos + " Pontos." + "\n";
    }
}
