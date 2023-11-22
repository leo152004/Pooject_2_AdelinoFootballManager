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
public class Ligas {
    private final String Name;
    static ArrayList<Equipas> LigaEquipas = new ArrayList<Equipas>(3);
    public Ligas(String Liga) {
        this.Name = Liga;
        equipas(Liga);
    }

    public static void imprime(String Liga) {
        String info = "Liga: " + Liga + "\n" + "Equipas:\nNome        Vitórias Empates Derrotas Pontos";
        for(int i = 0; i < LigaEquipas.size(); i++){
            info += LigaEquipas.get(i).getName() + " " + LigaEquipas.get(i).getVitorias() + "       " + LigaEquipas.get(i).getEmpates() + "        " + LigaEquipas.get(i).getDerrotas() + "     "
                    + LigaEquipas.get(i).getPontos() + "\n";
        }
    }
    private void equipas(String Liga) {
        if(Name == "Portuguesa"){
            Equipas PT1 = new Equipas("SL Benfica");
            LigaEquipas.add(PT1);
            Equipas PT2 = new Equipas("FC Porto");
            LigaEquipas.add(PT2);
            Equipas PT3 = new Equipas("Sporting SP");
            LigaEquipas.add(PT3);
        }if(Name == "Alema"){
            Equipas AL1 = new Equipas("Barussia Dormund");
            LigaEquipas.add(AL1);
            Equipas AL2 = new Equipas("Adelino FC");
            LigaEquipas.add(AL2);
            Equipas AL3 = new Equipas("Leipzig");
            LigaEquipas.add(AL3);
        }if(Name == "Espanhola"){
            Equipas ES1 = new Equipas("Real Madrid");
            LigaEquipas.add(ES1);
            Equipas ES2 = new Equipas("Barcelona");
            LigaEquipas.add(ES2);
            Equipas ES3 = new Equipas("Atlético de Madrid");
            LigaEquipas.add(ES3);
        }
    }
}
