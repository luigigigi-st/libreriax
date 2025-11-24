/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import static com.mycompany.libreriax.console.input.IntPositivo;

/**
 *
 * @author user
 */
public class Datas {

    /**
     * Verifica se un anno è bisestile
     *
     * @param anno l'anno da verificare
     * @return true se è bisestile, false se non lo è
     */
    public static boolean checkBisestile(int anno) {
        // un anno è bisestile se è divisibile per 400 oppure per 4 ma non per 100
        if (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se la data composta da giorno, mese e anno è corretta
     *
     * @param giorno il giorno
     * @param mese il mese
     * @param anno l'anno
     * @return true se la data è corretta, altrimenti false
     */
    public static boolean checkData(int giorno, int mese, int anno) {
        if (giorno < 1 || giorno > 31 || mese < 1 || mese > 12) {
            return false;
        }

        if ((mese == 4 || mese == 6 || mese == 9 || mese == 11) && giorno > 30) {
            return false;
        }

        if (mese == 2 && ((checkBisestile(anno) && giorno > 29) || (!checkBisestile(anno) && giorno > 28))) {
            return false;
        }

        return true;
    }

    /**
     * input di una data da console nel formato stringa con giorno mese e anno
     * separati dal sepraratore passato
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param messaggioErrore messaggio di errore da mostrare in output nel caso
     * di inserimento errato
     * @param separatore separatore
     * @return la data inserita
     */
    public static String getDataFromInput(String messaggio, String messaggioErrore, String separatore) {
        int anno, mese, giorno;

        System.out.println(messaggio);
        giorno = IntPositivo("Inserisci il giorno: ", "Il giorno deve essere un numero positivo. Reinseriscilo: ");
        mese = IntPositivo("Inserisci il mese: ", "Il mese deve essere un numero positivo. Reinseriscilo: ");
        anno = IntPositivo("Inserisci l'anno: ", "L'anno deve essere un numero positivo. Reinseriscilo: ");

        while (!Datas.checkData(giorno, mese, anno)) {
            System.out.println(messaggioErrore);
            giorno = IntPositivo("Inserisci il giorno: ", "Il giorno deve essere un numero positivo. Reinseriscilo: ");
            mese = IntPositivo("Inserisci il mese: ", "Il mese deve essere un numero positivo. Reinseriscilo: ");
            anno = IntPositivo("Inserisci l'anno: ", "L'anno deve essere un numero positivo. Reinseriscilo: ");
        }

        return giorno + separatore + mese + separatore + anno;
    }

    /**
     * input di una data da console nel formato stringa con giorno mese e anno
     * separati dal sepraratore passato
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param messaggioErrore messaggio di errore da mostrare in output nel caso
     * di inserimento errato
     * @return la data inserita
     */
    public static LocalDate getDataFromInput(String messaggio, String messaggioErrore) {
        int anno, mese, giorno;

        System.out.println(messaggio);
        giorno = IntPositivo("Inserisci il giorno: ", "Il giorno deve essere un numero positivo. Reinseriscilo: ");
        mese = IntPositivo("Inserisci il mese: ", "Il mese deve essere un numero positivo. Reinseriscilo: ");
        anno = IntPositivo("Inserisci l'anno: ", "L'anno deve essere un numero positivo. Reinseriscilo: ");

        while (!Datas.checkData(giorno, mese, anno)) {
            System.out.println(messaggioErrore);
            giorno = IntPositivo("Inserisci il giorno: ", "Il giorno deve essere un numero positivo. Reinseriscilo: ");
            mese = IntPositivo("Inserisci il mese: ", "Il mese deve essere un numero positivo. Reinseriscilo: ");
            anno = IntPositivo("Inserisci l'anno: ", "L'anno deve essere un numero positivo. Reinseriscilo: ");
        }

        return LocalDate.of(anno, mese, giorno);

    }

    /**
     * input di una data da console nel formato stringa con giorno mese e anno
     * separati dal sepraratore passato
     *
     * @param messaggio messaggio per l'inserimento da mostrare in output
     * @param messaggioErrore messaggio di errore da mostrare in output nel caso
     * di inserimento errato
     * @param separatore separatore
     * @return la data inserita
     */
    public static String getDataFromInput1(String messaggio, String messaggioErrore, String separatore) {

        System.out.println(messaggio);
        int mese = IntPositivo("Inserisci il mese: ", "Il mese deve essere un numero positivo. Reinseriscilo: ");
        int anno = IntPositivo("Inserisci l'anno: ", "L'anno deve essere un numero positivo. Reinseriscilo: ");

        while (mese > 12) {
            System.out.println(messaggioErrore);
            mese = IntPositivo("Inserisci il mese: ", "Il mese deve essere un numero positivo. Reinseriscilo: ");
            anno = IntPositivo("Inserisci l'anno: ", "L'anno deve essere un numero positivo. Reinseriscilo: ");
        }

        return mese + separatore + anno;
    }

    /**
     * vede se la data inserita è realmente accettabile
     *
     * @param data data
     * @return true se è realistica,false se non lo è
     */
    public static boolean checkToday(LocalDate data) {
        return data.isBefore(LocalDate.now()) || data.isEqual(LocalDate.now());
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
     * converte una data dal tipo Date al tipo LocalDate
     *
     * @param data la data da convertire
     * @return la data convertita a LocalDate
     */
    public static LocalDate getLocalDate(Date data) {
        if (data == null) {
            return null;
        } else {
            return new java.sql.Date(data.getTime()).toLocalDate();
        }
    }

    /**
     * converte una data dal tipo LocalDate al tipo Date
     *
     * @param data la data da convertire
     * @return la data convertita a Date
     */
    public static java.util.Date getDate(LocalDate data) {
        if (data == null) {
            return null;
        } else {
            return Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }

}
