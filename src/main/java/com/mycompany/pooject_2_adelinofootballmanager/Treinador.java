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
    private final String especializacao, taticasFavo, equipa;

    public Treinador(String nome, int idade, String especializacao, String taticasFavo, String equipa) {
        super(nome, idade);
        this.especializacao = especializacao;
        this.taticasFavo = taticasFavo;
        this.equipa = equipa;
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
        return super.toString() + " | Especialização: " + especializacao + " | Táticas Favoritas: " + taticasFavo + " | Equipa: " + equipa;
    }

    private static String escolheEquipa() {
            System.out.println("Selecione a equipa do novo Treinador:");
            for(int i = 0; i < Equipas.equipaList.size(); i++) {
                System.out.println(i+1 + ". " + Equipas.equipaList.get(i).getName());
            }

            int EquipaID = scan.nextInt();

            return Equipas.equipaList.get(EquipaID-1).getName();
    }

    public static void inserirTreinador() {
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
        String equipa = escolheEquipa();
        try {
            new Treinador(name, age, especializacao, taticasFavo, equipa);
        }
        catch (Exception e) {
            System.out.println("Por favor, insira valores validos!");
            inserirTreinador();
        }
    }
}
