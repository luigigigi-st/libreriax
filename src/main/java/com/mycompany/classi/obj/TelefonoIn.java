/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package classi.obj;

import java.io.Serializable;

 /*
crea una classe Telefono  che ha per attributi:percentuale,se è connesso a internet o no,se 
è acceso o no,se è sbloccato o no,quanta memoria libera ha

vreare i metodi:getter e setter per tutti gli attributi,metodo carica,scarica,accnesione,spegnimento,aggiunta di gb,diminuzione di gb

creare 2 costruttori

 */
public class TelefonoIn implements Serializable {

    private int batteria;
    private boolean stato, statoOnline, bloccato;
    private final float memoria;
    private float gb;

    public TelefonoIn() {

        this.batteria = 60;
        this.stato = false;
        this.statoOnline = false;
        this.bloccato = true;
        this.memoria = 1;

    }

    public TelefonoIn(int batteria, boolean stato, boolean statoOnline, boolean bloccato, float memoria, float gb) {

        this.batteria = batteria;
        this.stato = stato;
        this.statoOnline = statoOnline;
        this.bloccato = bloccato;
        this.memoria = memoria;
        this.gb = gb;

    }

    public void caricaBatteria(int carica) {
        if (this.batteria + carica <= 100 && carica >= 0) {
            this.batteria += carica;
        }
    }

    public void scaricaBatteria(int carica) {
        if (this.batteria - carica >= 0 && carica >= 0) {
            this.batteria -= carica;
        }
    }

    public void accensione() {
        if (!this.stato) {
            this.stato = true;
        }
    }

    public void spegnimento() {
        if (this.stato) {
            this.stato = true;
        }
    }

    public void aggiuntaGb(float valore) {
        if (this.gb + valore <= memoria && valore >= 0) {
            this.gb += valore;
        }
    }
    
    public void diminuzioneGb(float valore) {
        if (this.gb - valore <= memoria && valore >= 0) {
            this.gb -= valore;
        }
    }

}
