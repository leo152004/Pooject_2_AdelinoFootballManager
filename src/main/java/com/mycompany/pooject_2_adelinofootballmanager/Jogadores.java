/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

/**
 *
 * @author hontman
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Jogadores extends Pessoa {
    static ArrayList<Jogadores> jogadores = new ArrayList<Jogadores>(99);
    private final String posicao, equipa;
    private final int statAt, statDef, angerLevel, titulos, nEquipa;

    static Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public Jogadores(String position, String team, int ataque, int defesa, int anger, int titulos, int nEquipa) {
        super();
        this.posicao = position;
        this.equipa = team;
        this.nEquipa = nEquipa;
        this.statAt = ataque;
        this.statDef = defesa;
        this.angerLevel = anger;
        this.titulos = titulos;
        jogadores.add(this);
        Equipas.equipaList.get(nEquipa).equipaPlayers.add(this);
    }

    public Jogadores(String nome, int idade, String posicao, String equipa, int ataque, int defesa, int angerLevel, int titulos, int nEquipa) {
        super(nome, idade);
        this.posicao = posicao;
        this.equipa = equipa;
        this.nEquipa = nEquipa;
        this.statAt = StatsSetter(ataque);
        this.statDef = StatsSetter(defesa);
        this.angerLevel = angerLevel;
        this.titulos = titulos;
        jogadores.add(this);
        Equipas.equipaList.get(nEquipa - 1).equipaPlayers.add(this);
    }

    private static String givenChoiceP() {
        System.out.println("Selecione a posição do jogador:");
        System.out.println("1.Avançado");
        System.out.println("2.Medio");
        System.out.println("3.Defesa");
        System.out.println("4.Guarda-Redes");

        int position = scan.nextInt();

        return switch (position) {
            case 1 -> "Avançado";
            case 2 -> "Medio";
            case 3 -> "Defesa";
            case 4 -> "Guarda-Redes";
            default -> {
                System.out.println("Opção inválida!");
                yield givenChoiceP();
            }
        };
    }
    private static int givenChoiceT() {
            System.out.println("Selecione a equipa do jogador:");
            for(int i = 0; i < Equipas.equipaList.size(); i++) {
                System.out.println(i+1 + ". " + Equipas.equipaList.get(i).getName());
            }

            int EquipaID = scan.nextInt();

            return EquipaID;
    }

    public static void inserirJogador() {
        int age, anger, titulos, ataque, defesa;
        System.out.println("Digite o nome do jogador:");
        String name = scan.nextLine();
        System.out.println("Digite a idade do jogador (número):");
        try {
            age = scan.nextInt();
        }
        catch(Exception e) {
            System.out.println("Por favor insira um número:");
            age = scan.nextInt();
        }
        scan.nextLine();
        String position = givenChoiceP();
        int whatTeam = givenChoiceT();
        String team = Equipas.equipaList.get(whatTeam).getName();
        System.out.println("Digite o nivel de agrissividade do jogador (número):");
        try {
            anger = scan.nextInt();
        }
        catch(Exception e) {
            System.out.println("Por favor insira um número:");
            anger = scan.nextInt();
        }
        scan.nextLine();
        System.out.println("Digite o número de titulos do jogador (número):");
        try {
            titulos = scan.nextInt();
        }
        catch(Exception e) {
            titulos = scan.nextInt();
        }
        scan.nextLine();
        System.out.println("Digite o ataque do jogador (número):");
        try {
            ataque = scan.nextInt();
        }
        catch(Exception e) {
            ataque = scan.nextInt();
            scan.nextLine();
        }
        System.out.println("Digite a defesa do jogador (número):");
        try {
            defesa = scan.nextInt();
        }
        catch(Exception e) {
            defesa = scan.nextInt();
            scan.nextLine();
        }
        try {
            new Jogadores(name, age, position, team, ataque, defesa, anger, titulos, whatTeam);
        }
        catch (Exception e) {
            System.out.println("Por favor, insira valores validos!");
            inserirJogador();
        }
    }

    public static void autoPlayer() {
        int posi = random.nextInt(1, 4);
        String position;
        switch (posi) {
            case 1:
                position = "Avançado";
                break;
            case 2:
                position = "Medio";
                break;
            case 3:
                position = "Defesa";
                break;
            case 4:
                position = "Guarda-Redes";
                break;
            default:
                position = "Avançado";
                break;
        }
        int tem = random.nextInt(0, Equipas.equipaList.size());
        String team = Equipas.equipaList.get(tem).getName();
        int anger = random.nextInt(100);
        int titulos = random.nextInt(100);
        int ataque = random.nextInt(100);
        int defesa = random.nextInt(100);
        new Jogadores (position, team, ataque, defesa, anger, titulos, tem);
    }

    public static void allData() {
        for (Jogadores jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    public static void Data(String player) {
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getNome().equals(player)) {
                System.out.println(jogadores.get(i));
                break;
            }
            else if(i == jogadores.size() - 1) {
                System.out.println("Jogador não encontrado!");
            }
        }
    }

    private int StatsSetter(int stats) {
        if (stats < 100)
            return stats;
        else {
            System.out.println("O valor de stats não pode ser maior que 100!");
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Posição: " + posicao + " | Equipa: " + equipa + " | Ataque: " + statAt + " | Defesa: " + statDef + " | Nivel de Agressividade: " + angerLevel + " | Titulos: " + titulos;
    }
}

