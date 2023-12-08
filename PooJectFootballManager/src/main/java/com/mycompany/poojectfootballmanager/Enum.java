/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poojectfootballmanager;

import java.util.Random;

/**
 *
 * @author hontman
 */
public enum Enum {
    braco, perna, tronco, cabeca;

    private static final Random rand = new Random();

    public static String getRandomWound() {
        Enum[] wound = values();
        int randWound = rand.nextInt(wound.length);
        return wound[randWound].toString();
    }
}
