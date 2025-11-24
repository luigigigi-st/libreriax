
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package classi.obj;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
 /*
Scrivere il codice di una classe "Strumento" che permetta di gestire tutte le informazioni 
relative a strumenti musicali venduti in un negozio. Le informazioni che interessano sono: 
categoria (chitarra, pianoforte, basso, ecc ecc…), marca, modello, elenco dei prezzi che lo strumento ha avuto nel tempo,
data di messa in vendita, se è usato o no. La classe deve avere due costruttori
 */
public class Strumenti implements Serializable{

    private String categoria, marca, modello;
    private ArrayList<Float> prezzi;
    private LocalDate data;
    private boolean nuovo;

    public Strumenti() {

        this.categoria = "";
        this.marca = "";
        this.modello = "";
        this.data=LocalDate.now();
        this.prezzi = new ArrayList();
        this.nuovo = true;

    }

    public Strumenti(String categoria, String marca, String modello, ArrayList<Float> prezzi, LocalDate data, boolean nuovo) {

        this.categoria = categoria;
        this.marca = marca;
        this.modello = modello;
        this.prezzi = prezzi;
        this.data = data;
        this.nuovo = nuovo;

    }

    /**
     * elenco dei prezzi
     * es.50,35,45,50.
     * @return stringa con i prezzi
     */
    public String elenco() {

        String stringa = "";
        for (int i = 0; i < prezzi.size(); i++) {
            if (i != prezzi.size() - 1) {
                stringa = prezzi.get(i) + ","; //se non è l'ultimo prezzo ci metto la virgola
            }else stringa = prezzi.get(i) + "."; //se è l'ultimo ci metto il punto
        }

        return stringa;

    }

    public String toString() {
        if (this.nuovo) {
            return "categoria:" + this.categoria + "\nmarca:" + this.marca + "\nmodello:" + this.modello + "\nprezzi:" + elenco() + "\nstato:nuovo";
        } else {
            return "categoria:" + this.categoria + "\nmarca:" + this.marca + "\nmodello:" + this.modello + "\nprezzi:" + elenco() + "\nstato:usato";
        }

    }

}
