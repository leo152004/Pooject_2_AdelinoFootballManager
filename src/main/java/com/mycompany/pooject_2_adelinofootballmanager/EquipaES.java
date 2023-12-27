/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pooject_2_adelinofootballmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author leand
 */
public class EquipaES extends Equipas implements Liga{
    //variaveis
    private final String nome, cidade;
    private Treinador trainer;
    private int vitorias, derrotas, empates, pontos, golosSofridos, golosMarcados, desempenho = 50;

    private static final String Liga = "Portuguesa";
    private final Random rand = new Random();
    private static final Scanner scan = new Scanner(System.in);

    private final ArrayList<Jogadores> equipaPlayers = new ArrayList<Jogadores>(11);

    //construtores
    public EquipaES(String nome, Treinador treinador, String cidade) {
        this.nome = nome;
        this.trainer = treinador;
        this.cidade = cidade;
        addEquipa();
    }

    public EquipaES(String nome, Treinador treinador, int vitorias, int derrotas, int empates, int pontos, int golosSofridos, int golosMarcados, int desempenho, String cidade, ArrayList<Jogadores> players) {
        this.nome = nome;
        this.trainer = treinador;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.pontos = pontos;
        this.golosSofridos = golosSofridos;
        this.golosMarcados = golosMarcados;
        this.desempenho = desempenho;
        this.cidade = cidade;
        addEquipa();
        this.equipaPlayers.addAll(players);
    }

    //Getters e Setters
    public String getNome(){
        return nome;
    }
    public String getCidade(){
        return cidade;
    }
    public void setVitorias(){vitorias++; pontos += 3;}
    public void setDerrotas(){derrotas++;}
    public void setEmpate(){empates++; pontos++;}
    public void setGolosSofridos(){golosSofridos++;}
    public void setGolosMarcados(){golosMarcados++;}
    public Treinador getTrainer(){return trainer;}
    public int getSize(){return equipaPlayers.size();}
    public String getLiga(){ return Liga;}
    public int getVitorias(){return vitorias;}
    public int getDerrotas(){return derrotas;}
    public int getEmpates(){return empates;}
    public int getPontos(){return pontos;}
    public int getGolosS(){return golosSofridos;}
    public int getGolosM(){return golosMarcados;}
    public int getDesempenho(){return desempenho;}
    public int playerSize(){return equipaPlayers.size();}
    public String getAllPlayersName(){
        String names = "";
        for (Jogadores Player : equipaPlayers) {
            names += Player.getNome() + "\n";
        }
        return names;
    }
    //metodos da Equipas
    public void addEquipa(){
        equipaList.add(this);
    }

    public void addToEquipa(Jogadores jogador) {
        this.equipaPlayers.add(jogador);
    }

    public int pain(){
        int nLesoes = 0;
        int chance = rand.nextInt(100);
        for (Jogadores equipaPlayer : equipaPlayers)
            if (chance < 10) {
                equipaPlayer.painMaker();
                nLesoes++;
            }
        return nLesoes;
    }

    public int getInt(){
        for(int i = 0; i < equipaList.size(); i++){
            if (this == equipaList.get(i))
                return i;
        }
        return 0;
    }

    public ArrayList<Jogadores> getEquipaPlayers(){
        return equipaPlayers;
    }

    public Jogadores getPlayer(int player){
        return equipaPlayers.get(player);
    }
    public void mudarLigaMini() {
        System.out.println("A equipa " + nome + " pertence á liga " + Liga + ", para qual pretende mudar?");
        System.out.println("1. Portuguesa");
        System.out.println("2. Alemã");
        int choice = scan.nextInt();
        scan.nextLine();
        while (true) {
            switch (choice) {
                case 1:
                    new EquipaPT(nome, trainer, vitorias, derrotas, empates, pontos, golosSofridos, golosMarcados, desempenho, cidade, equipaPlayers);
                    equipaList.remove(this);
                case 2:
                    new EquipaAL(nome, trainer, vitorias, derrotas, empates, pontos, golosSofridos, golosMarcados, desempenho, cidade, equipaPlayers);
                    equipaList.remove(this);
                default:
                    System.out.println("Por favor, escolha uma opção valida");
                    break;
            }
        }
    }

    public String imprime(){
        String text = nome + " (Liga " + Liga + "):\n" + vitorias + "vitorias, "  + derrotas + "derrotas, " + empates + "empates, " + golosMarcados + "golos marcados, "
                + golosSofridos + "golos sofridos, " + desempenho + "desempenho medio, " + "treinador: " + trainer.getNome() + ",cidade " + cidade + ", \nJogadores:\n";
        for(Jogadores players : equipaPlayers)
            text += players.getNome();
        return text;
    }

    public static void reader() throws IOException {
        FileReader fr = new FileReader("equipasES.txt");
        BufferedReader br = new BufferedReader(fr);
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] equipa = br.readLine().split(" ; ");
            String nome = equipa[0];
            Treinador trainer = Treinador.getTrainer(equipa[1]);
            int vitorias = Integer.parseInt(equipa[2]);
            int derrotas = Integer.parseInt(equipa[3]);
            int empates = Integer.parseInt(equipa[4]);
            int pontos = Integer.parseInt(equipa[5]);
            int golosSofridos = Integer.parseInt(equipa[6]);
            int golosMarcados = Integer.parseInt(equipa[7]);
            int desempenho = Integer.parseInt(equipa[8]);
            String cidade = equipa[9];
            int nPlayers = Integer.parseInt(equipa[10]);
            ArrayList<Jogadores> players = new ArrayList<Jogadores>(nPlayers);
            for (int k = 0; k < nPlayers; k++) {
                players.add(Jogadores.getPlayer(br.readLine()));
            }
            new EquipaES(nome, trainer, vitorias, derrotas, empates, pontos, golosSofridos, golosMarcados, desempenho, cidade, players);
        }
    }
    //Metodos de Liga
    public String getLigaNome(){return Liga;}

    public String printable(){
        return nome + " ; " + trainer.getNome() + " ; " + vitorias + " ; " + derrotas + " ; " + empates + " ; " + pontos + " ; " + golosSofridos + " ; " + golosMarcados
                + " ; " + desempenho + " ; " + cidade + " ; " + playerSize() + "\n" + getAllPlayersName();
    }
    //Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if (o.getClass() != getClass()) return false;

        Liga o1 = (Liga) o;
        return  o1.getNome().equals(getClass().getName());
    }

    @Override
    public String toString() {
        return nome + " - " + vitorias + " Vitorias, " + empates + " Empates, " + derrotas + " Derrotas," + golosMarcados+" Golos Marcados," + golosSofridos + " Golos Sofridos," + desempenho + " Desempenho Médio," + pontos + " Pontos." + "\n";
    }
}
