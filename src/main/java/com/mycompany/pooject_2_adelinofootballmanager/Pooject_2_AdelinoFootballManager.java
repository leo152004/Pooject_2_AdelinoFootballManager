/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pooject_2_adelinofootballmanager;

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

    public static void main(String[] args) {
        starter();
        Menu menu = new Menu();
        menu.theMenu();
    }
}

