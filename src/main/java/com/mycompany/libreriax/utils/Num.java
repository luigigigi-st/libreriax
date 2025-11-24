/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.utils;

/**
 *
 * @author user
 */
public class Num {

    /**
     * conversione di un numero binario in decimale
     *
     * @param num stringa con il numero all'interno
     * @return numero decimale
     */
    public static int conversionFromBinary(String num) {

        //creo vettore in cui inserisco tutti i caratteri della stringa e lavoro da lì per semplicità
        int[] vettore = new int[num.length()];
        for (int i = 0; i < vettore.length; i++) {
            vettore[i] = num.charAt(i) - 48;
        }

        int somma = 0;
        /*contatore di supporto (esponente)*/
        int conta = vettore.length - 1;
        for (int i = 0; i < vettore.length; i++) {
            somma += vettore[i] * (int) Math.pow(2, conta);
            conta--;
        }

        /*return*/
        return somma;

    }

    /**
     * conversione di un numero binario in decimale
     *
     * @param num stringa con il numero all'interno
     * @return numero decimale
     */
    public static int conversionFromBinary(int num) {
        /*trasformo il numero in una stringa*/ String stringa = num + "";
        //creo vettore in cui inserisco tutti i caratteri della stringa e lavoro da lì per semplicità
        int[] vettore = new int[stringa.length()];
        for (int i = 0; i < vettore.length; i++) {
            vettore[i] = stringa.charAt(i) - 48;
        }
        int somma = 0;
        /*contatore di supporto (esponente)*/ int conta = vettore.length - 1;
        for (int i = 0; i < vettore.length; i++) {
            somma += vettore[i] * (int) Math.pow(2, conta);
            conta--;
        }

        /*return*/ return somma;

    }

    /**
     * conta quanti divisori ha un numero <br>N.B. lo zero ha divisori infiniti
     *
     * @param n numero interessato
     * @return numero di divosri del numero oassato. se il numero è 0
     * restituisce -1
     */
    public static int contaDivisori(int n) {

        //se n è 0 restuisco 0
        if (n == 0) {
            return -1;
        }

        int contaDivisori = 0; //contatore

        //conto i divisori
        for (int j = 1; j <= n; j++) {

            //contro i divisori
            if (n % j == 0) {
                contaDivisori++;
            }

        }

        return contaDivisori; //return
    }

}
