/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author hontman
 */
public class Arbitros extends Pessoa{

    private final int carreira, profissionalismo;

    public static ArrayList<Arbitros> arbitros = new ArrayList<Arbitros>(5);
    public Arbitros(){
        super();
        this.carreira = random.nextInt(5,20);
        this.profissionalismo = random.nextInt(1,100);
        arbitros.add(this);
    }
    public Arbitros(String nome, int idade,int carreira, int profissionalismo){
        super(nome, idade);
        this.carreira = carreira;
        this.profissionalismo = profissionalismo;
        arbitros.add(this);
    }
    public static void imprime(String Arbitros){
        for(Arbitros arbitros : arbitros) {
            if(arbitros.getNome().equals(Arbitros)) {
                System.out.println(arbitros);
                break;
            }
        }
    }

    public int getExperiencia(){
        return ((carreira + profissionalismo) / 2);
    }

    public static Arbitros getArbitro(String nome){
        for (Arbitros arbitro : arbitros) {
            if (arbitro.getNome().equals(nome)) {
                return arbitro;
            }
        }
        return null;
    }

    public static void writer() throws IOException {
        FileWriter fw = new FileWriter("arbitros.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(arbitros.size());
        for (int i = 0; i < arbitros.size(); i++){
            out.println(arbitros.get(i).getNome() + " ; " + arbitros.get(i).getIdade() + " ; " + arbitros.get(i).carreira + " ; " + arbitros.get(i).profissionalismo);
        }
        out.close();
    }

    public static void reader() throws IOException{
        FileReader fr = new FileReader("arbitros.txt");
        BufferedReader br = new BufferedReader(fr);
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] jogador = br.readLine().split(" ; ");
            String nome = jogador[0];
            int idade = Integer.parseInt(jogador[1]);
            int carreira = Integer.parseInt(jogador[2]);
            int profissionalismo = Integer.parseInt(jogador[3]);
            new Arbitros(nome, idade, carreira, profissionalismo);
        }
    }
    @Override
    public String toString (){
        return super.toString() + "| Carreira: " + carreira + " | Profissionalismo: " + profissionalismo;
    }
}