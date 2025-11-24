/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.array;

import java.util.ArrayList;
import com.mycompany.libreriax.utils.Truth;

/**
 *
 * @author user
 */
public class ArrayString {

    public static int getPos(String[] vettore, String stringa) {
        int ricordapos = 0;

        //vad oa vedere in che posizione si trova la stringa
        for (int i = 0; i < vettore.length; i++) {
            if (stringa.equalsIgnoreCase(vettore[i])) {
                ricordapos = i;
                break;

            }
        }
        return ricordapos;
    }

    /**
     * elimina una stringa uguale a una stringa scelta dall'utente da un vettore
     *
     * @param vettore vettore di stringhe
     * @param stringa stringa da eòo,omare
     * @return vettore senza la stringa interessata
     */
    public static String[] remove(String[] vettore, String stringa) {
        int ricordapos = getPos(vettore, stringa);
        String[] vettore1 = new String[vettore.length - 1];

        //vado a modificare il vettore
        for (int i = 0; i < vettore.length; i++) {
            if (i < ricordapos) {
                vettore1[i] = vettore[i];
            } else if (i > ricordapos) {
                vettore1[i - 1] = vettore[i];
            }
        }
        /*return*/ return vettore1;
    }

    /**
     * elimina una stringa uguale a una stringa scelta dall'utente da un vettore
     *
     * @param vettore vettore di stringhe
     * @param stringa stringa da eòo,omare
     * @return vettore senza la stringa interessata
     */
    public static String[] removeAll(String[] vettore, String stringa) {

        /*conto quante volte è presente la stringa*/ int conta = conta(vettore, stringa);
        /*creo vettore*/ String[] vettore1 = new String[vettore.length - conta];

        //vado a modificare il vettore
        int conta1 = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (!vettore[i].equalsIgnoreCase(stringa)) {
                vettore1[conta1] = vettore[i];
                conta++;
            }
        }
        /*return*/ return vettore1;
    }

    /**
     * elimina una stringa in una pos scelta dall'utente da un vettore
     *
     * @param vettore vettore di stringhe
     * @param pos posizione del vettore da eliminare
     * @return
     */
    public static String[] removePos(String[] vettore, int pos) {

        if (Truth.checkPos(vettore, pos)) {
            String[] vettore1 = new String[vettore.length - 1];

            //vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < pos) {
                    vettore1[i] = vettore[i];
                } else if (i > pos) {
                    vettore1[i - 1] = vettore[i];
                }
            }
            /*return*/ return vettore1;

        } else {
            return null;
        }

    }

    /**
     * aggiunta in coda di una stringa in un vettore
     *
     * @param vettore vettore di stringhe
     * @param stringa strig a agiungere in coda
     * @return vettore con la stringa in ultima posizione
     */
    public static String[] add(String[] vettore, String stringa) {

        String[] vettore1 = new String[vettore.length + 1];

        for (int i = 0; i < vettore.length; i++) {
            vettore1[i] = vettore[i];
        }

        /* viene inserito il nuovo numero nell'ultima posizione del nuovo vettore*/ vettore1[vettore1.length - 1] = stringa;
        /*return*/ return vettore1;

    }

    /**
     * aggiunge una stringa in un posizioe scelta dall'utente
     *
     * @param vettore vettore di stringhe
     * @param stringa stringa che deve essere aggiunta
     * @param pos posizione in cui la stringa deve essere aggiunta
     * @return vettore con la stringa nella posizione pos
     */
    public static String[] add(String[] vettore, String stringa, int pos) {

        if (Truth.checkPos(vettore, pos)) {
            String[] vettore1 = new String[vettore.length + 1];

            //vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < pos) {
                    vettore1[i] = vettore[i];
                } else if (i == pos) {
                    vettore1[i] = stringa;
                } else if (i > pos) {
                    vettore1[i] = vettore[i - 1];
                }
            }

            /*return*/ return vettore1;
        } else {
            return null;
        }

    }

    /**
     * elenco di un vettore
     *
     * @param vettore
     * @return
     */
    public static String elenco(String[] vettore) {
        String elenco = "";
        for (int i = 0; i < vettore.length; i++) {
            if (i != vettore.length - 1) {
                elenco = elenco + vettore[i] + ",";

            } else {
                elenco = elenco + vettore[i] + ".";
            }
        }
        /*return*/ return elenco;

    }

    /**
     * elenco delle stringhe che hanno il max
     *
     * @param vettore ettore di interi che è collegato con il vettore di
     * stringhe
     * @param vettore1 vettore di stringhe
     * @return elenco del max
     */
    public static String elencoMax(int[] vettore, String[] vettore1) {
        //trovo il massimo
        int max = ArrayNum.max(vettore);
        int contamax = ArrayNum.conta(vettore, max);
        String[] vettore2 = new String[contamax];
        int conta = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] == max) {
                vettore2[conta] = vettore1[i];
                conta++;
            }
        }
        String elenco = elenco(vettore2);
        /*return*/ return elenco;

    }

    /**
     * Conta quante volte una stringa compare in un vettore
     *
     * @param vettore vettore di stringhe
     * @param stringa la stringa da cercare
     * @return quante volte la stringa x compare nel vettore
     */
    public static int conta(String[] vettore, String stringa) {
        int conta = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i].equalsIgnoreCase(stringa)) {
                conta++;
            }
        }
        /*return*/ return conta;
    }

    /**
     * il metodo mette in ordine alfabetico un vettore di stringhe
     *
     * @param vettore vettore di stringhe
     * @return vettore in ordine alfabetico
     */
    public static String[] sort(String[] vettore) {

        //ordino per la prima lettera
        for (int i = 0; i < vettore.length - 1; i++) {
            if (vettore[i].charAt(0) > vettore[i + 1].charAt(0)) {
                String ricorda = vettore[i];
                vettore[i] = vettore[i + 1];
                vettore[i + 1] = ricorda;
                i = -1;
            }
        }


        //conto quanti caratteri iniziali sono diversi
        /*inizia da 1 poichè cè già una parola (e di conseguenza c'è già una lettera*/ int conta0 = 1;
        for (int i = 0; i < vettore.length - 1; i++) {
            if (vettore[i].charAt(0) != vettore[i + 1].charAt(0)) {
                conta0++;
            }
        }

        /* indice vettore oirginale*/ int conta = 0;
        /*indice del vettore in cui metto tutto in ordine*/ int contawow = 0;
        /*contatore che serve per portare i parametri su vettore1.va di pari passo con conta*/ int cont = 0;
        /*vettore ordinato*/ String[] vettore2 = new String[vettore.length];

        for (int m = 0; m < conta0; m++) {


            //per me è più intuitivo usare un vettore di supporto in cui ci metto solo le parole che iniziano con la stessa lettera
            //conto quante parole di fila iniziano con la stessa lettera per poi metterle nel vettore

            /*conta che serve per la lunghezza del vettore in cui metto le stringhe con le stesse iniziali*/ int contawow1 = 0;
            //conto quante lettere uguali di fila  ci sono
            while (conta < vettore.length - 1) {
                if (vettore[conta].charAt(0) == vettore[conta + 1].charAt(0)) {
                    conta++;
                    contawow1++;
                } else {
                    break;
                }
            }

            /*incremento così dopo parto nell'indice giusto*/ conta++;
            /* incremento adesso,tanto non cambia*/ contawow1++;

            /*creo vettore*/ String[] vettore1 = new String[contawow1];

            //metto dentro i parametri
            for (int i = 0; i < vettore1.length; i++) {
                vettore1[i] = vettore[cont];
                cont++;
            }

            //ordino alfabetico
            if (contawow1 != 1) {
                for (int i = 0; i < vettore1.length - 1; i++) {
                    if (vettore1[i].contains(vettore1[i + 1]) && vettore[i + 1].length() > vettore[i].length()) {
                        String ricorda = vettore1[i];
                        vettore1[i] = vettore1[i + 1];
                        vettore1[i + 1] = ricorda;
                        i = -1;
                    } else {

                        int conta1 = 1;

                        //conto quanti caratteri di seguito sono uguali
                        try {
                            for (int j = 1; j < vettore1[i].length(); j++) {
                                if (vettore1[i].charAt(j) == vettore1[i + 1].charAt(j)) {
                                    conta1++;
                                } else {
                                    break;
                                }
                            }

                            //ordino
                            //uso un try-catch per prevenire l'errore: se la lunghezza della prima stringa è uguale a conta1 dà out of bound
                            if (vettore1[i].charAt(conta1) > vettore1[i + 1].charAt(conta1)) {
                                String ricorda = vettore1[i];
                                vettore1[i] = vettore1[i + 1];
                                vettore1[i + 1] = ricorda;
                                i = -1;
                            }
                        } catch (Exception ex) {
                        }

                    }

                }
            }

            for (int i = 0; i < vettore1.length; i++) {
                vettore2[contawow] = vettore1[i];
                contawow++;
            }

        }
        /*return*/ return vettore2;
    }

    /**
     * cerca la posizione della stringa all'interno della lista
     *
     * @param lista lista in cui cercare la posizione
     * @param stringa stringa che bisogna cercare
     * @return la posizione della stringa all'interno della lista
     */
    public static int getPos(ArrayList<String> lista, String stringa) {

        //cerco la posizione
        int pos = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equalsIgnoreCase(stringa)) {
                pos = i;
                break;
            }
        }

        return pos;

    }

    /**
     * conta quante volte compare nella lista una determinata stringa
     *
     * @param lista lista di stringhe
     * @param stringa stringa da contare
     * @return numero di presenze all'interno della lista
     */
    public static int conta(ArrayList<String> lista, String stringa) {
        int conta = 0;

        //conto
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equalsIgnoreCase(stringa)) {
                conta++;
            }
        }

        return conta;

    }

    /**
     * ordina alfabeticamente una lista
     *
     * @param lista lista di stringhe
     * @return lista ordinata alfabeticamente
     */
    public static ArrayList<String> ordinamentoAlfabetico(ArrayList<String> lista) {

        /*trasformo la lista in un vettore e uso la funzione già fatta per i vettori*/ String[] vettore = new String[lista.size()];

        //porto i parametri sul vettore
        for (int i = 0; i < lista.size(); i++) {
            vettore[i] = lista.get(i);
        }

        /*ordino*/ vettore = ArrayString.sort(vettore);

        //trasformo il vettore in una lista per poi restituirla
        ArrayList<String> lista1 = new ArrayList();

        for (int i = 0; i < vettore.length; i++) {
            lista1.add(vettore[i]);
        }

        /*return*/ return lista1;

    }

    /**
     * trasfpr,ma una lista di stringhe in un array di stringhe
     * @param lista lista di stringhe da converitre
     * @return arrya contenenti le stringhe della lista passata
     */
    public static String[] toArrayStr(ArrayList<String> lista) {

        String[] arr = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            arr[i] = lista.get(i);
        }
        
        return arr;

    }

}
