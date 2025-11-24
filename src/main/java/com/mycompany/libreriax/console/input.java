/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.console;

import java.time.LocalTime;
import com.mycompany.libreriax.utils.Truth;
import java.util.Scanner;
import java.util.Random;
import com.mycompany.libreriax.array.ArrayNum;
import com.mycompany.libreriax.utils.Strings;

public class input {

    private static Scanner isa = new Scanner(System.in);

    /**
     * inserimento di n numeri
     *
     * @param vettore vettore vuoto
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * intero
     */
    public static void inputN(int[] vettore, String messaggio, String errore) {

        for (int i = 0; i < vettore.length; i++) {
            int num = input.Int(messaggio, errore);
            vettore[i] = num;

        }
    }

    /**
     * input di un numero intero
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * intero
     * @return numero intero
     */
    public static int Int(String messaggio, String errore) {
        //input
        System.out.print(messaggio);
        String num = isa.nextLine().trim();

        //controllo
        while (!Truth.checkInt(num)) {
            System.out.print(errore);
            num = isa.nextLine().trim();

        }

        /*return*/ return Integer.parseInt(num);

    }

    /**
     * input di un numero intero positivo
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * ntero
     * @return numero intero
     */
    public static int IntPositivo(String messaggio, String errore) {
        //input
        System.out.print(messaggio);
        String num = isa.nextLine().trim();

        //controllo
        while (!Truth.checkIntPositivo(num)) {
            System.out.print(errore);
            num = isa.nextLine().trim();

        }

        /*return*/ return Integer.parseInt(num);

    }

    
     /**
     * input di un numero intero maggiore o uguale a 0
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * ntero
     * @return numero intero
     */
    public static int IntPositivoORNeutro(String messaggio, String errore) {
        //input
        System.out.print(messaggio);
        String num = isa.nextLine().trim();

        //controllo
        while (!Truth.checkIntPositivoORNeutro(num)) {
            System.out.print(errore);
            num = isa.nextLine().trim();
        }

        /*return*/ return Integer.parseInt(num);

    }
    
    /**
     * input di un numero double
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * double
     * @return numero double
     */
    public static double Double(String messaggio, String errore) {
        //input
        System.out.print(messaggio);
        String num = isa.nextLine().trim();

        //controllo
        while (!Truth.checkDouble(num)) {
            System.out.print(errore);
            num = isa.nextLine().trim();

        }

        /*return*/ return Double.parseDouble(num);
    }

    /**
     * input di un numero intero
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * intero
     * @return numero intero
     */
    public static double DoublePositivo(String messaggio, String errore) {
        //input
        System.out.print(messaggio);
        String num = isa.nextLine().trim();

        //controllo
        while (!Truth.checkDoublePositivo(num)) {
            System.out.print(errore);
            num = isa.nextLine().trim();
        }

        /*return*/ return Double.parseDouble(num);

    }

    /**
     * input di un numero double.NON FUNZIONA completamente poichè quando
     * moltiplico il 3 per base 10 tira fuori un numero con la virgola e
     * sminchia tutto
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * double
     * @return numero double
     */
    private static double parseDoubleGiggi(String messaggio, String errore) {
        //input
        System.out.print(messaggio);
        String num = isa.nextLine();

        //controllo
        while (!Truth.checkDouble(num)) {
            System.out.print(errore);
            num = isa.nextLine();

        }

        /*conto quanti punti ci sono ('.'--->46-48=-2)*/
        int conta = Strings.contaCarattere(num, '.');

        //retutrn
        if (conta == 0) {
            //se non è presente alcuna virgola restituisco il numero cosi com'è    
            return Integer.parseInt(num);
        } else {
            //altrimenti mi devo spaccare in due per restituirlo
            /*pos del punto*/
            int ricordapos = Strings.ricordaPosCarattere(num, '.');

            //porto i caratteri su un vettore e lavoro con i numeri e non xon caratteri
            /*non mi serve la prima casella poichè dopo devo parire dalla pos 1*/
            int[] vettore = new int[1];
            for (int i = ricordapos + 1; i < num.length(); i++) {
                vettore = ArrayNum.add(vettore, (num.charAt(i) - 48));
            }

            //2.sommo le cifre  
            String supporto = "";
            for (int i = 0; i < ricordapos; i++) {
                supporto = supporto + (num.charAt(i) - 48);/*oppure supporto+(char)num.charAt(i);*/
            }

            double somma = (double) Integer.parseInt(supporto);

            for (int i = 1; i < vettore.length; i++) {
                /*ho usato controllo perchè mi è servito per vedere cosa non andava (e non capisco ancora perchè il 3 si comporta così*/
                double controllo = Math.pow(10, -i) * vettore[i];
                //System.out.println("Controllo:" + controllo);
                somma = somma + controllo;
            }
            //System.out.println("");
            return somma;
        }
    }

