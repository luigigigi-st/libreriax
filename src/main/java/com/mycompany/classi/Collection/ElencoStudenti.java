/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.Collection;

import classi.obj.Studente;
import java.util.ArrayList;

public class ElencoStudenti extends Elenco<Studente> {

    public ElencoStudenti() {
        super();
    }

    public ElencoStudenti(ArrayList<Studente> lista) {
        super(lista);
    }

    /**
     * restituisce la pos di uno studente data il numero di matricola
     *
     * @param num numero di matricola dello studente da cercare
     * @return pos dello studente.-1 se non è preente nell'elenco
     */
    public int getPos(int num) {
        ArrayList<Studente> l = (ArrayList<Studente>) this.lista;

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getMatricola() == num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * restituisce la pos di uno studente data il numero di matricola
     *
     * @param s
     * @return pos dello studente.-1 se non è preente nell'elenco
     */
    public int getPos(Studente s) {
        ArrayList<Studente> l = (ArrayList<Studente>) this.lista;

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * verifica se è presente qualkche studente che svolge il corso passato
     *
     * @param corso coso da verificare la presenza
     * @return true se è prsene,false se no
     */
    public boolean contains(String corso) {
        ArrayList<Studente> l = (ArrayList<Studente>) this.lista;
        for (Studente s : l) {
            if (s.getCoroso().equalsIgnoreCase(corso)) {
                return true;
            }

        }

        return false;

    }

    public ArrayList<Studente> getStudentiFromCorso(String corso) {
        ArrayList<Studente> l = (ArrayList<Studente>) this.lista;

        ArrayList<Studente> l1 = new ArrayList();
        for (Studente s : l) {
            if (s.getCoroso().equalsIgnoreCase(corso)) {
                l1.add(s);
            }
        }

        return l1;

    }
    
    @Override
    public String toString(){return this.lista.toString();}

}
