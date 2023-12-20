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
public class Treinador extends Pessoa{

    static ArrayList<Treinador> treinadores = new ArrayList<Treinador>(9);

    static Scanner scan = new Scanner(System.in);
    private String especializacao;
    private String taticasFavo;
    private final int equipa;

    public Treinador(String nome, int idade, String especializacao, String taticasFavo, int equipa) {
        super(nome, idade);
        this.especializacao = especializacao;
        this.taticasFavo = taticasFavo;
        this.equipa = equipa;
        treinadores.add(this);
    }
    public Treinador(String especializacao, String taticasFavo, int equipa) {
        super();
        this.especializacao = especializacao;
        this.taticasFavo = taticasFavo;
        this.equipa = equipa;
        treinadores.add(this);
    }

    public static void imprime(String Treinador) {
        for(Treinador treinador : treinadores) {
            if(treinador.getNome().equals(Treinador)) {
                System.out.println(treinador);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialização: " + especializacao + " | Táticas Favoritas: " + taticasFavo + " | Equipa: " + Equipas.getEquipaName(equipa);
    }

    private static int escolheEquipa() {
            System.out.println("Selecione a equipa do novo Treinador:");
            for(int i = 0; i < Equipas.numberEquipas(); i++) {
                System.out.println(i+1 + ". " + Equipas.getEquipaName(i));
            }

            int EquipaID = scan.nextInt();

            return EquipaID-1;
    }

    public static Treinador inserirTreinador() {
        System.out.println("Insira o nome do treinador: ");
        String name = scan.nextLine();
        System.out.println("Insira a idade do treinador: ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.println("Insira a especialização do treinador: ");
        String especializacao = scan.nextLine();
        System.out.println("Insira a tatica favorita do treinador: ");
        String taticasFavo = scan.nextLine();
        System.out.println("Insira a equipa do treinador: ");
        int equipa = escolheEquipa();
        try {
            return new Treinador(name, age, especializacao, taticasFavo, equipa);
        }
        catch (Exception e) {
            System.out.println("Por favor, insira valores validos!");
            inserirTreinador();
        }
        return null;
    }

    public static Treinador autoTraining(int Team) {
        return new Treinador(especializacao(), taticas(), Team);
    }

    public String getEspecializacao() {
        return especializacao;
    }
    public void setEspecializacao(String especializacao){
        this.especializacao = especializacao;
    }

    public static String especializacao(){
        String[] especializacoes = {"Licença A: Federação Portuguesa de Futebol (FPF)", "Mestrado em Treino Desportivo: Especialização em Futebol", "Cursos de Futebol","Licença B: Federação Portuguesa de Futebol (FPF)"};
        String text = "";
        for(Treinador t : treinadores){
            t.setEspecializacao(especializacoes[random.nextInt(especializacoes.length)]);
            text = t.getEspecializacao();
        }
        return text;

    }

    public String getTaticasFavo() {
        return taticasFavo;
    }
    public void setTaticasFavo(String taticasFavo){
        this.taticasFavo = taticasFavo;
    }

    public static String taticas(){
        String[] taticas = {"4-3-3","4-4-2","4-5-1","3-5-2","4-3-2-1","4-2-3-1","4-2-4","5-3-2"};
        String text = "";
        for(Treinador t : treinadores){
            t.setTaticasFavo(taticas[random.nextInt(taticas.length)]);
            text = t.getTaticasFavo();
        }
        return text;

    }

}
