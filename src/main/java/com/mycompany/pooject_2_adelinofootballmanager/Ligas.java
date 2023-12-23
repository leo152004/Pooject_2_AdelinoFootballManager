/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

/**
 *
 * @author hontman
 */
import java.io.*;
import java.util.ArrayList;

public class Ligas implements Ficheiros{
    private final String Name;
    public static ArrayList<Equipas> LigaEquipas = new ArrayList<Equipas>(9);
    public static ArrayList<Ligas> AllLigas = new ArrayList<Ligas>(3);
    public Ligas(String Liga) {
        this.Name = Liga;
        equipas(Liga);
        AllLigas.add(this);
    }

    public Ligas(String Liga, ArrayList<Equipas> equipas) {
        this.Name = Liga;
        equipas(Liga);
        LigaEquipas.addAll(equipas);
        AllLigas.add(this);
    }

    public static Ligas getLiga(int liga){
        return AllLigas.get(liga);
    }
    public String getLigaName(){
        return Name;
    }
    public String getName() {
        return Name;
    }

    public static void imprime(String Liga) {
        String info = "Liga: " + Liga  + "\nEquipas:\n";
        for (int i = 0; i < Equipas.numberEquipas(); i++) {
            if (Equipas.getEquipaLiga(i).equals(Liga)) {
                info += Equipas.getFullEquipa(i);
            }
        }
        System.out.println(info);
    }

    public static Ligas getLiga(String liga){
        for (int i = 0; i < 3; i++){
            if(AllLigas.get(i).Name.equals(liga)){
                return AllLigas.get(i);
            }
        }
        return null;
    }
    public static void setLigatoEquipa(int liga, int equipa){
        LigaEquipas.remove(equipa);
        Equipas eq = new Equipas(Equipas.getEquipaName(equipa),Treinador.autoTraining(equipa),AllLigas.get(liga).getLigaName() ,Equipas.getCidade(equipa));
        LigaEquipas.add(eq);

    }

    private void equipas(String Liga) {
        switch (Liga) {
            case "Portuguesa" -> {
                Equipas PT1 = new Equipas("SL Benfica", Treinador.autoTraining(0), "Portuguesa","Lisboa");
                LigaEquipas.add(PT1);
                Equipas PT2 = new Equipas("FC Porto", Treinador.autoTraining(1), "Portuguesa", "Porto");
                LigaEquipas.add(PT2);
                Equipas PT3 = new Equipas("Sporting SP", Treinador.autoTraining(2), "Portuguesa","Lisboa");
                LigaEquipas.add(PT3);
            }
            case "Alema" -> {
                Equipas AL1 = new Equipas("Barussia Dormund", Treinador.autoTraining(3), "Alema","Dortmund");
                LigaEquipas.add(AL1);
                Equipas AL2 = new Equipas("Adelino FC", Treinador.autoTraining(4), "Alema","Sömmerd");
                LigaEquipas.add(AL2);
                Equipas AL3 = new Equipas("Leipzig", Treinador.autoTraining(5), "Alema","lipzia");
                LigaEquipas.add(AL3);
            }
            case "Espanhola" -> {
                Equipas ES1 = new Equipas("Real Madrid", Treinador.autoTraining(6), "Espanhola", "Madrid");
                LigaEquipas.add(ES1);
                Equipas ES2 = new Equipas("Barcelona", Treinador.autoTraining(7), "Espanhola","Barcelona");
                LigaEquipas.add(ES2);
                Equipas ES3 = new Equipas("Atlético de Madrid", Treinador.autoTraining(8), "Espanhola","Madrid");
                LigaEquipas.add(ES3);
            }
        }
    }

    public static void writer() throws IOException {
        FileWriter fw = new FileWriter("ligas.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        for (int i = 0; i < 3; i++){
            out.println(AllLigas.get(i).Name);
            out.println(LigaEquipas.size());
            for (Equipas ligaEquipa : LigaEquipas) {
                out.println(ligaEquipa.getName());
            }
        }
    }

    public static void reader() throws IOException{
        FileReader fr = new FileReader("ligas.txt");
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 3; i++) {
            String nome = br.readLine();
            int size = Integer.parseInt(br.readLine());
            ArrayList<Equipas> equipas = new ArrayList<Equipas>(size);
            for(int j = 0; j < size; j++){
                equipas.add(Equipas.getFullEquipa(br.readLine()));
            }
            new Ligas(nome, equipas);
        }
    }
}
