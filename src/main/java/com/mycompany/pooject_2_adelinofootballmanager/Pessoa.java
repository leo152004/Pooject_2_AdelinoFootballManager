/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooject_2_adelinofootballmanager;
/**
 *
 * @author hontman
 */
import com.github.javafaker.Faker;

import java.util.Random;

public class Pessoa {
    private final String nome;
    private final int idade;
    Faker faker = new Faker();

    static Random random = new Random();
    public Pessoa() {
        this.nome = faker.name().fullName();
        this.idade = random.nextInt(20,40);
    }

    public String autoName(){
        return faker.name().fullName();
    }
    public String getNome() {
        return nome;
    }
    public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + " | Idade: " + idade;
    }
}
