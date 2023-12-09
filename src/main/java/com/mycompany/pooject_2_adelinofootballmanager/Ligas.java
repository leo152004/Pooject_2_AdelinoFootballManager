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
import java.util.Objects;

public class Ligas {
    private final String Name;
    private int pontos;
    static ArrayList<Equipas> LigaEquipas = new ArrayList<Equipas>(9);
    static ArrayList<Ligas> AllLigas = new ArrayList<Ligas>(3);
    public Ligas(String Liga) {
        this.Name = Liga;
        equipas(Liga);
        AllLigas.add(this);
    }

    public static void imprime(String Liga) {
        String info = "Liga: " + Liga  + "\nPontos:" + getLiga(Liga).getPontos() + "\nEquipas:\n";
        for (int i = 0; i < Equipas.numberEquipas(); i++) {
            if (Equipas.getEquipaLiga(i).equals(Liga)) {
                info += Equipas.getFullEquipa(i);
            }
        }
        System.out.println(info);
    }

    public void setPontos(){
        pontos++;
    }

    public int getPontos(){
        return pontos;
    }

    public static Ligas getLiga(String liga){
        for (int i = 0; i < 3; i++){
            if(AllLigas.get(i).Name.equals(liga)){
                return AllLigas.get(i);
            }
        }
        return null;
    }

    private void equipas(String Liga) {
        switch (Liga) {
            case "Portuguesa" -> {
                Equipas PT1 = new Equipas("SL Benfica", Treinador.autoTraining(0), "pt");
                LigaEquipas.add(PT1);
                Equipas PT2 = new Equipas("FC Porto", Treinador.autoTraining(1), "pt");
                LigaEquipas.add(PT2);
                Equipas PT3 = new Equipas("Sporting SP", Treinador.autoTraining(2), "pt");
                LigaEquipas.add(PT3);
            }
            case "Alema" -> {
                Equipas AL1 = new Equipas("Barussia Dormund", Treinador.autoTraining(3), "al");
                LigaEquipas.add(AL1);
                Equipas AL2 = new Equipas("Adelino FC", Treinador.autoTraining(4), "al");
                LigaEquipas.add(AL2);
                Equipas AL3 = new Equipas("Leipzig", Treinador.autoTraining(5), "al");
                LigaEquipas.add(AL3);
            }
            case "Espanhola" -> {
                Equipas ES1 = new Equipas("Real Madrid", Treinador.autoTraining(6), "es");
                LigaEquipas.add(ES1);
                Equipas ES2 = new Equipas("Barcelona", Treinador.autoTraining(7), "es");
                LigaEquipas.add(ES2);
                Equipas ES3 = new Equipas("Atlético de Madrid", Treinador.autoTraining(8), "es");
                LigaEquipas.add(ES3);
            }
        }
    }
}
