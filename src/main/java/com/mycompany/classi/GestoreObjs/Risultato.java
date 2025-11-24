/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.GestoreObjs;

/**
 *
 * @author migna
 */
public class Risultato {

    private String message;
    private boolean successo;

    public Risultato() {
        this.successo = true;
        this.message = "";
    }

    public Risultato(boolean successo, String message) {
        this.successo = successo;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    protected void setDescrizioneErrore(String message) {
        this.message = message;
    }

    public void setDescrizioneErrore(Exception ex) {
        this.message = ex.getMessage();
    }

    public boolean isSuccesso() {
        return successo;
    }

    public void setSuccesso(boolean successo) {
        this.successo = successo;
    }

    public void fallito(Exception ex) {
        successo = false;
        message = ex.getMessage();
    }

    public void fallito(String message) {
        successo = false;
        this.message = message;
    }

}
