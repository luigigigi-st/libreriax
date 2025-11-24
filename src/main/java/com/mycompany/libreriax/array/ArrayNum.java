/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.array;

import java.util.ArrayList;
import java.util.Arrays;
import com.mycompany.libreriax.utils.Num;
import com.mycompany.libreriax.utils.Truth;

public class ArrayNum {

    /**
     * conta quanti numeri sono presenti all'insterno di un intervallo
     *
     * @param vettore vettore in questione
     * @param intervallo1 estremo 1
     * @param intervallo2 estremo 2
     * @return il numero dei numeri che sono presenti all'insterno di un
     * intervallo
     */
    public static int contaNIntervallo(int[] vettore, int intervallo1, int intervallo2) {
        int conta = 0;

        for (int i = 0; i < vettore.length; i++) {
            if (Truth.checkIntervallo(vettore[i], intervallo1, intervallo2)) {
                conta++;
            }
        }

        /* return */ return conta;
    }

    /**
     * conta qaunti numeri hanno il valore assoluto compreso in un intervallo
     *
     * @param vettore vettore
     * @param intervallo1 estremo 1
     * @param intervallo2 estremo 2
     * @return il numero dei numeri che hanno il valore assoluto compreso in un
     * intervallo
     */
    public static double contaVAssolutoIntervallo(int[] vettore, int intervallo1, int intervallo2) {
        int conta = 0;

        for (int i = 0; i < vettore.length; i++) {

            // controllo se è compreso
            if (Truth.checkIntervallo(Math.abs(vettore[i]), intervallo1, intervallo2)) {
                conta++;
            }

        }

        /*return*/ return conta;

    }

    /**
     * calcola la somma di tutti i numeri del vettore
     *
     * @param vettore vettore di numeri interi
     * @return somma di tutti i numeri del vettore
     */
    public static int somma(int[] vettore) {
        int somma = 0;

        for (int i = 0; i < vettore.length; i++) {
            somma += vettore[i];
        }
        /*return*/ return somma;

    }

    public static <T extends Number> double somma(T[] vettore) {
        double somma = 0.0;

        for (int i = 0; i < vettore.length; i++) {
            somma += vettore[i].doubleValue();
        }

        return somma;

    }

    /**
     * calcola la media di tutti i numeri del vettore
     *
     * @param vettore vettore di numeri interi
     * @return media di tutti i numeri del vettore
     */
    public static double media(int[] vettore) {
        int somma = somma(vettore);
        double media = (double) somma / vettore.length;
        return media;

    }

