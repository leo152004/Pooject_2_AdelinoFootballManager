/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pooject_2_adelinofootballmanager;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author hontman
 */
public class Pooject_2_AdelinoFootballManager {
    private static void starter() {
        new Ligas("Portuguesa");
        new Ligas("Alema");
        new Ligas("Espanhola");
        for(int i = 0; i <= 81; i++)
            Jogadores.autoPlayer();
        for (int i = 0; i <= 5; i++)
            new Arbitros();
    }

    private static void fileChecker() throws IOException {
        File play = new File("jogadores.txt");
        boolean BPlay = play.exists() && !play.isDirectory();
        File team = new File("equipas.txt");
        boolean BTeam = team.exists() && !team.isDirectory();
        File league = new File("ligas.txt");
        boolean BLeague = league.exists() && !league.isDirectory();
        File trainer = new File("treinadores.txt");
        boolean BTrainer = trainer.exists() && !trainer.isDirectory();
        File arbitos = new File("arbitros.txt");
        boolean BArbitos = arbitos.exists() && !arbitos.isDirectory();
        if(!(BPlay && BTeam && BLeague && BTrainer)){
            starter();
        } else {
            Jogadores.reader();
            Ligas.reader();
            Treinador.reader();
            Equipas.reader();
            Arbitros.reader();
        }
    }

    public static void main(String[] args) throws IOException {
        fileChecker();
        Menu menu = new Menu();
        menu.theMenu();
    }
}

