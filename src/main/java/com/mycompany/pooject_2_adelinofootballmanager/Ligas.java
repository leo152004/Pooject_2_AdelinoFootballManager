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
    static ArrayList<Equipas> LigaEquipas = new ArrayList<Equipas>(3);
    public Ligas(String Liga) {
        this.Name = Liga;
        equipas(Liga);
    }

    public static void imprime(String Liga) {
        String info = "Liga: " + Liga + "\nEquipas:\n";
        for (int i = 0; i < Equipas.numberEquipas(); i++) {
            if (Equipas.getEquipaLiga(i).equals(Liga)) {
                info += Equipas.getFullEquipa(i);
            }
        }
        System.out.println(info);
    }
    private void equipas(String Liga) {
        if(Liga.equals("Portuguesa")){
            Equipas PT1 = new Equipas("SL Benfica", Treinador.autoTraining(0), "pt");
            LigaEquipas.add(PT1);
            Equipas PT2 = new Equipas("FC Porto", Treinador.autoTraining(1), "pt");
            LigaEquipas.add(PT2);
            Equipas PT3 = new Equipas("Sporting SP", Treinador.autoTraining(2), "pt");
            LigaEquipas.add(PT3);
        }else if(Liga.equals("Alema")){
            Equipas AL1 = new Equipas("Barussia Dormund", Treinador.autoTraining(3), "al");
            LigaEquipas.add(AL1);
            Equipas AL2 = new Equipas("Adelino FC", Treinador.autoTraining(4), "al");
            LigaEquipas.add(AL2);
            Equipas AL3 = new Equipas("Leipzig", Treinador.autoTraining(5), "al");
            LigaEquipas.add(AL3);
        }else if(Liga.equals("Espanhola")){
            Equipas ES1 = new Equipas("Real Madrid", Treinador.autoTraining(6), "es");
            LigaEquipas.add(ES1);
            Equipas ES2 = new Equipas("Barcelona", Treinador.autoTraining(7), "es");
            LigaEquipas.add(ES2);
            Equipas ES3 = new Equipas("Atlético de Madrid", Treinador.autoTraining(8), "es");
            LigaEquipas.add(ES3);
        }
    }
}
