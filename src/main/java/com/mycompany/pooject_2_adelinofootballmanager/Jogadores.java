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
    public static final ArrayList<Jogadores> jogadores = new ArrayList<>(99);
    private final String posicao;
    private ArrayList<String> lesoes = new ArrayList<>();
    private final int statAt, statDef, angerLevel, titulos, nEquipa;

    public static Scanner scan = new Scanner(System.in);
//    Random rand = new Random();


//Construtores
    public Jogadores(String position, int ataque, int defesa, int anger, int titulos, int nEquipa) {
        super();
        this.posicao = position;
        this.nEquipa = nEquipa;
        this.statAt = ataque;
        this.statDef = defesa;
        this.angerLevel = anger;
        this.titulos = titulos;
        jogadores.add(this);
        Equipas.addToEquipa(nEquipa, this);
    }

    public Jogadores(String nome, int idade, String posicao, int ataque, int defesa, int angerLevel, int titulos, int nEquipa) {
        super(nome, idade);
        this.posicao = posicao;
        this.nEquipa = nEquipa;
        this.statAt = StatsSetter(ataque, "ataque");
        this.statDef = StatsSetter(defesa, "defesa");
        this.angerLevel = angerLevel;
        this.titulos = titulos;
        jogadores.add(this);
        Equipas.addToEquipa(nEquipa - 1, this);
    }

    private static String givenChoiceP() {
        System.out.println("Selecione a posição do jogador:");
        System.out.println("1.Avançado");
        System.out.println("2.Medio");
        System.out.println("3.Defesa");
        System.out.println("4.Guarda-Redes");

        int position = scan.nextInt();

        return switch (position) {
            case 1 -> "Avançado    ";
            case 2 -> "Medio       ";
            case 3 -> "Defesa      ";
            case 4 -> "Guarda-Redes";
            default -> {
                System.out.println("Opção inválida!");
                yield givenChoiceP();
            }
        };
    }
    private static int givenChoiceT() {
            System.out.println("Selecione a equipa do jogador:");
            for(int i = 0; i < Equipas.numberEquipas(); i++) {
                System.out.println(i+1 + ". " + Equipas.getEquipaName(i));
            }

        return scan.nextInt() - 1;
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
            new Jogadores(name, age, position, ataque, defesa, anger, titulos, whatTeam);
        }
        catch (Exception e) {
            System.out.println("Por favor, insira valores validos!");
            inserirJogador();
        }
    }

    public static void inserirJogador(int team) {
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
        int whatTeam = team;
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
            new Jogadores(name, age, position, ataque, defesa, anger, titulos, whatTeam);
        }
        catch (Exception e) {
            System.out.println("Por favor, insira valores validos!");
            inserirJogador();
        }
    }

    public static void autoPlayer() {
        int posi = random.nextInt(1, 4);
        String position = switch (posi) {
            case 2 -> "Medio";
            case 3 -> "Defesa";
            case 4 -> "Guarda-Redes";
            default -> "Avançado";
        };
        int tem = random.nextInt(Equipas.numberEquipas() - 1);
        while (Equipas.getMinEquipaSize() < 9){
            tem = random.nextInt(Equipas.numberEquipas() - 1);
            if (Equipas.getEquipaSize(tem) < 9){
                break;
            }
        }
        int anger = random.nextInt(100);
        int titulos = random.nextInt(50);
        int ataque;
        int defesa;
        switch (position) {
            case "Avançado" -> {
                ataque = random.nextInt(50, 100);
                defesa = random.nextInt(20, 50);
            }
            case "Defesa" -> {
                defesa = random.nextInt(50, 100);
                ataque = random.nextInt(20, 50);
            }
            case "Medio" -> {
                ataque = random.nextInt(50, 100);
                defesa = random.nextInt(50, 100);
            }
            default -> {
                ataque = random.nextInt(20);
                defesa = random.nextInt(70, 100);
            }
        }
        new Jogadores (position, ataque, defesa, anger, titulos, tem);
    }

    public static void autoPlayer(int team) {
        int posi = random.nextInt(1, 4);
        String position = switch (posi) {
            case 2 -> "Medio";
            case 3 -> "Defesa";
            case 4 -> "Guarda-Redes";
            default -> "Avançado";
        };
        int anger = random.nextInt(100);
        int titulos = random.nextInt(50);
        int ataque;
        int defesa;
        switch (position) {
            case "Avançado" -> {
                ataque = random.nextInt(50, 100);
                defesa = random.nextInt(20, 50);
            }
            case "Defesa" -> {
                defesa = random.nextInt(50, 100);
                ataque = random.nextInt(20, 50);
            }
            case "Medio" -> {
                ataque = random.nextInt(50, 100);
                defesa = random.nextInt(50, 100);
            }
            default -> {
                ataque = random.nextInt(20);
                defesa = random.nextInt(70, 100);
            }
        }
        new Jogadores (position, ataque, defesa, anger, titulos, team);
    }

    public static void allData() {
        for (Jogadores jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    public static void Data(String player) {
        player = player.toLowerCase();
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getNome().toLowerCase().equals(player)) {
                System.out.println(jogadores.get(i));
                break;
            }
            else if(i == jogadores.size() - 1) {
                System.out.println("Jogador não encontrado!");
            }
        }
    }

    public void painMaker() {
        String wound = Enum.getRandomWound();
        this.lesoes.add(wound);
    }

    private int StatsSetter(int stats, String stat) {
        if (stats <= 100)
            return stats;
        else if (stats > 100) {
            System.out.println("O valor de " + stat + " não pode ser maior que 100!");
            return 100;
        }
        else {
            System.out.println("O valor de " + stat + " não pode ser menor que 0!");
            return 0;
        }
    }

    public int getAnger(){
        return angerLevel;
    }

    public int getEquipa(){
        return nEquipa;
    }

    @Override
    public String toString() {
        return super.toString() +"| Posição: " + posicao + " | Equipa: " + Equipas.getEquipaName(nEquipa) + " | Ataque: " + statAt + " | Defesa: " + statDef + " | Nivel de Agressividade: " + angerLevel + " | Titulos: " + titulos;
    }

    public String toString(boolean file){
        String text = getNome() + " | " + getIdade() + " | " + posicao + " | " + statAt + " | " + statDef + " | " + angerLevel + " | " + titulos + " | " + nEquipa + " | ";
        for (int i = 0; i < lesoes.size(); i++)
            text += " | " + lesoes;
        return text;
    }
}

