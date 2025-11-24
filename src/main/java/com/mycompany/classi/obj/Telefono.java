/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi.obj;

import com.mycompany.classi.obj.Persona;
import java.io.Serializable;

public class Telefono implements Serializable {

    private Persona proprietario;
    private double credito;
    private long numero;

    public Telefono(long num, Persona proprietario) {
        this.proprietario = proprietario;
        credito = 0;
        numero = num;
    }

    public Telefono(long num, Persona proprietario, double credito) {
        this.proprietario = proprietario;
        this.credito = credito;
        numero = 0;
    }

    //getter
    public Persona getProprietario() {
        return proprietario.copy();
    }

    public String getNomeProprietario() {
        return proprietario.getNome();
    }

    public String getCognomeProprietario() {
        return proprietario.getCognome();
    }

    public double getCredito() {
        return credito;
    }

    public long getNumero() {
        return numero;
    }

    public String getNumeroFormatted() {
        String stringa = numero + "", stringa1 = "";
        int conta = 0, conta1 = 0; //conta=conta quante cifre ho contato (ogni 3c'è il punto).conta1=conta dei punti:ci devo mettere solo 2 punti es:333.222.1111

        for (int i = 0; i < stringa.length(); i++) {
            if (conta == 3 && conta1 != 2) {
                stringa1 = stringa1 + ".";
                conta = 0;
                conta1++;
                i--;
            } else {
                stringa1 = stringa1 + stringa.charAt(i);
                conta++;
            }

        }
        return stringa1;

    }

    public void ricaricaCredito(float ricarica) {
        if (ricarica > 0) {
            credito += ricarica;
        }
    }

}
