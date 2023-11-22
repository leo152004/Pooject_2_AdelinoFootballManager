/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hontman
 */
public class Arbitros extends Pessoa{
    static ArrayList<Arbitros> arbitros = new ArrayList<Arbitros>(5);

    static Scanner scan = new Scanner(System.in);
    private int carreira, profissionalismo;
    public Arbitros(String nome, int idade, int carreira, int profissionalismo){
        super(nome,idade);
        this.carreira = carreira;
        this.profissionalismo = profissionalismo;
    }
    public int getCarreira(){return this.carreira;}
    public int getProfissionalismo(){return this.profissionalismo;}

    public void setCarreita(int carreira){this.carreira = carreira;}
    public void setProfissionalismo(int profissionalismo){this.profissionalismo = profissionalismo;}

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
