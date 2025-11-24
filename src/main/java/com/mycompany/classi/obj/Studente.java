/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi.obj;

import com.mycompany.classi.obj.Persona;
import java.util.Objects;

public class Studente extends Persona {

    private int matricola;
    private String corso;



    public Studente(int matricola, String corso) {
        super("");
        this.matricola = matricola;
        this.corso = corso;
    }

    public Studente(int matricola,String corso,String nome) {
        super("",nome);
        this.matricola = matricola;
        this.corso = corso;
    }

    public Studente(int matricola, String corso,String nome, String cognome) {
        super("",cognome, nome);
        this.matricola = matricola;
        this.corso = corso;
    }

    public Studente(String nome,int matricola) {
        super("",nome);
        this.matricola = matricola;
        this.corso = "sconosciuto";
    }



    public int getMatricola(){return matricola;}
    public String getCoroso(){return corso;}
    
    public void setMatricola(int m){if(m>=0)matricola=m;}
    public void setCorso(String s){corso=s.trim();}
    
    
    
    

}