    /**
     * input di un numero float
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * @return numero float
     */
    public static float Float(String messaggio, String errore) {
        //input 
        System.out.print(messaggio);
        String stringa = isa.nextLine().trim();

        //controllo e fallo reinserire
        while (!Truth.checkFloat(stringa)) {
            System.out.println(errore);
            stringa = isa.nextLine().trim();
        }

        return Float.parseFloat(stringa); //return

    }

    /**
     * input di un numero float
     *
     * @param messaggio messaggio che chiede di inserire il dato
     * @param errore il messaggio di errore se il dato inserito non è un numero
     * @return numero float
     */
    public static float FloatPositivo(String messaggio, String errore) {
        //input 
        System.out.print(messaggio);
        String stringa = isa.nextLine().trim();

        //controllo e fallo reinserire
        while (!Truth.checkFLoatPositivo(stringa)) {
            System.out.println(errore);
            stringa = isa.nextLine().trim();
        }

        return Float.parseFloat(stringa); //return

    }

    /**
     * inserimento di n stringhe
     *
     * @param vettore vettore vuoto
     * @param messaggio messaggio che chiede di inserire il dato
     */
    public static void inputStringN(String[] vettore, String messaggio) {
        for (int i = 0; i < vettore.length; i++) {
            System.out.print(messaggio);
            String stringa = isa.nextLine();
            vettore[i] = stringa;
        }
    }

    /**
     * inserire all'interno di un vettore n numeri casuali con un determinato
     * range
     *
     * @param vettore vettore di n lunghezza in cui inserire i numeri
     * @param estremoMin estremi minore
     * @param estremoMax estremo maggiore
     */
    public static void inputNumRandom(int[] vettore, int estremoMin, int estremoMax) {
        Random random = new Random();
        //genero numeri
        for (int i = 0; i < vettore.length; i++) {
            int num = random.nextInt(estremoMax - estremoMin + 1) + estremoMin;
            vettore[i] = num;
        }

    }

