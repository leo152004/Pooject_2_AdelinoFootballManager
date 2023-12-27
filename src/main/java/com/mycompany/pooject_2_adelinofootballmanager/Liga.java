/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pooject_2_adelinofootballmanager;

/**
 *
 * @author leand
 */
import java.io.*;
import java.util.ArrayList;

public interface Liga {
    String getLigaNome();

    String getNome();
    String imprime();

    void mudarLigaMini();

    String printable();
    int getSize();
}
