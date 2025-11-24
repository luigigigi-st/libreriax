/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.utils;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Strings {

    /**
     * conta quante volte compare un carattere all'interno di una stringa
     *
     * @param stringa stringa inserita dall'utente
     * @param carattere carattere che deve essere contato nella stringa
     * @return numeoro di presenze
     */
    public static int contaCarattere(String stringa, char carattere) {
        int conta = 0;
        //conto
        for (int i = 0; i < stringa.length(); i++) {
            if (stringa.charAt(i) == carattere) {
                conta++;
            }
        }
        //return conta
        return conta;

    }

    /**
     * aggiorna il carattere di una stringa
     *
     * @param stringa stringa inserita dall'utente
     * @param carattere carrattere che deve essere sotituito
     * @param carattere1 catattere con cui viene sostituito il carattere
     * interessato
     * @return stringa con il carattere aggiornayo
     */
    public static String aggiornaCarattere(String stringa, char carattere, char carattere1) {
        //work utilizzando replace
        for (int i = 0; i < stringa.length(); i++) {
            if (stringa.charAt(i) == carattere) {
                stringa = stringa.replace(stringa.charAt(i), carattere1);

            }
        }
        return stringa;
    }

    /**
     * conta le vocali
     *
     * @param stringa stringa inserita
     * @return numero di vocali
     */
    public static int contaVocali(String stringa) {
        int conta = 0;
        //conto
        for (int i = 0; i < stringa.length(); i++) {
            if (Truth.checkVocale(stringa.charAt(i))) {
                conta++;

            }
        }
        //return
        return conta;
    }

    /**
     * conta le vocali
     *
     * @param stringa stringa inserita
     * @return numero di vocali
     */
    public static int contaConsonanti(String stringa) {
        int conta = 0;
        //conto
        for (int i = 0; i < stringa.length(); i++) {
            if (Truth.checkConsonante(stringa.charAt(i))) {
                conta++;

            }
        }
        //return
        return conta;
    }

    /**
     * conta le minuscole
     *
     * @param stringa stringa inserita
     * @return numero di minuscole
     */
    public static int contaMinuscole(String stringa) {
        int conta = 0;
        //conto
        for (int i = 0; i < stringa.length(); i++) {
            if (stringa.charAt(i) >= 97 && stringa.charAt(i) <= 122) {
                conta++;
            }
        }
        /*return*/
        return conta;
    }

    /**
     * conta le maisucole
     *
     * @param stringa stringa inserita
     * @return numero di minuscole
     */
    public static int contaMaiuscole(String stringa) {
        //conto
        int conta = 0;
        for (int i = 0; i < stringa.length(); i++) {
            if (stringa.charAt(i) >= 97 - 32 && stringa.charAt(i) <= 122 - 32) {
                conta++;
            }
        }

        /*return*/
        return conta;
    }

    /**
     * conta le cifre
     *
     * @param stringa stringa inserita
     * @return numero di cifre
     */
    public static int contaCifre(String stringa) {
        //conto
        int conta = 0;
        for (int i = 0; i < stringa.length(); i++) {
            if (Character.isDigit(stringa.charAt(i))) {
                conta++;
            }
        }
        /*return*/
        return conta;
    }

    /**
     * trasforma il primo carattere in maiuscolo e il restante in minuscolo
     *
     * @param stringa stringa inserita
     * @return stringa con tutti i caratteri minuscoli tranne il primo
     */
    public static String inizioMaiuscolo(String stringa) {
        /*primo in maiscuolo*/
        stringa = stringa.replace(stringa.charAt(0), Character.toUpperCase(stringa.charAt(0)));
        for (int i = 1; i < stringa.length(); i++) {
            //restante in minuscolo
            stringa = stringa.replace(stringa.charAt(i), Character.toLowerCase(stringa.charAt(i)));
        }
        /*return*/
        return stringa;

    }

    /**
     * controlla in che posizione si trova il carattere
     *
     * @param stringa stringa di caratteri
     * @param carattere carattere da cercare
     * @return posizione del carattere
     */
    public static int ricordaPosCarattere(String stringa, char carattere) {
        int ricordapos = 0;
        for (int i = 0; i < stringa.length(); i++) {
            if (stringa.charAt(i) == carattere) {
                ricordapos = i;
                break;
            }
        }
        return ricordapos;

    }

    /**
     * passata una stringa ricava una data.<br>N.B. la stringa deve essere
     * formattata nel seguente modo:yyyy-MM-dd
     *
     * @param str stringa contenente la data
     * @return data contenuta nella stringa
     */
    public static LocalDate ricavaData(String str) {

        String[] data = str.split("-"); //vettore in cui splitto i valori della data di nascita
        return LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])); //creo una variabile che contiene la dat di nascita

    }

    /**
     * fa lelenco di una arraylist
     *
     * @param <T> generico
     * @param lista lista generica di cui fare l'elenco
     * @return elenco dei dati contenuti nella lista
     */
    public static <T> String elenco(ArrayList<T> lista) {
        String elenco = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i != lista.size() - 1) {
                elenco += lista.get(i) + ",";
            } else {
                elenco += lista.get(i) + ".";
            }
        }

        return elenco;

    }

    /**
     * fa lelenco di un vettore
     *
     * @param <T> generico
     * @param vett vettore generico di cui fare l'elenco
     * @return elenco dei dati contenuti nel vettore
     */
    public static <T> String elenco(T[] vett) {
        String elenco = "";
        for (int i = 0; i < vett.length; i++) {
            if (i != vett.length - 1) {
                elenco += vett[i] + ",";
            } else {
                elenco += vett[i] + ".";
            }
        }

        return elenco;

    }

    /**
     * dato un vettore di caratteri la trasforma in una variabile
     * stringa<br></br><br></br>
     *
     * es:<br></br>
     * vett:{a,2,s,3, ,4,5}<br></br>
     * return:a2s3 45
     *
     * @param vett vettore di caratteri
     * @return stringa contenente i caratteri del vettore
     */
    public static String getString(char[] vett) {
        String str = ""; //str che deve essere restituita

        //scorro il vett
        for (char c : vett) {
            str += c;
        }

        return str; //return della str

    }

}
