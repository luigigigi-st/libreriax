/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.Collection;

import classi.obj.Contatto;
import java.util.ArrayList;

public class Rubrica extends Elenco {

    public Rubrica() {
        super();
    }

    public Rubrica(ArrayList<Contatto> lista) {
        super(lista);
    }

    /**
     * restituisce il numero del contatto dato il nome
     *
     * @param nome nome del contatto da trovare
     * @return returna il num di tel dato il nome del contatto.return -1 nel
     * casdo non lo trovasse
     */
    public long getNumTelByName(String nome) {

        //ciclo la lista e returno il num uando trovo il nome
        for (Contatto c : (ArrayList<Contatto>)this.lista) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c.getNumero(); // return
            }
        }

        return -1; //nel caso non ci fosse reutrno -1

    }

}

