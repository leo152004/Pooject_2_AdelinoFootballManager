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
    private final String nome;
    private static int vitorias, derrotas, empates, pontos;

    static Scanner scan = new Scanner(System.in);

    static ArrayList<Equipas> equipaList = new ArrayList<Equipas>(9);
    ArrayList<Jogadores> equipaPlayers = new ArrayList<>(11);

    public Equipas(String nome) {
        this.nome = nome;
        equipaList.add(this);
    }

    public String getName() {
        return nome;
    }

    public int getVitorias() {
        return vitorias;
    }

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
            }
        }
    }

    public static void inserirEquipa() {
        System.out.println("Insira o nome da equipa: ");
        String nome = scan.nextLine();
        System.out.println("Insira a Liga a que pertence: ");
        String liga = scan.nextLine();
        Treinador.inserirTreinador();
        System.out.println("Gostaria de inserir jogadores manualmente?");
        System.out.println("1. Sim, inserir os 11 jogadores manualmente");
        System.out.println("2. Inserir alguns manualmente e autocompletar");
        System.out.println("3. Inserir automaticamente");
        int choice = scan.nextInt();
        if(choice == 1) {
            for (int i = 0; i <= 11; i++) {
                Jogadores.inserirJogador();
            }
        } else if(choice == 2) {
            System.out.println("Quantos gostaria de inserir ?");
            int playerMaking = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < playerMaking; i++) {
                Jogadores.inserirJogador();
            }
            for (int i = 0; i < 11 - playerMaking; i++) {
                Jogadores.autoPlayer();
            }
        } else{
            for (int i = 0; i < 11; i++) {
                Jogadores.autoPlayer();
            }
        }
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

}
