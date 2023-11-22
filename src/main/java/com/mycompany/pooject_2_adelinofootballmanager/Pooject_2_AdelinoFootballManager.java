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
        Ligas ligaPT = new Ligas("Portuguesa");
        Ligas ligaAL = new Ligas("Alema");
        Ligas ligaES = new Ligas("Espanhola");
    }

    public static void main(String[] args) {
        starter();
        Menu menu = new Menu();
        menu.theMenu();
    }
}
