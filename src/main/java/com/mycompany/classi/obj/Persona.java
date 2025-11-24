/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.obj;

/*
Creare una classe per gestire i dati di una persona:
nome, cognome, cf, dataNascita, peso, altezza

La classe deve restituire
- età
- nome e cognome concatenati
- se è maggiorenne

Per una persona nel corso della vita possono variare peso ed altezza.
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Persona implements Serializable {

    protected String nome;
    protected String cognome;
    protected String cf;
    protected LocalDate dataNascita;
    protected double peso;
    protected double altezza;
    protected int id;

    public Persona() {
        id = 0;
        nome = "";
        cognome = "";
        cf = "";
        dataNascita = LocalDate.now();
        peso = 1;
        altezza = 1;
    }

    public Persona(String cf) {
        id = 0;
        nome = "";
        cognome = "";
        this.cf = cf;
        dataNascita = LocalDate.now();
        peso = 1;
        altezza = 1;
    }

    public Persona(int id) {
        this.id = id;
        nome = "";
        cognome = "";
        this.cf = "";
        dataNascita = LocalDate.now();
        peso = 1;
        altezza = 1;
    }

    public Persona(int id, String cf) {
        this.id = id;
        nome = "";
        cognome = "";
        this.cf = cf;
        dataNascita = LocalDate.now();
        peso = 1;
        altezza = 1;
    }

    public Persona(String cf, String nome) {
        this.nome = nome;
        cognome = "";
        this.cf = cf;
        dataNascita = LocalDate.now();
        peso = 1;
        altezza = 1;
    }

    public Persona(String cf, String cognome, String nome) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        dataNascita = LocalDate.now();
        peso = 1;
        altezza = 1;
    }

    public Persona(String cf, String cognome, String nome, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dataNascita = dataNascita;
        //LocalDate.of(LocalDate.now().getYear() - 18, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        peso = 1;
        altezza = 1;

    }

    public Persona(String cf, String nome, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = "";
        this.cf = cf;
        this.dataNascita = dataNascita;
        //LocalDate.of(LocalDate.now().getYear() - 18, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        peso = 1;
        altezza = 1;

    }

    public Persona(String cf, String cognome, String nome, LocalDate dataNascita, double altezza) {

        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dataNascita = dataNascita;
        //LocalDate.of(LocalDate.now().getYear() - 18, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        peso = 1;
        this.altezza = altezza;

    }

    public Persona(String cf, String cognome, String nome, LocalDate dataNascita, double altezza, double peso) {
        this.id = 0;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dataNascita = dataNascita;
        this.peso = peso;
        this.altezza = altezza;
    }

    public Persona(int id, String cf, String cognome, String nome, LocalDate dataNascita, double altezza, double peso) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dataNascita = dataNascita;
        this.peso = peso;
        this.altezza = altezza;
    }
    
        public Persona(int id, String cf, String cognome, String nome, LocalDate dataNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dataNascita = dataNascita;
        peso = 1;
        altezza = 1;
    }


    //getter 
    public String getNome() {return this.nome;}
    public String getCognome() {return this.cognome;}
    public String getCodiceFiscale() {return this.cf;}
    public LocalDate getDataNascita() {return this.dataNascita;}
    public double getPeso() {return this.peso; }
    public double getAltezza() {return this.altezza;}
    public String getNomeAndCognome() {return "nome:" + this.nome + " cognome:" + this.cognome;}
    public String getNomeAndCognomeFormatted() {return this.nome + " " + this.cognome;}
    public int getId(){return id;}

    //setter
    public void setPeso(double peso) { this.peso = peso;}
    public void setAltezza(double altezza) {this.altezza = altezza;}
    public void setId(int id){this.id=id;}
    public void setCodiceFiscale(String cf){this.cf=cf;}
    public void setNome(String nome){this.nome=nome;}
    public void setCognome(String cognome){this.cognome=cognome;}
    protected void setDataNascita(LocalDate dataNascita){this.dataNascita=dataNascita;}
    public String getFormatDataNascita() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.dataNascita.format(formatter);
    }

    /**
     * restituisce l'età della persona.se la data di nascita è dopo di quella
     * attuale allora c'è qualquadra che non cosa
     *
     * @return età della persona.se dopo data attuale restituisce -1
     */
    public long getEtà() {
        LocalDate now = LocalDate.now();
        if (now.isAfter(this.dataNascita)) {
            /* if (this.dataNascita.getYear() == now.getYear()) {
                if (this.dataNascita.getMonthValue() == now.getMonthValue()) {
                    return ChronoUnit.DAYS.between(this.dataNascita, now);
                }
                return ChronoUnit.MONTHS.between(this.dataNascita, now);
            }*/
            return ChronoUnit.YEARS.between(this.dataNascita, now);
        } else {
            return -1;
        }

    }

    //altri metodi
    /**
     * verifica se la persona è maggiorenne
     *
     * @return true seè maggiorenne,false se non lo è
     */
    public boolean checkMaggioreEtà() {return getEtà() >= 18;}

    public Persona copy() {return new Persona(nome, cognome, cf, dataNascita, peso, altezza);}



    @Override
    public String toString() {
        return "nome:" + this.nome + "\ncognome:" + this.cognome + "\ncodice Fiscale:" + this.cf + "\ndata di nascita:" + getFormatDataNascita() + "\npeso:" + this.peso + "\naltezza:" + this.altezza;
    }

}