    /**
     * inserisce all'interno di una matrice n numeri casuali con un determinato
     * range
     *
     * @param matrice matrice di n lunghezza in cui inserire i numeri
     * @param estremoMin estremi minore
     * @param estremoMax estremo maggiore
     */
    public static void inputNumRandom(int[][] matrice, int estremoMin, int estremoMax) {
        Random random = new Random();
        //genero numeri
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                int num = random.nextInt(estremoMax - estremoMin + 1) + estremoMin;
                matrice[i][j] = num;
            }
        }

    }

    /**
     * input di un carattere
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param errore messaggio di errore da mostrare in output nel caso di
     * inserimento errato
     * @return carattere
     */
    public static char Char(String messaggio, String errore) {
        System.out.print(messaggio);
        String stringa = isa.nextLine();

        while (stringa.length() != 1) {
            System.out.print(errore);
            stringa = isa.nextLine();
        }

        /*retunr*/ return stringa.charAt(0);
    }

    /**
     * input di un numero binario
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param errore messaggio di errore da mostrare in output nel caso di
     * inserimento errato
     * @return numero binario
     */
    public static String Binario(String messaggio, String errore) {
        System.out.print(messaggio);
        String stringa = isa.nextLine().trim();

        while (!Truth.checkBinario(stringa)) {
            System.out.print(errore);
            stringa = isa.nextLine().trim();
        }

        return stringa;

    }

    /**
     * input di una stringa solo lettere
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param errore messaggio di errore da mostrare in output nel caso di
     * inserimento errato
     * @return parola
     */
    public static String Parola(String messaggio, String errore) {
        System.out.print(messaggio);
        String stringa = isa.nextLine();

        while (!Truth.checkParola(stringa)) {
            System.out.print(errore);
            stringa = isa.nextLine();
        }

        return stringa;
    }

    /**
     * input di una stringa solo lettere
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param errore messaggio di errore da mostrare in output nel caso di
     * inserimento errato
     * @return parola
     */
    public static String Parole(String messaggio, String errore) {
        System.out.print(messaggio);
        String stringa = isa.nextLine().trim();

        while (!Truth.checkParole(stringa)) {
            System.out.print(errore);
            stringa = isa.nextLine().trim();
        }

        return stringa;
    }

    /**
     * input di un numero di telefono
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param errore messaggio di errore da mostrare in output nel caso
     * diinserimento errato
     * @return numero di telefono
     */
    public static long numeroTelefono(String messaggio, String errore) {
        System.out.print(messaggio);
        String stringa = isa.nextLine().trim();

        while (!Truth.checkNTelefono(stringa)) {
            System.out.print(errore);
            stringa = isa.nextLine().trim();
        }

        return Long.parseLong(stringa);

    }

    /**
     * input di un LocalTime
     *
     * @param errore messaggio di errore da mostrare in output nel caso
     * diinserimento errato
     * @return dato LocalTime
     */
    public static LocalTime LocalTime(String errore) {

        int ore = IntPositivoORNeutro("ore:", "inseriscimi un valore positivo grazie:");
        int min = IntPositivoORNeutro("min", "inseriscimi un valore positivo grazie:");
        int sec = IntPositivoORNeutro("sec", "inseriscimi un valore positivo grazie:");

        while (!Truth.checkTime(ore, min, sec)) {
            System.out.println(errore);
            ore = IntPositivoORNeutro("ore:", "inseriscimi un valore positivo grazie:");
            min = IntPositivoORNeutro("min", "inseriscimi un valore positivo grazie:");
            sec = IntPositivoORNeutro("sec", "inseriscimi un valore positivo grazie:");

        }

        return LocalTime.of(ore, min, sec);

    }
    
    
    /**
     * restituisce una stringa che soddisfa la richiesta data come parametro
     * @param messaggio  messaggio per l'inserimento da mostrare in output
     * @return stringa
     */
    public static String String(String messaggio){
        System.out.print(messaggio);
        return isa.nextLine();
    
    }
    
    
        /**
     * restituisce una stringa che soddisfa la richiesta data come parametro
     * @param messaggio  messaggio per l'inserimento da mostrare in output
     * @return stringa
     */
    public static String StringTrim(String messaggio){
        System.out.print(messaggio);
        return isa.nextLine().trim();
    
    }
    
    /**
     * input di stringhe contenenti soltanto "si" o "no"
     * @param messaggio messaggio da mostrare per'inserimento 
     * @param errore messaggio da mostrare nel caso non andasse bene l'input
     * @return stringa con "si" o "no"
     */
    public static String YESorNO(String messaggio,String errore){
    
        System.out.print(messaggio);
        String risp=isa.nextLine().trim();
        
        while(!Truth.check_YES_OR_NO(risp)){
            System.out.print(errore);
            risp=isa.nextLine().trim();
        }
        
        return risp;
    
    }
    
    
        /**
     * input di stringhe contenenti soltanto "si" o "no" o von la stringa passata
     * @param messaggio messaggio da mostrare per'inserimento 
     * @param errore messaggio da mostrare nel caso non andasse bene l'input
     * @param another stringa accettabile al di fuori di "si" e "No"
     * @return stringa con "si" o "no" o con la stringa passata
     */
    public static String YESorNOorAnother(String messaggio,String errore,String another){
    
        System.out.print(messaggio);
        String risp=isa.nextLine().trim();
        
        while(!Truth.check_YES_OR_NO_OR_ANOTHER(risp,another)){
            System.out.print(errore);
            risp=isa.nextLine().trim();
        }
        
        return risp;
    
    }

}
