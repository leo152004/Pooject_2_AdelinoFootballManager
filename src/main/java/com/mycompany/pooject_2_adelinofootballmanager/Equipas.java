/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hontman
 */
public class Equipas {
    private final String nome, Liga;
    private final Treinador trainer;
    private int vitorias, derrotas, empates, pontos,golosSofridos, golosMarcados;
    private int desempenho = 50;

    private String cidade;

    private Random rand = new Random();
    private static final Scanner scan = new Scanner(System.in);

    private static final ArrayList<Equipas> equipaList = new ArrayList<Equipas>(9);
    private ArrayList<Jogadores> equipaPlayers = new ArrayList<Jogadores>(11);

    //Construtor
    public Equipas(String nome, Treinador treinador, String Liga, String cidade) {
        this.nome = nome;
        this.trainer = treinador;
        this.Liga = Liga;
        this.cidade =cidade;
        equipaList.add(this);
    }

    //Funções dos ArrayLists
    public static void addToEquipa(int Equipa, Jogadores jogador) {
        equipaList.get(Equipa).equipaPlayers.add(jogador);
    }

    public static int numberEquipas(){
        return equipaList.size();
    }
    public Treinador getTrainer(){
        return trainer;
    }

    public int pain(){
        int nLesoes = 0;
        int chance = rand.nextInt(100);
        for(int i = 0; i < equipaPlayers.size(); i++)
            if(chance < 10) {
                equipaPlayers.get(i).painMaker();
                nLesoes++;
            }
        return nLesoes;
    }

    public static Jogadores getEquipaPlayer(int equipa, int player) {
        return equipaList.get(equipa).equipaPlayers.get(player);
    }
    public void setCidade(String cidade){this.cidade = cidade;}
    public static String getCidade(int Equipa){return equipaList.get(Equipa).cidade;}
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

    public ArrayList<Jogadores> getEquipaPlayers(){
        return equipaPlayers;
    }

    //Getters e setters
    public String getName() {
        return nome;
    }

    public int getVitorias() {
        return vitorias;
    }
    public int getGolosSofridos(){return golosSofridos;}
    public int getGolosMarcados(){return golosMarcados;}

    public int getDesempenho(){return desempenho;}
    public void setDesempenho(int desempenho){
        this.desempenho += desempenho;
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

    public String getCidade() {
        return cidade;
    }

    public void setGolosSofridos(int golosSofridos ) {
        this.golosSofridos += golosSofridos;
    }

    public void setGolosMarcados(int golosMarcados){
        this.golosMarcados += golosMarcados;
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
        while(true){
            System.out.println("Que equipa gostaria de mudar de liga?\n");
            for (int i = 0; i < numberEquipas(); i++) {
                System.out.println((i + 1) + ". " + Equipas.getEquipaName(i));
            }
            int choice = scan.nextInt();
            scan.nextLine();

            int choice2;
            while(true) {
                if (choice > 0 && choice <= numberEquipas()) {
                    System.out.println("A equipa " + equipaList.get(choice - 1).getName() + " pertence à Liga " + equipaList.get(choice - 1).getLiga() + ", para qual deseja mudar?");
                    for (int i = 0; i < 3; i++) {
                        if (i != choice) {
                            System.out.println((i + 1) + Ligas.getLiga(i).getLigaName());
                        }
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        Ligas.setLigatoEquipa(choice2, choice);
                        break;
                    }
                }

            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if (o.getClass() != getClass()) return false;

        Equipas o1 = (Equipas) o;
        return  o1.getName().equals(getClass().getName());
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
            System.out.println(equipas.getName() + " ( Liga " + equipas.getLiga() + ")" + ": "+ equipas.getVitorias() + " vitorias, " + equipas.getDerrotas() + " derrotas, " + equipas.getEmpates() + " empates, "+ equipas.getGolosMarcados() + " GM," + equipas.getGolosSofridos() + " GS," + equipas.getDesempenho() + " DM.");
            System.out.println("Treinador: " + equipas.getTrainer().getNome() +"\nCidade: " +equipas.getCidade()+ "\nJogadores:");
            for (Jogadores players : equipas.equipaPlayers)
                System.out.println(players.getNome());
        }
    }

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
            System.out.println("Que cidade pertence a equipa?");
            String cidade = scan.nextLine();
            new Equipas(nome, trainer, Liga, cidade);
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
        return nome + " - " + vitorias + " Vitorias, " + empates + " Empates, " + derrotas + " Derrotas," + golosMarcados+" Golos Marcados," + golosSofridos + " Golos Sofridos," + desempenho + " Desempenho Médio," + pontos + " Pontos." + "\n";
    }
}
