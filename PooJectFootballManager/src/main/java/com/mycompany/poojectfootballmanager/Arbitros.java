/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poojectfootballmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class Arbitros extends Pessoa {
    static ArrayList<Arbitros> arbitros = new ArrayList<Arbitros>(5);

    static Scanner scan = new Scanner(System.in);
    private final int carreira, profissionalismo;
    public Arbitros(){
        super();
        this.carreira = random.nextInt(5,20);
        this.profissionalismo = random.nextInt(1,100);
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
    @Override
    public String toString (){
        return super.toString() + "| Carreira: " + carreira + " | Profissionalismo: " + profissionalismo;
    }
}
