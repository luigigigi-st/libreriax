/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package classi.obj;

import java.io.Serializable;

 /*
Esercizio 1: La classe Giocatore


La classe Giocatore deve contenere:nome,se è capitano o no,quanti gol ha fatto,gol nazionali
crea poi 2 costruttori.crea poi 10 metodo: getter e setter di tutte le variabili,calcolo dei gol totli 
(tra quelli normali e fatti in nazionale) e stamap di tutti i dati del giocatore usanodo toString().


Infine, creare un secondo file TestGiocatore.java  dove poter creare i seguenti tre oggetti di tipo Giocatore:
l'oggetto totti, creato con il costruttore di default ed i valori assegnati grazie ai metodi set;
l'oggetto zanetti, creato con il costruttore personalizzato;
l'oggetto delPiero, creato con il costruttore di default ed i cui valori devono essere inseriti tramite la tastiera
 */
public class Giocatore implements Serializable {

    //caratterustiche
    private String nome;
    private boolean capitano;
    private int gol, golNazionali;

    public Giocatore() {

        this.nome = "";
        this.capitano = false;
        this.gol = 0;
        this.golNazionali = 0;

    }

    public Giocatore(String nome, boolean capitano, int gol, int golNazionali) {

        this.nome = nome;
        this.capitano = capitano;
        this.gol = gol;
        this.golNazionali = golNazionali;

    }

    //getter e setter
    public String getNome() {
        return this.nome;
    }

    public boolean getPosizione() {
        return this.capitano;
    }

    public int getGol() {
        return this.gol;
    }

    public int getGolNazionali() {
        return this.golNazionali;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosizione(boolean capitano) {
        this.capitano = capitano;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public void setGolNazionali(int golNazionali) {
        this.golNazionali = golNazionali;
    }

    //toString();
    public String toString() {
        if (this.capitano) {
            return "nome del giocatore:" + this.nome + "\nstato:capitano\ngol:" + this.gol + "\ngol in nazionale:" + this.golNazionali;
        } else {
            return "nome del giocatore:" + this.nome + "\nstato:non capitano\ngol:" + this.gol + "\ngol in nazionale:" + this.golNazionali;
        }
    }

    public int getGolTotali() {
        return this.gol + this.golNazionali;
    }

}
