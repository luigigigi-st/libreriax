/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi.obj;

import com.mycompany.classi.obj.Persona;

public class Contatto extends Persona {

    private String indirizzo;
    private long num;

    public Contatto(long num, String nome) {
        super("", nome);
        this.num = num;

    }

    public Contatto(long num, String cognome, String nome) {
        super("",cognome, nome);
        this.indirizzo = "sconosciuto";
        this.num = num;

    }

    public Contatto(long num,String cognome, String nome, String indirizzo) {
        super("",cognome, nome);
        this.indirizzo = indirizzo;
        this.num = num;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public long getNumero() {
        return num;
    }
}