    /**
     * trova il minimo all'interno di un vettore
     *
     * @param vettore vettore di nuemri interi
     * @return numero più piccolo del vettore
     */
    public static int min(int[] vettore) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] < min) {
                min = vettore[i];
            }
        }

        /*return*/ return min;

    }

    /**
     * trova il massimo all'interno di un vettore
     *
     * @param vettore vettore di numeri interi
     * @return numero più grande del vettore
     */
    public static int max(int[] vettore) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] > max) {
                max = vettore[i];
            }
        }
        /*return*/ return max;

    }

    /**
     * trova il minimo all'interno di un vettore
     *
     * @param vettore vettore di nuemri interi
     * @return numero più piccolo del vettore
     */
    public static double min(double[] vettore) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] < min) {
                min = vettore[i];
            }
        }

        /*return*/ return min;

    }

    /**
     * trova il massimo all'interno di un vettore
     *
     * @param vettore vettore di numeri interi
     * @return numero più grande del vettore
     */
    public static double max(double[] vettore) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] > max) {
                max = vettore[i];
            }
        }
        /*return*/ return max;

    }

    /**
     * conta i numeri primi all'interno di un vettore
     *
     * @param vettore vettore
     * @return numero di numeri primi presenti all'interno del vettore
     */
    public static int contaPrimi(int[] vettore) {

        int conta = 0;

        // conta numeri primi
        for (int i = 0; i < vettore.length; i++) {
            int contaDivisori = 0;
            // conto i divisori del numero
            for (int j = 1; j <= vettore[i]; j++) {

                if (vettore[i] % j == 0) {
                    contaDivisori++;
                }

            }

            // se i divisori sono 2 è un numero primo (1 e se stesso)
            if (contaDivisori == 2) {
                conta++;
            }
        }

        // return
        return conta;

    }

    /**
     * conta i multipli di un numero all'interno un vettore
     *
     * @param vettore vettore
     * @param num numero per i multipli da trovare
     * @return
     */
    public static int contaMultipli(int[] vettore, int num) {

        int conta = 0;

        // conta multipli
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] % num == 0) {
                conta++;
            }
        }

        // return
        return conta;

    }

    /**
     * somma di numeri compresi in un intervallo
     *
     * @param vettore vettore
     * @param intervallo1 estremo 1
     * @param intervallo2 estremo 2
     * @return
     */
    public static int sommaIntervallo(int[] vettore, int intervallo1, int intervallo2) {

        int somma = 0;

        for (int i = 0; i < vettore.length; i++) {
            if (Truth.checkIntervallo(vettore[i], intervallo1, intervallo2)) {
                somma += vettore[i];
            }

        }
        /* return */ return somma;

    }

    /**
     * conta quante volte è presente un paramtro
     *
     * @param vettore vettore di numeri interi
     * @param parametro numero da contare all'interno del vettore
     * @return il conto del numero
     */
    public static int conta(int[] vettore, int parametro) {
        int conta = 0;

        // conto quante volte è presente il paramtro
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] == parametro) {
                conta++;
            }
        }

        return conta;

    }

    /**
     * conta quante volte è presente un paramtro
     *
     * @param vettore vettore di numeri double
     * @param parametro numero da contare all'interno del vettore
     * @return il conto del numero
     */
    public static int conta(double[] vettore, double parametro) {
        int conta = 0;

        // conto quante volte è presente il paramtro
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] == parametro) {
                conta++;
            }
        }

        return conta;

    }

    /**
     * trova la posizione di un numero
     *
     * @param vettore vettore di interi
     * @param num nuemo da trovare la pos
     * @return pos del numero interessato.se non trovato restituisce -1
     */
    public static int getPos(int[] vettore, int num) {
        int ricordapos = -1;
        for (int i = 0; i < vettore.length; i++) {
            if (num == vettore[i]) {
                ricordapos = i;
                break;

            }
        }

        return ricordapos;

    }

    /**
     * trova la posizione di un numero
     *
     * @param vettore vettore di double
     * @param num nuemro da trovare la pos
     * @return pos del numero interessato. se non trovato restituisce -1
     */
    public static int getPos(double[] vettore, double num) {
        int ricordapos = -1;
        for (int i = 0; i < vettore.length; i++) {
            if (num == vettore[i]) {
                ricordapos = i;
                break;

            }
        }

        return ricordapos;

    }

    /**
     * aggiunta in coda di un umero in un vettore
     *
     * @param vettore vettore di numeri interi
     * @param num nuemro da aggiungere in coda
     * @return vettore con il numero in ultima pos
     */
    public static int[] add(int[] vettore, int num) {

        int[] vettore1 = new int[vettore.length + 1];

        for (int i = 0; i < vettore.length; i++) {
            vettore1[i] = vettore[i];
        }

        // viene inserito il nuovo numero nell'ultima posizione del nuovo vettore
        vettore1[vettore1.length - 1] = num;

        return vettore1;

    }

    /**
     * aggiunge un numero in un posizioe scelta dall'utente<br>N.B. scegli bene
     * la pos che se non corretta la funzione returna null
     *
     * @param vettore vettore di numeri
     * @param num numero che deve essere aggiunto
     * @param pos posizione in cui la stringa deve essere aggiunta
     * @return vettore con il numero aggiunto. se la pos non è accettabile
     * returna null
     */
    public static int[] add(int[] vettore, int num, int pos) {

        if (Truth.checkPos(vettore, pos)) {
            int[] vettore1 = new int[vettore.length + 1];

            // vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < pos) {
                    vettore1[i] = vettore[i];

                } else if (i == pos) {
                    vettore1[i] = num;
                } else if (i > pos) {
                    vettore1[i] = vettore[i - 1];

                }
            }

            /* return */ return vettore1;
        } else {
            return null;
        }

    }

    /**
     * aggiunta in coda di un umero in un vettore
     *
     * @param vettore vettore di numeri interi
     * @param num nuemro da aggiungere in coda
     * @return vettore con il numero in ultima pos
     */
    public static double[] add(double[] vettore, double num) {

        double[] vettore1 = new double[vettore.length + 1];

        for (int i = 0; i < vettore.length; i++) {
            vettore1[i] = vettore[i];
        }

        // viene inserito il nuovo numero nell'ultima posizione del nuovo vettore
        vettore1[vettore1.length - 1] = num;

        return vettore1;

    }

    /**
     * aggiunge un numero in un posizioe scelta dall'utente
     *
     * @param vettore vettore di numeri
     * @param num numero che deve essere aggiunto
     * @param pos posizione in cui la stringa deve essere aggiunta
     * @return vettore con il numero aggiunto
     */
    public static double[] add(double[] vettore, double num, int pos) {

        if (Truth.checkPos(vettore, pos)) {
            double[] vettore1 = new double[vettore.length + 1];

            // vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < pos) {
                    vettore1[i] = vettore[i];

                } else if (i == pos) {
                    vettore1[i] = num;
                } else if (i > pos) {
                    vettore1[i] = vettore[i - 1];

                }
            }

            /* return */ return vettore1;
        } else {
            return null;
        }

    }

    /**
     *
     * elimina una occorrenza da un vettore
     *
     * @param vettore vettore di numeri
     * @param occorrenza occorrenza da eliminare
     * @return vettore senza la prima occorrenza. se l'occorenza non è presente
     * return null.
     *
     */
    public static int[] remove(int[] vettore, int occorrenza) {

        /* ricordo la pos */ int ricordapos = getPos(vettore, occorrenza);

        if (ricordapos != -1) {
            int[] vettore1 = new int[vettore.length - 1];
            // vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < ricordapos) {
                    vettore1[i] = vettore[i];
                } else if (i > ricordapos) {
                    vettore1[i - 1] = vettore[i];
                }
            }

            /* return */ return vettore1;

        } else {
            return null;
        }

    }

    /**
     *
     * elimina una occorrenza da un vettore
     *
     * @param vettore vettore di numeri
     * @param occorrenza occorrenza da eliminare
     * @return vettore senza la prima occorrenza. se l'occorenza non è presente
     * return null.
     *
     */
    public static double[] remove(double[] vettore, double occorrenza) {

        /* ricordo la pos */ int ricordapos = getPos(vettore, occorrenza);

        if (ricordapos != -1) {
            double[] vettore1 = new double[vettore.length - 1];
            // vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < ricordapos) {
                    vettore1[i] = vettore[i];

                } else if (i > ricordapos) {
                    vettore1[i - 1] = vettore[i];
                }
            }

            /* return */ return vettore1;

        } else {
            return null;
        }

    }

    /**
     * elimina tutte le occorrenze da un vettore
     *
     * @param vettore vettore di numeri
     * @param occorrenza occorrenza da eliminare
     * @return vettore senza occorrenze
     */
    public static int[] removeAll(int[] vettore, int occorrenza) {

        /* conto il numero di occorrenze */
        int conta = conta(vettore, occorrenza);

        if (conta == 0) {
            return vettore;
        }

        // creo vettore in cui ci andranno tutti i numeri tranne le occorrenze
        int[] vettore1 = new int[vettore.length - conta];

        // vado a modificare il vettore
        int conta1 = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] != occorrenza) {
                vettore1[conta1] = vettore[i];
                conta1++;
            }
        }

        /* return */ return vettore1;
    }

    /**
     * elimina un numero in una pos scelta dall'utente da un vettore
     *
     * @param vettore vettore di interi
     * @param pos posizione da eliminare
     * @return vettore senza il numero che si trovava all'interno della posizone
     * inserita
     *
     */
    public static int[] removePos(int[] vettore, int pos) {
        if (Truth.checkPos(vettore, pos)) {
            int[] vettore1 = new int[vettore.length - 1];
            // vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < pos) {
                    vettore1[i] = vettore[i];

                } else if (i > pos) {
                    vettore1[i - 1] = vettore[i];
                }
            }
            /* return */ return vettore1;
        } else {
            return null;
        }
    }

    /**
     * elimina tutte le occorrenze da un vettore
     *
     * @param vettore vettore di numeri
     * @param occorrenza occorrenza da eliminare
     * @return vettore senza occorrenze
     */
    public static double[] removeAll(double[] vettore, double occorrenza) {

        /* conto il numero di occorrenze */
        int conta = conta(vettore, occorrenza);
        
        if(conta==0){
        return vettore;
        }

        // creo vettore in cui ci andranno tutti i numeri tranne le occorrenze
        double[] vettore1 = new double[vettore.length - conta];

        // vado a modificare il vettore
        int conta1 = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] != occorrenza) {
                vettore1[conta1] = vettore[i];
                conta1++;
            }
        }

        /* return */ return vettore1;
    }

    /**
     * elimina un numero in una pos scelta dall'utente da un vettore
     *
     * @param vettore vettore di interi
     * @param pos posizione da eliminare
     * @return vettore senza il numero che si trovava all'interno della posizone
     * inserita
     *
     */
    public static double[] removePos(double[] vettore, int pos) {
        if (Truth.checkPos(vettore, pos)) {
            double[] vettore1 = new double[vettore.length - 1];
            // vado a modificare il vettore
            for (int i = 0; i < vettore.length; i++) {
                if (i < pos) {
                    vettore1[i] = vettore[i];

                } else if (i > pos) {
                    vettore1[i - 1] = vettore[i];
                }
            }
            /* return */ return vettore1;
        } else {
            return null;
        }
    }

    // inutile
    // /**
    // *Aggiornamento di un numero con un nuovo valore a scelta dell'utente
    // * @param vettore vettore di numeri
    // * @param num numero da aggiornare
    // * @param num1 valore con cui viene aggiornato
    // */
    // public static void aggiornaNum(int[] vettore, int num, int num1) {
    //
    // vettore[ricordaPos(vettore,num)]=num1;
    //
    // }
    /**
     * conta i numeri pari
     *
     * @param vettore vettore di interi
     * @return il numero di pari all'interno del vettore
     */
    public static int contaPari(int[] vettore) {
        // conto quanti pari e dispari sono presenti nel vettore
        int contaPari = 0;

        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] % 2 == 0) {
                contaPari++;
            }
        }
        /* return */ return contaPari;
    }

    /**
     * restituisce un vettore con solo numeri pari
     *
     * @param vettore vettore di numeri interi
     * @return vettore di numeri pari
     */
    public static int[] arrayPari(int[] vettore) {
        int contaPari = ArrayNum.contaPari(vettore);
        if(contaPari==0){return new int[0];}
        int[] vettPari = new int[contaPari];

        // inserisco i numeri pari nel primo vettore
        int conta = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] % 2 == 0) {
                vettPari[conta] = vettore[i];
                conta++;
            }
        }
        /* return */ return vettPari;

    }

    /**
     * conta i numeri dispari
     *
     * @param vettore vettore di interi
     * @return il numero dei dispari
     */
    public static int contaDispari(int[] vettore) {
        // conto quanti dispari sono presenti nel vettore
        int contaDispari = 0;

        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] % 2 != 0) {
                contaDispari++;
            }
        }
        /* return */ return contaDispari;

    }

    /**
     * restituisce un vettore con solo numeri dispari
     *
     * @param vettore vettore di numeri interi
     * @return vettore di numeri dispari
     */
    public static int[] arrayDispari(int[] vettore) {
        int contaDispari = ArrayNum.contaDispari(vettore);
        if(contaDispari==0){return new int[0];}
        int[] vettDispari = new int[contaDispari];

        // inserisco i numeri pari nel primo vettore
        int conta = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] % 2 != 0) {
                vettDispari[conta] = vettore[i];
                conta++;
            }
        }
        /* return */ return vettDispari;
    }

    /**
     * conta i numeri divisibili per 2
     *
     * @param vettore vettore di interi
     * @return il numero di pari all'interno del vettore
     */
    public static int contaPari(double[] vettore) {
        // conto quanti pari e dispari sono presenti nel vettore
        int contaPari = 0; //contatore

        //scorro il vettore e conto
        for (double n : vettore) {

            if (Truth.checkPari(n)) {
                contaPari++; //aggiungo
            }

        }

        return contaPari; //return 

    }

    /**
     * restituisce un vettore con solo numeri pari
     *
     * @param vettore vettore di numeri interi
     * @return vettore di numeri pari
     */
    public static double[] arrayPari(double[] vettore) {
        int contaPari = ArrayNum.contaPari(vettore); //vedo quanti numeri divisibili per 2 ci sono
        
        if(contaPari==0){return new double[0];}
        double[] vettPari = new double[contaPari]; //creo il vettore che deve contenere i numeri

        // inserisco i numeri pari nel vettore
        int conta = 0; //contatore che mi scorre il vettore che deve ricevere i dati

        for (int i = 0; i < vettore.length; i++) {

            if (Truth.checkPari(vettore[i])) {
                //aggiungo il numero al vettore e mando avanti il contatore
                vettPari[conta] = vettore[i];
                conta++;
            }
        }
        /* return */ return vettPari;

    }

    /**
     * conta i numeri dispari
     *
     * @param vettore vettore di interi
     * @return il numero dei dispari
     */
    public static int contaDispari(double[] vettore) {
        // conto quanti dispari sono presenti nel vettore
        int contaDispari = 0;

        for (int i = 0; i < vettore.length; i++) {
            if (!Truth.checkPari(vettore[i])) {
                contaDispari++;
            }
        }
        /* return */ return contaDispari;

    }

    /**
     * restituisce un vettore con solo numeri dispari
     *
     * @param vettore vettore di numeri interi
     * @return vettore di numeri dispari
     */
    public static double[] arrayDispari(double[] vettore) {
        int contaDispari = ArrayNum.contaDispari(vettore);
        if(contaDispari==0){return new double[0];}
        double[] vettDispari = new double[contaDispari];

        // inserisco i numeri pari nel primo vettore
        int conta = 0;
        for (int i = 0; i < vettore.length; i++) {
            if (Truth.checkPari(vettore[i])) {
                vettDispari[conta] = vettore[i];
                conta++;
            }
        }
        /* return */ return vettDispari;
    }

    /**
     * ordina in ordine crescente i numeri all'internmo del vettore (METODO
     * GIGGI)
     *
     * @param vettore vettore di numeri
     * @return vettore ordinato in ordine crescente
     */
    public static int[] ordinamentoCrescente(int[] vettore) {

        // MODO MIO
        for (int i = 0; i < vettore.length - 1; i++) {

            // inzia l'oridnamento
            if (vettore[i] > vettore[i + 1]) {
                // modifico
                int ricorda = vettore[i];
                vettore[i] = vettore[i + 1];
                vettore[i + 1] = ricorda;

                // faccio ripartire il ciclo da zero,così i controlli vengono fatti sempre
                // SONO ABBSTANZA SICURO CHE NON SIA EFFICIENTE MA FUNZIONA QUINDI ESGGHERE
                i = -1;
            }

        }
        /* return */ return vettore;

    }

    /**
     * ordina in ordine decrescente i numeri all'internmo del vettore (METODO
     * GIGGI)
     *
     * @param vettore vettore di numeri
     * @return vettore ordinato in ordine crescente
     */
    public static int[] ordinamentoDecrescente(int[] vettore) {

        // MODO MIO
        for (int i = 0; i < vettore.length - 1; i++) {

            // inzia l'oridnamento
            if (vettore[i] < vettore[i + 1]) {
                // modifico
                int ricorda = vettore[i];
                vettore[i] = vettore[i + 1];
                vettore[i + 1] = ricorda;

                // faccio ripartire il ciclo da zero,così i controlli vengono fatti sempre
                // SONO ABBSTANZA SICURO CHE NON SIA EFFICIENTE MA FUNZIONA QUINDI ESGGHERE
                i = -1;
            }

        }
        /* return */ return vettore;

    }

    /**
     * crea un vettore contenete solo i multipli del numero passato.i numero
     * saranno presi dal vettore passato
     *
     * @param vettore vettore di numeri
     * @param parametro paramtero numerico
     * @return vettore contenete i multipli del parametro
     */
    public static int[] arrayMultipli(int[] vettore, int parametro) {
        int contaM=contaMultipli(vettore, parametro);
        
        if(contaM==0){return new int[0];}
        
        int[] vettore1 = new int[contaM];
        int conta = 0;

        // riempiamo il vettore con i numeri che ci servono
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] % parametro == 0) {
                vettore1[conta] = vettore[i];
                conta++;
            }
        }
        /* return */
        return vettore1;

    }

    /**
     * questa funzione crea l'elenco di un vettore
     *
     * @param vettore vettor idi numeri interi
     * @return l'elenco dei numeri contenuti all'interno del vettore
     */
    public static String elenco(int[] vettore) {

        // elenco
        String elenco = "";
        for (int i = 0; i < vettore.length; i++) {
            if (i != vettore.length - 1) {
                elenco = elenco + vettore[i] + ",";
            } else {
                elenco = elenco + vettore[i] + ".";
            }
        }
        /* return */
        return elenco;
    }

    /**
     * conta quanti numeri sono presenti all'insterno di un intervallo
     *
     * @param <T> valore numerico generico
     * @param lista lista di numeri generici
     * @param intervallo1 estremo uno
     * @param intervallo2 estremo 2
     * @return
     */
    public static <T extends Number> int contaNIntervallo(ArrayList<T> lista, double intervallo1, double intervallo2) {
        int conta = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (Truth.checkIntervallo(lista.get(i).doubleValue(), intervallo1, intervallo2)) {
                conta++;
            }
        }

        /*return */ return conta;
    }

    /**
     * conta qaunti numeri hanno il valore assoluto compreso in un intervallo
     *
     * @param <T> valore numerico generico
     * @param lista lista di numeri interi
     * @param intervallo1 estremo 1
     * @param intervallo2 estremo 2
     * @return
     */
    public static <T extends Number> int contaVAssolutoIntervallo(ArrayList<T> lista, int intervallo1, int intervallo2) {
        int conta = 0;

        for (int i = 0; i < lista.size(); i++) {

            //controllo se è compreso
            if (Truth.checkIntervallo(Math.abs(lista.get(i).doubleValue()), intervallo1, intervallo2)) {
                conta++;
            }

        }

        /*return*/ return conta;

    }

    /**
     * calcola la somma di tutti i numeri del vettore
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @return
     */
    public static <T extends Number> double somma(ArrayList<T> lista) {
        double somma = 0;

        for (int i = 0; i < lista.size(); i++) {
            somma += lista.get(i).doubleValue();
        }
        /*return*/ return somma;

    }

    /**
     * calcola la media di tutti i numeri del vettore
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @return
     */
    public static <T extends Number> double media(ArrayList<T> lista) {
        double somma = somma(lista);
        double media = somma / lista.size();
        /*return*/ return media;

    }

    /**
     * trova il minimo all'interno di un vettore
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @return
     */
    public static <T extends Number> double min(ArrayList<T> lista) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).doubleValue() < min) {
                min = lista.get(i).doubleValue();
            }
        }

        /*return*/ return min;

    }

    /**
     * trova il massimo all'interno di una lista
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @return valore massimo della lista
     */
    public static <T extends Number> double max(ArrayList<T> lista) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).doubleValue() > max) {
                max = lista.get(i).doubleValue();
            }
        }
        /*return*/ return max;

    }

    /**
     * conta i numeri primi allinterno di un vettore
     *
     * @param lista lista di numeri interi
     * @return numero di primi presenti nella lista
     */
    public static int contaPrimi(ArrayList<Integer> lista) {

        int conta = 0;

        //conta numeri primi
        for (int i = 0; i < lista.size(); i++) {
            int contaDivisori = Num.contaDivisori(lista.get(i));

            //se ha 2 divisori è primo(1 e se stesso)
            if (contaDivisori == 2) {
                conta++;
            }
        }

        /*return*/ return conta;

    }

    /**
     * conta i multipli di un numero all'interno una lista
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @param num numero per i multipli da trovare
     * @return numero di multipli
     */
    public static <T extends Number> int contaMultipli(ArrayList<T> lista, double num) {

        int conta = 0;

        //conta multipli
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).doubleValue() % num == 0) {
                conta++;
            }
        }

        /*return*/ return conta;

    }

    /**
     * dati come parametro un intervallo si fa la somma dei numeri compresi tra
     * i due estremi
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @param intervallo1 estremo 1
     * @param intervallo2 estremo 2
     * @return somma dei numeri interessati
     */
    public static <T extends Number> double sommaIntervallo(ArrayList<T> lista, double intervallo1, double intervallo2) {

        double somma = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (Truth.checkIntervallo(lista.get(i).doubleValue(), intervallo1, intervallo2)) {
                somma += lista.get(i).doubleValue();
            }

        }
        /*return*/ return somma;

    }

    /**
     * conta quante volte è presente un paramtro
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @param parametro numero da contare all'interno del vettore
     * @return il conto del numero
     */
    public static <T extends Number> int conta(ArrayList<T> lista, double parametro) {
        int conta = 0;

        //conto quante volte è presente il paramtro
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).doubleValue() == parametro) {
                conta++;
            }
        }

        return conta;

    }

    /**
     * trova la posizione di un numero. se pos=-1 allora il numero non è
     * presente all'interno della lista
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri interi
     * @param num nuemo da trovare la pos
     * @return pos del numero interessato
     */
    public static <T extends Number> int getPos(ArrayList<T> lista, double num) {
        for (int i = 0; i < lista.size(); i++) {
            if (num == lista.get(i).doubleValue()) {
                return i;

            }
        }
        /*return*/ return -1;
    }

    /**
     * conta i numeri divisibili per 2
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri
     * @return il numero di pari all'interno della lista
     */
    public static <T extends Number> int contaPari(ArrayList<T> lista) {
        //conto quanti pari e dispari sono presenti nel vettore
        int contaPari = 0;

        for (int i = 0; i < lista.size(); i++) {

            if (Truth.checkPari(lista.get(i).doubleValue())) {
                contaPari++;
            }
        }
        /*return*/ return contaPari;

    }

    /**
     * restituisce una lista con solo numeri divisibili per 2
     *
     * @param <T> classe numerica qualsiasi
     * @param lista lista di numeri
     * @return lista di numeri pari
     */
    public static <T extends Number> ArrayList<T> arrayPari(ArrayList<T> lista) {
        //conto quanti pari e dispari sono presenti nel vettore
        ArrayList<T> lista1 = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            if (Truth.checkPari(lista.get(i).doubleValue())) {
                lista1.add(lista.get(i));
            }
        }
        return lista1;

    }

    /**
     * conta i numeri non divisibili per 2
     *
     * @param <T> classe numerica generica
     * @param lista lista di numeri interi
     * @return il numero dei dispari
     */
    public static <T extends Number> int contaDispari(ArrayList<T> lista) {
        //conto quanti pari e dispari sono presenti nel vettore
        int contaDispari = 0;

        for (int i = 0; i < lista.size(); i++) {

            if (!Truth.checkPari(lista.get(i).doubleValue())) {
                contaDispari++;
            }
        }
        /*return*/ return contaDispari;

    }

    /**
     * restituisce un lista con solo numeri non divisibili per due
     *
     * @param <T> classe numerica generica
     * @param lista lista di numeri interi
     * @return lista di numeri dispari
     */
    public static <T extends Number> ArrayList<T> arrayDispari(ArrayList<T> lista) {
        ArrayList<T> lista1 = new ArrayList();
        //inserisco i numeri pari nella lista
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).intValue() % 2 != 0) {
                lista1.add(lista.get(i));
            }
        }
        /*return*/ return lista1;

    }

    /**
     * ordina in ordine crescente i numeri all'internmo del vettore (METODO
     * GIGGI)
     *
     * @param lista lista di numeri interi
     * @return lista in ordine crescente
     */
    public static ArrayList<Integer> ordinamentoCrescente(ArrayList<Integer> lista) {

        //MODO MIO
        for (int i = 0; i < lista.size() - 1; i++) {

            //inzia l'oridnamento
            if (lista.get(i) > lista.get(i + 1)) {
                //modifico
                int ricorda = lista.get(i);
                lista.set(i, lista.get(i + 1));
                lista.set(i + 1, ricorda);

                //faccio ripartire il ciclo da zero,così i controlli vengono fatti sempre
                //SONO ABBSTANZA SICURO CHE NON SIA EFFICIENTE MA FUNZIONA QUINDI ESGGHERE
                i = -1;
            }

        }
        return lista;

    }

    /**
     * ordina in ordine decrescente i numeri all'internmo del vettore (METODO
     * GIGGI)
     *
     * @param lista lista di numeri interi
     * @return lista in ordine crescente
     */
    public static ArrayList<Integer> ordinamentoDecrescente(ArrayList<Integer> lista) {

        //MODO MIO
        for (int i = 0; i < lista.size() - 1; i++) {

            //inzia l'oridnamento
            if (lista.get(i) < lista.get(i)) {
                //modifico
                int ricorda = lista.get(i);
                lista.set(i, lista.get(i + 1));
                lista.set(i + 1, ricorda);

                //faccio ripartire il ciclo da zero,così i controlli vengono fatti sempre
                //SONO ABBSTANZA SICURO CHE NON SIA EFFICIENTE MA FUNZIONA QUINDI ESGGHERE
                i = -1;
            }

        }
        return lista;

    }

    /**
     * Conta quante volte un numero compare in una matrice
     *
     * @param matrice il vettore
     * @param num il numero da cercare
     * @return quante volte la stringa x compare nella matrice
     */
    public static int conta(int[][] matrice, int num) {
        int conta = 0;
        for (int k = 0; k < matrice.length; k++) {
            for (int l = 0; l < matrice[0].length; l++) {
                if (num == matrice[k][l]) {
                    conta++;
                }
            }
        }
        return conta;
    }

    /**
     * crea una lista con solo multipli di un numero a scelta
     *
     * @param <T> classe numerica generica
     * @param lista lista di numeri interi
     * @param parametro numero di cui i numeri devo essere multipli
     * @return lista di multipli del parametro
     */
    public static <T extends Number> ArrayList<T> arrayMultipli(ArrayList<T> lista, double parametro) {
        ArrayList<T> lista1 = new ArrayList();

        //riempiamo il vettore con i numeri che ci servono
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).doubleValue() % parametro == 0) {
                lista1.add(lista.get(i));
            }
        }
        /*return*/
        return lista1;

    }

    /**
     * questa funzione crea l'elenco di una lista
     *
     * @param <T> classe numerica generica
     * @param lista lista di numeri interi
     * @return l'elenco dei numeri contenuti all'interno della lista
     */
    public static <T extends Number> String elenco(ArrayList<T> lista) {

        //elenco
        String elenco = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i != lista.size() - 1) {
                elenco = elenco + lista.get(i) + ",";
            } else {
                elenco = elenco + lista.get(i) + ".";
            }
        }
        /*return*/ return elenco;

    }

    /**
     * restituisce la copia completa di una lista
     *
     * @param <T> tipo generico
     * @param lista lista di dati
     * @return lista con gli stessi valori e lunghezza della lista passata
     */
    public static <T> ArrayList<T> getCopy(ArrayList<T> lista) {

        ArrayList<T> lista1 = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            lista1.add(lista.get(i));
        }

        return lista1;

    }

}
