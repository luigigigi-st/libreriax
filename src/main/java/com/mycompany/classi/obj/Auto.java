/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import libreriax.console.input;

/*
‐ targa 
‐ velocità 
‐ velocità massima possibile dell’auto 
‐ auto accesa o spenta 
‐ quantità di carburante nel serbatoio 
‐ capacità del serbatoio 
 */
public class Auto implements Serializable{

    private String targa;
    private double velocità;
    private double velocitàMax;
    private boolean stato;
    private double quantità;
    private double capacità;

    public Auto(String targa, double velocità, double velocitàMax, boolean stato, double quantità, double capacità) {
        this.targa = targa;
        this.velocità = velocità;
        this.velocitàMax = velocitàMax;
        this.stato = stato;
        this.quantità = quantità;
        this.capacità = capacità;
    }

    public String getTarga() {
        return this.targa;
    }

    public double getVMax() {
        return this.velocitàMax;
    }

    public double getV() {
        return this.velocità;
    }

    public boolean getStato() {
        return this.stato;
    }

    public double getQuantità() {
        return this.quantità;
    }

    public double getCapacità() {
        return this.capacità;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setVMax(double vMax) {
        this.velocitàMax = vMax;
    }

    public void setV(double v) {
        this.velocità = v;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public void setQuantità(double quantità) {
        this.quantità = quantità;
    }

    public void setCapacità(double capacità) {
        this.capacità = capacità;
    }

    public String toString() {
        if (this.stato) {
            return "targa:" + this.targa + "\tv:" + this.velocità + "\tv max:" + this.velocitàMax + "\tstato:accsesa\tquantità di carburante:" + quantità + "\tcapacità:" + this.capacità;
        } else {
            return "targa:" + this.targa + "\tv:" + this.velocità + "\tv max:" + this.velocitàMax + "\tstato:spenta\tquantità di carburante:" + quantità + "\tcapacità:" + this.capacità;
        }
    }

    //metodi statici
    static boolean checkRisposta(String risposta) {
        return risposta.equalsIgnoreCase("accesa") || risposta.equalsIgnoreCase("spenta");
    }

    /**
     * inserimento dello stato della macchina (on/off)
     *
     * @param messaggio messaggio da mandare per l'inserimento del dato
     * @param errore messaggio nel caso non vada bene
     * @return accesa o spenta
     */
    static String inputStato(String messaggio, String errore) {
        Scanner isa = new Scanner(System.in);

        System.out.print(messaggio);
        String risposta = isa.nextLine();

        while (!checkRisposta(risposta)) {
            System.out.print(errore);
            risposta = isa.nextLine();
        }

        return risposta;

    }

    /**
     * conta quante macchine sono presenti nella lista che possiedono una
     * determinata targa
     *
     * @param lista lista di auto
     * @param targa targa dell'auto interessata
     * @return numero di presenze
     */
    static int contaAuto(ArrayList<Auto> lista, String targa) {
        int conta = 0;
        for (int j = 0; j < lista.size(); j++) {
            if (targa.equalsIgnoreCase(lista.get(j).targa)) {
                conta++;
            }
        }

        return conta;
    }

    

    /**
     * input della quantità di carburante
     *
     * @param messaggio messaggio da mandare per l'inserimento del dato
     * @param errore messaggio nel caso non vada bene
     * @param capacità
     * @return quantità di carburante
     */
    static double inputQuantità(String messaggio, String errore, String errore1, double capacità) {
        double benzi = input.DoublePositivo(messaggio, errore);

        while (benzi > capacità) {
            benzi = input.DoublePositivo(errore1, errore);
        }

        return benzi;

    }

    /**
     * input della velocità
     *
     * @param messaggio messaggio da mandare per l'inserimento del dato
     * @param errore messaggio nel caso non vada bene
     * @param vMax velocità massima dell'auto
     * @return velocità dell'auto
     */
    static double inputV(String messaggio, String errore, String errore1, double vMax) {
        double velocità = input.Double(messaggio, errore);

        while (velocità > vMax) {
            velocità = input.DoublePositivo(errore1, errore);
        }

        return velocità;

    }

    /**
     * dato un auto e la quantitàdi carburantw verifica se il serbatoio pò
     * contenere quella quantità
     *
     * @param auto auto in questione
     * @param rifornimento quantià di carburante che si vuole aggiugnere
     * @return true se si può,false se non si può
     */
    static boolean checkRifornimento(Auto auto, double rifornimento) {
        return (auto.getQuantità() + rifornimento < auto.getCapacità() && !auto.getStato());

    }

    /**
     * data un'auto e la velocità che si vuole aggiungere verifica se è possibile aggiungere quest'ultima
     * la macchina deve essere accesa e la sua velocità non può andare oltre a quella max
     * @param auto auto
     * @param accelerazione velocità da aggiungere
     * @return true se si può aggiungere,false se non si può
     */
    static boolean checkAccelerazione(Auto auto, double accelerazione) {
        return (auto.getV() + accelerazione < auto.getVMax() && auto.getStato());

    }

    /**
     * data un'auto e la velocità che si vuole togliere verifica se è possibile togliere questa quantità.
     * la macchina deve essere accesa e il freno non può essere maggiore della velocità con cui sta andando
     * @param auto auto
     * @param freno velocità da togliere
     * @return true se si può togliere,false se non si può
     */
    static boolean checkFreno(Auto auto, double freno) {
        return (freno <= auto.getV() && auto.getStato());

    }

    
    

//    /**
//     * trova all'interno della lista la macchina e la restituisce
//     *
//     * @param lista li di auto
//     * @param targa targa dell'auto da trovare
//     * @return oggetto auto
//     */
//    static Auto macchinina(ArrayList<Auto> lista, String targa) {
//        int ricordapos = 0;
//        for (int i = 0; i < lista.size(); i++) {
//            if (lista.get(i).targa.equalsIgnoreCase(targa)) {
//                ricordapos = i;
//                break;
//
//            }
//        }
//        return lista.get(ricordapos);
//
//    }
}
