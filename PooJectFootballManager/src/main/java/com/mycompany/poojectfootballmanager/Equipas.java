/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poojectfootballmanager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hontman
 */
public class Equipas {
    private final String nome, Liga;
    private static Treinador trainer;
    private static int vitorias, derrotas, empates, pontos;

    private static Scanner scan = new Scanner(System.in);

    private static ArrayList<Equipas> equipaList = new ArrayList<Equipas>(9);
    private static ArrayList<Jogadores> equipaPlayers = new ArrayList<Jogadores>(11);

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

    public static Jogadores getEquipaPlayer(String equipa, int player) {
        int equipaN = numberEquipas();
        for (int i = 0; i < numberEquipas(); i++) {
            if (equipaList.get(i).nome.equals(equipa))
                equipaN = i;
            else if(i == numberEquipas() - 1) {
                System.out.println("Equipa não encontrada");
                break;
            }
        }

        if(equipaN < numberEquipas())
            return equipaList.get(equipaN).equipaPlayers.get(player);
        return null;
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

    public int getPontos() {
        return pontos;
    }

    public String getLiga(){
        return Liga;
    }

    public void setVitorias(int vitorias){
        this.vitorias = vitorias;
    }
    public void setDerrotas(int derrotas){
        this.derrotas = derrotas;
    }

    public void setEmpates (int empates){
        this.empates = empates;
    }
    public void setPontos (int pontos){
        this.pontos = pontos;
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
        else{
            for (Equipas equipas : e){
                System.out.println(equipas.getName() + ": " + equipas.getVitorias() + " vitorias, " + equipas.getDerrotas() + " derrotas, " + equipas.getEmpates() + " empates, " + equipas.getPontos() + " pontos");
                System.out.println("Treinador: " + trainer.getNome() + "\nJogadores:");
                for (Jogadores players : equipas.equipaPlayers)
                    System.out.println(players.getNome());
            }
        }
    }

    public static String VerifyEquipa(String nome){
        if(nome.length() <= 30){
            if(nome.length() < 30){
                VerifyEquipa(nome + " ");
            }
            else
                return nome;
        }
        else{
            System.out.println("Nome demasiado grande, por fazer escolher um até 15 caracteres!");
            nome = scan.nextLine();
            VerifyEquipa(nome);
        }
        return null;
    }

    public static void inserirEquipa() {
            System.out.println("Insira o nome da equipa: ");
            String nome = scan.nextLine();
            nome = VerifyEquipa(nome);
            System.out.println("Insira a Liga a que pertence: ");
            String liga = scan.nextLine();
            System.out.println("Gostaria de inserir o Treinador manualmente?(s/n)");
            char choiceT = scan.next().charAt(0);
            Treinador trainer;
            if(choiceT == 's')
                trainer = Treinador.inserirTreinador();
            else
                trainer = Treinador.autoTraining(Equipas.equipaList.size());
            System.out.println("Gostaria de inserir jogadores manualmente?");
            System.out.println("1. Sim, inserir os 11 jogadores manualmente");
            System.out.println("2. Inserir alguns manualmente e autocompletar");
            System.out.println("3. Inserir automaticamente");
            int choice = scan.nextInt();
            if (choice == 1) {
                for (int i = 0; i <= 11; i++) {
                    Jogadores.inserirJogador();
                }
            } else if (choice == 2) {
                System.out.println("Quantos gostaria de inserir ?");
                int playerMaking = scan.nextInt();
                scan.nextLine();
                for (int i = 0; i < playerMaking; i++) {
                    Jogadores.inserirJogador();
                }
                for (int i = 0; i < 11 - playerMaking; i++) {
                    Jogadores.autoPlayer();
                }
            } else {
                for (int i = 0; i < 11; i++) {
                    Jogadores.autoPlayer();
                }
            }
            new Equipas(nome, trainer, liga);
    }
    @Override
    public String toString() {
        return nome + " - " + vitorias + " Vitorias, " + empates + " Empates, " + derrotas + " Derrotas, "
                + pontos + "\n";
    }
}
