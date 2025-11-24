/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.console;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class output {

    /**
     * output di un vettore intero N.B. RICORDA
     * System.out.println("vettore:"+Array.ArrayNum.elenco(vettore));
     *
     * @param vettore
     */
    public static void outputInt(int[] vettore) {

        System.out.print("vettore:");
        for (int i = 0; i < vettore.length; i++) {
            System.out.print(vettore[i] + "\t");
        }
        System.out.println("");
    }

    /**
     * output di una matrice intera
     *
     * @param matrice di interi
     */
    public static void outputInt(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    /**
     * output di una matrice boolean
     *
     * @param matrice di interi
     */
    public static void outputBoolean(boolean[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    /**
     * output di un vettore
     *
     * @param vettore vettore di caratteri
     */
    public static void outputChar(char[] vettore) {
        System.out.print("vettore:");
        for (int i = 0; i < vettore.length; i++) {
            if (i != vettore.length - 1) {
                System.out.print(vettore[i] + ",");

            } else {
                System.out.print(vettore[i] + ".");
            }
        }
        System.out.println("");
    }

    /**
     * output dei caratteri di una stringa
     *
     * @param stringa stringa
     */
    public static void outputChar(String stringa) {
        System.out.print("vettore:");
        for (int i = 0; i < stringa.length(); i++) {
            if (i != stringa.length() - 1) {
                System.out.print(stringa.charAt(i) + ",");
            } else {
                System.out.print(stringa.charAt(i) + ".");
            }
        }
        System.out.println("");

    }

    /**
     * output di una matrice di caratteri
     *
     * @param matrice matrice di caratteri
     */
    public static void outputChar(char[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    /**
     * out put di un vettore decimale N.B. RICORDA
     * System.out.println("vettore:"+Array.ArrayNum.elenco(vettore));
     *
     * @param vettore
     */
    public static void outputDouble(double[] vettore) {
        System.out.print("vettore:");
        for (int i = 0; i < vettore.length; i++) {
            System.out.print(vettore[i] + "\t");
        }
        System.out.println("");

    }

    public static void stampaLista(ArrayList<String> lista) {
        // .size() restituisce la dimensione della lista
        System.out.println("Contenuto della lista (lunghezza " + lista.size() + "):");
        for (int i = 0; i < lista.size(); i++) {
            // il metodo .get(pos) restituisce l'elemento alla posizione pos della lista
            System.out.println("Posizione " + i + ": " + lista.get(i));
        }
    }

    /**
     * output una lista 2D lista per lista
     *
     * @param lista lista da stampare
     */
    public static void stampaLista2D1(ArrayList<ArrayList<String>> lista) {
        // .size() restituisce la dimensione della lista
        System.out.println("Contenuto della lista (lunghezza " + lista.size() + "):");
        for (int i = 0; i < lista.size(); i++) {
            // il metodo .get(pos) restituisce l'elemento alla posizione pos della lista
            System.out.println("Posizione " + i + ": " + lista.get(i));
        }
    }

    /**
     * output una lista valore per valore
     *
     * @param lista lista da stampare
     */
    static void stampaLista2D(ArrayList<ArrayList<String>> lista) {
        // lista.size() indica quante righe ha l'ArrayList a 2 dimensioni
        // pensando all'ArrayList a 2 dimensioni come ad una matrice di String, lista.size() indica quante righe ha la matrice
        for (int r = 0; r < lista.size(); r++) {
            // lista.get(r).size() indica quante String sono presenti nell'ArrayList alla riga r dell'ArrayList a 2 dimensioni
            // pensando all'ArrayList a 2 dimensioni come ad una matrice di String, lista.get(r).size() indica quante String sono presenti alla riga r della matrice
            for (int c = 0; c < lista.get(r).size(); c++) {
                System.out.print(lista.get(r).get(c) + "\t");
            }
            System.out.println();
        }
    }

    public static <T> void output_dato(T[] thing) {

        System.out.print("vettore:");
        for (int i = 0; i < thing.length; i++) {
            System.out.print(thing[i] + "\t");
        }
        System.out.println("");

    }

    public static <T> void output_dato(T[][] thing) {

        for (int i = 0; i < thing.length; i++) {
            for (int j = 0; j < thing[0].length; j++) {
                System.out.print(thing[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    /**
     * output di una lisya
     *
     * @param <T> tipo generico
     * @param lista lista di dati
     */
    public static <T> void output_dato(ArrayList<T> lista) {

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i) + "\t");
        }

    }

    public static <T> void output_lista_vettori(ArrayList<T[]> lista) {

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).length; j++) {
                System.out.print(lista.get(i)[j] + "\t");
            }
            System.out.println("");
        }

    }

}
