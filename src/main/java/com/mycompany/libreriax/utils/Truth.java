/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.utils;

import java.util.ArrayList;

public class Truth {

    /**
     * Controlla se la stringa passata può essere convertita a numero int
     *
     * @param valore la stringa passata
     * @return true se può essere convertita, altrimenti false
     */
    public static boolean checkInt(String valore) {
        try {
            Integer.valueOf(valore);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * verifica se la stringa passata può essere convertita in double (funziona
     * ma non funzinale,usare quella sotto)
     *
     * @param valore stringa passata
     * @return
     */
    private static boolean checkDouble1(String valore) {
        try {

            int contaVirgole = Strings.contaCarattere(valore, '.');
            if (contaVirgole == 1) {
                String[] vettore = valore.split("\\.");
                Integer.parseInt(vettore[0]);
                Integer.parseInt(vettore[1]);
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Controlla se la stringa passata può essere convertita a numero double
     *
     * @param valore la stringa passata
     * @return true se può essere convertita, altrimenti false
     */
    public static boolean checkDouble(String valore) {
        try {
            Double.valueOf(valore);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Controlla se la stringa passata può essere convertita a numero float
     *
     * @param valore stringa passata al cui interno probabile numero float
     * @return true se puà essere castato in float,false se non può
     */
    public static boolean checkFloat(String valore) {
        try {
            Float.valueOf(valore);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * controlla se la stringa passata può essere convertita in un boolean
     *
     * @param valore stringa passata al cui interno possibile boolean
     * @return true se può essere convertito in boolean,false se non può
     */
    public static boolean checkBoolean(String valore) {
        try {
            Boolean.valueOf(valore);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    /**
     * se non si può trasformare in nessun tipo di valore significa che può
     * rimanere soltanto come una stringa
     *
     * @param valore stringa da verrificare
     * @return true se può essere solo una stringa,false se no
     */
    public static boolean checkString(String valore) {
        return !checkInt(valore) && !checkBoolean(valore) && !checkDouble(valore) && !checkFloat(valore);
    }

    /**
     * Controlla se la stringa passata può essere convertita a numero float
     * positivo
     *
     * @param valore la stringa passata
     * @return true se può essere convertita, altrimenti false
     */
    public static boolean checkFLoatPositivo(String valore) {
        try {
            float num = Float.parseFloat(valore);
            return (num > 0);
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Controlla se la stringa passata può essere convertita a numero int
     * positivo
     *
     * @param valore la stringa passata
     * @return true se può essere convertita, altrimenti false
     */
    public static boolean checkIntPositivo(String valore) {
        try {
            int num = Integer.parseInt(valore);
            return (num > 0);
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Controlla se la stringa passata può essere convertita a numero int
     * maggiore o uguale a 0
     *
     * @param valore la stringa passata
     * @return true se può essere convertita, altrimenti false
     */
    public static boolean checkIntPositivoORNeutro(String valore) {
        try {
            int num = Integer.parseInt(valore);
            return (num >= 0);
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Controlla se la stringa passata può essere convertita a numero int
     * positivo
     *
     * @param valore la stringa passata
     * @return true se può essere convertita, altrimenti false
     */
    public static boolean checkDoublePositivo(String valore) {
        try {
            double num = Double.parseDouble(valore);
            return (num > 0);
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * verifica se la posizione inserita dall'utente è presente nel vettore (pos < 0 || pos
     * > vettore.length);
     *
     *
     * @param vettore vettore di interi
     * @param pos posizione
     * @return ture se la pos è accettabile,false se non lo è
     */
    public static boolean checkPos(int[] vettore, int pos) {
        return (pos >= 0 && pos < vettore.length);
    }

    /**
     * verifica se la posizione inserita dall'utente è presente nel vettore (pos < 0 || pos
     * > vettore.length);
     *
     *
     * @param vettore vettore di interi
     * @param pos posizione
     * @return ture se la pos è accettabile,false se non lo è
     */
    public static boolean checkPos(double[] vettore, int pos) {
        return (pos >= 0 && pos < vettore.length);
    }

    /**
     * verifica se la posizione inserita dall'utente è presente nel vettore (pos < 0 || pos
     * > vettore.length);
     *
     *
     * @param <T> generico
     * @param vettore vettore generico
     * @param pos posizione
     * @return ture se la pos è accettabile,false se non lo è
     */
    public static <T> boolean checkPos(T[] vettore, int pos) {
        return (pos >= 0 && pos < vettore.length);
    }

    /**
     * verifica se la posizione inserita dall'utente è presente nel vettore (pos < 0 || pos
     * > lista.size);
     *
     *
     * @param <T> generico
     * @param lista lista generica
     * @param pos posizione da verificare
     * @return ture se la pos è accettabile,false se non lo è
     */
    public static <T> boolean checkPos(ArrayList<T> lista, int pos) {
        return (pos >= 0 && pos < lista.size());
    }
    
    
        /**
     * verifica se la posizione inserita dall'utente è presente nel vettore (pos < 0 || pos
     * > str.length);
     *
     *
     * @param str
     * @param pos posizione da verificare
     * @return ture se la pos è accettabile,false se non lo è
     */
    public static boolean checkPos(String str, int pos) {
        return (pos >= 0 && pos < str.length());
    }

    /**
     * verifica se nella stringa sono presenti solo cifre binarie
     *
     * @param stringa stringa
     * @return true se sono presenti,false se non sono presenti
     */
    public static boolean checkBinario(String stringa) {

        //controllo subito se sono soltanto cifre
        if (Truth.checkIntPositivo(stringa)) {
            int conta = 0;

            //conto le cifre binarie (possono essere solo 1 o 0)
            for (int i = 0; i < stringa.length(); i++) {
                if (stringa.charAt(i) == 48 || stringa.charAt(i) == 49) {
                    conta++;

                }
            }

            //controllo e return
            return conta == stringa.length();

        } else {
            return false;
        }

    }

    /**
     * verofoca se il numeri è compreso nell'intervallo (>=/<=)
     *
     * @param n numero da verificare
     * @param intervallo1 estremo inferiore
     * @param intervallo2 estremo estremo maggiore
     * @return true se è compreso,false se non lo è
     */
    public static boolean checkIntervalloE(double n, double intervallo1, double intervallo2) {

        if (intervallo1 < intervallo2) {
            return (n >= intervallo1 && n <= intervallo2);
        } else if (intervallo2 < intervallo1) {
            return (n >= intervallo2 && n <= intervallo1);
        } else {
            return (n == intervallo1);
        }
    }
    
    
    
        /**
     * verofoca se il numeri è compreso nell'intervallo (>/<)
     *
     * @param n numero da verificare
     * @param intervallo1 estremo inferiore
     * @param intervallo2 estremo estremo maggiore
     * @return true se è compreso,false se non lo è
     */
    public static boolean checkIntervallo(double n, double intervallo1, double intervallo2) {

        if (intervallo1 < intervallo2) {
            return (n > intervallo1 && n < intervallo2);
        } else if (intervallo2 < intervallo1) {
            return (n > intervallo2 && n < intervallo1);
        } else {
            return (n == intervallo1);
        }
    }

    /**
     * controlla se la stringa è una parola o no (formata da solo lettere)
     *
     * @param stringa stringa
     * @return true se sono tuttte lettere,false se non lo è
     */
    public static boolean checkParola(String stringa) {

        boolean check = true;

        //appena incontro un carattere diverso da una lettera allora so che non è una parola
        for (int i = 0; i < stringa.length(); i++) {
            if (!(stringa.charAt(i) >= 65 && stringa.charAt(i) <= 90 || stringa.charAt(i) >= 97 && stringa.charAt(i) <= 122)) {
                check = false;
                break;
            }
        }

        /*return*/ return check;
    }

    /**
     * controlla se la stringa è una parola o no (formata da solo lettere)
     *
     * @param stringa stringa
     * @return true se sono tuttte lettere,false se non lo è
     */
    public static boolean checkParole(String stringa) {

        boolean check = true;

        //appena incontro un carattere diverso da una lettera allora so che non è una parola
        for (int i = 0; i < stringa.length(); i++) {
            if (!(stringa.charAt(i) >= 65 && stringa.charAt(i) <= 90 || stringa.charAt(i) >= 97 && stringa.charAt(i) <= 122 || stringa.charAt(i) == 32)) {
                check = false;
                break;
            }
        }

        /*return*/ return check;
    }

    /**
     * verifica se la stringa passata è un si o no o another
     *
     * @param stringa stringa contenente la rispota
     * @param another la stringa può essere ugguale anche a questa
     * @return true se la risposta è o no o si o another,false se non è nessuno dei 3
     */
    public static boolean check_YES_OR_NO_OR_ANOTHER(String stringa,String another) {
        return (stringa.trim().equalsIgnoreCase("si") || stringa.trim().equalsIgnoreCase("no") || stringa.trim().equalsIgnoreCase(another));

    }
    
    
        /**
     * verifica se la stringa passata è un si o no
     *
     * @param stringa stringa contenente la rispota
     * @return true se la risposta è o no o si,false se non è nessuno dei 2
     */
    public static boolean check_YES_OR_NO(String stringa) {
        return (stringa.trim().equalsIgnoreCase("si") || stringa.trim().equalsIgnoreCase("no"));

    }

    public static boolean checkNTelefono(String numero) {
        try {
            if (numero.length() == 10) {
                Long.parseLong(numero);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }

    }

    /**
     * verifica se la data,oassata ore,min e sec,si può convertire in LocalTime
     *
     * @param ore ore
     * @param min minuti
     * @param sec secondi
     * @return true se va bene,false se no
     */
    public static boolean checkTime(int ore, int min, int sec) {
        return min < 60 && sec < 60 && ore >= 0;
    }

    /**
     * verifica se un numero decimale può essere diviso per 2
     *
     * @param n numero da verificare
     * @return true se può essere diviso per 2,false se no
     */
    public static boolean checkPari(double n) {
        //opero con le stringhe in quanto lavorando con i numeri non viene in tutti i casi
        String str = n + "";
        String[] v = str.split("\\.");
        int parteIntera = Integer.parseInt(v[0]); //parte intera del numero
        int parteDecimale = Integer.parseInt(v[1]); //parte dispari del numero

        return parteIntera % 2 == 0 && (parteDecimale % 2 == 0 || parteDecimale == 0);

    }

    /**
     * verifica se il carattere passato è una vocale 
     * @param c carattere da verificare
     * @return true se è una vocale,false se no
     */
    public static boolean checkVocale(char c) {
        return c == 97 || c == 101 || c == 105 || c == 111 || c == 117 || c == 65 || c == 69 || c == 73 || c == 79 || c == 85;
    }



    /**
     * verifica se il carattere passato è una consonante 
     * @param c carattere da verificare
     * @return true se è una consonante,false se no
     */
    public static boolean checkConsonante(char c) {
        return Character.isLetter(c) && !checkVocale(c);
    }

}
