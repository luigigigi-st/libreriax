/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.GestoreObjs;

import com.mycompany.classi.obj.Persona;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.time.LocalDate;
import java.util.ArrayList;
import com.mycompany.libreriax.console.FilesTxt;

import com.mycompany.libreriax.utils.Truth;

public class GestorePersona extends GestoreObj<Persona> {

    private Risultato r;

    public GestorePersona() {
        fileObj = new File("persone.txt");
        fileId = new File("idPersone.txt");
        r = new Risultato();
    }

    public GestorePersona(String NOMEFILE) {
        fileObj = new File(NOMEFILE);
        fileId = new File("idPersone.txt");
        r = new Risultato();
    }

    public GestorePersona(File file) {
        fileObj = file;
        fileId = new File("idPersone.txt");
        r = new Risultato();
    }

    public GestorePersona(File file, File fileID) {
        fileObj = file;
        fileId = fileID;
        r = new Risultato();
    }

    public GestorePersona(String NOMEFILE, String NOMEFILEID) {
        fileObj = new File(NOMEFILE);
        fileId = new File(NOMEFILEID);
        r = new Risultato();
    }

    @Override
    public void write(Persona obj, boolean append) {
        //scrivo
        try {
            obj.setId(FilesTxt.getId(fileId));          //setto l'id 
            //verifico come scrivere
            if (append) {
                FilesTxt.write_value_append(fileObj, preparaDati(obj));
            } else {
                FilesTxt.write_value(fileObj, preparaDati(obj));
            }

            r.setSuccesso(true); //dico che è andato a buon fine
        } catch (Exception ex) {
            //dico che non è andato a buon fine
            r.setDescrizioneErrore(ex);
            r.setSuccesso(false);
        }
    }

    @Override
    public void write(ArrayList<Persona> lista, boolean append) {
        //scrivo
        try {

            if (!append) {
                FilesTxt.clear(fileObj);
            } //se vuole scrivere in modalità sovrascrittura pulisco il file per poi scrivere

            for (Persona p : lista) {
                write(p, true); //scrivo
            }

            r.setSuccesso(true); //dico che è andato a buon fine
        } catch (Exception ex) {
            //dico che non è andato a buon fine
            r.setDescrizioneErrore(ex);
            r.setSuccesso(false);
        }
    }

    @Override
    public ArrayList<Persona> read() {
        try (BufferedReader r = new BufferedReader(new FileReader(fileObj))) {
            ArrayList<Persona> lista = new ArrayList<>(); //dichiaro e inizializzo la lista che devo returnare
            String str = r.readLine();
            while (str != null) {
                Persona p = preparaDati(str); //preparo l'obj
                
                if(p==null)throw new Exception(this.r.getMessage()); //se avviene un errore nella preparaDati genere io un erroe così da finire del catch e fare le stesse identice cose

                lista.add(p); //aggiungo alla lista
                str = r.readLine(); //continuo la lettura
            }

            this.r.setSuccesso(true);
            return lista;
        } catch (Exception ex) {
            r.setDescrizioneErrore(ex);
            r.setSuccesso(false);
            return null;
        }
    }

    /**
     * restituisce la pos di una persona presente in un file (la riga) dato il
     * codice fiscale
     *
     * @param cf codisce fiscale della persona da cercare
     * @return returna: -1 se non è stato trovato nel file <br> -2 qualcosa è
     * andato storto il file
     */
    public int getPos(String cf) {

        ArrayList<Persona> lista = read();

        //se la lista è nulla significa che qualcosa è andato storto
        if (lista != null) {
            return getPos(lista, cf);
        } else {
            return -2;
        }

    }

    /**
     * restituisce la pos di una persona che è presente in una lista.se la
     * persona non è presente il metodo restituisce -1
     *
     * @param lista lista di persone
     * @param cf codice fiscale della persona da cercare
     * @return pos della persona all'interno della lista
     */
    public static int getPos(ArrayList<Persona> lista, String cf) {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodiceFiscale().equals(cf)) {
                return i;
            }
        }

        return -1;

    }

    /**
     * conta quante persone sono maggiorenni in un lista di persone
     *
     * @param lista lista di persone
     * @return numeor dei maggiorenni presenti nella lista
     */
    public static int contaMaggiorenni(ArrayList<Persona> lista) {
        int conta = 0;
        for (Persona p : lista) {
            if (p.checkMaggioreEtà()) {
                conta++;
            }

        }

        return conta;

    }

    /**
     * conta quante persone sono maggiorenni in un file di persone
     *
     * @return numero dei maggiorenni presenti nel file.<br>N.B. nel caso
     * qualcosa fosse andato storto nella lettura del file restituisce -1
     */
    public int contaMaggiorenni() {

        ArrayList<Persona> lista = read(); //creo la lista di persone

        //se il file esiste restituisco il numero altrimwnti returno -1 
        if (lista != null) {
            return contaMaggiorenni(lista);
        } else {
            return -1;
        }

    }

    /**
     * data una lette verifica se l'iniziale del cognome della persona passata
     * coincidono
     *
     * @param p persona
     * @param iniziale lettera da verificare
     * @return true se coincidono,false se no
     */
    public static boolean checkIniziale(Persona p, char iniziale) {
        return p.getCognome().charAt(0) == iniziale;
    }

    /**
     * data una lista di persone e un carattere restituisce una lista contenente
     * le persone che hanno l'iniziale del cognome uguale al carattere passato
     *
     * @param lista lista di persone
     * @param iniziale carattere da verificare
     * @return lista contenente le persone che hanno l'iniziale del cognome
     * uguale al carattere passato
     */
    public static ArrayList<Persona> stessaIniziale(ArrayList<Persona> lista, char iniziale) {

        ArrayList<Persona> lista1 = new ArrayList<>(); //lista che deve contenere le persone

        for (Persona p : lista) {
            if (checkIniziale(p, iniziale)) {
                lista1.add(p); //aggiungo se i 2 caratteri coincidono
            }
        }

        return lista1;

    }

    /**
     * fa l'elenco delle persone presenti in una lista
     *
     * @param lista lista di presone
     * @return elenco delle persone
     */
    public static String elenco(ArrayList<Persona> lista) {

        String elenco = ""; //stringa su cui salvo l'elenco

        for (int i = 0; i < lista.size(); i++) {
            if (i != lista.size() - 1) {
                elenco += lista.get(i) + ",";
            } else {
                elenco += lista.get(i) + ".";
            }
        }
        return elenco;

    }

    /**
     * fa l'elenco delle persone presenti in una lista con solo nome e cognome
     *
     * @param lista lista di presone
     * @return elenco delle persone
     */
    public static String elencoNomeAndCognome(ArrayList<Persona> lista) {

        String elenco = ""; //stringa su cui salvo l'elenco

        for (int i = 0; i < lista.size(); i++) {
            if (i != lista.size() - 1) {
                elenco += lista.get(i).getNomeAndCognomeFormatted() + ",";
            } else {
                elenco += lista.get(i).getNomeAndCognomeFormatted() + ".";
            }
        }
        return elenco;

    }

    /**
     * passata l'altezza verifica quante persone sono alte in quel modo
     *
     * @param lista lista di persone
     * @param altezza altezza da contare
     * @return numero di persone che hanno quell'altezza
     */
    public static int contaAltezze(ArrayList<Persona> lista, double altezza) {

        int conta = 0;

        for (Persona p : lista) {
            if (p.getAltezza() == altezza) {
                conta++;
            }
        }

        return conta;

    }

    /**
     * conta le persone, che sono contenute in una lista, che hanno l'altezza
     * compresa in un interavallo
     *
     * @param lista lista di persone
     * @param intervallo1 estremo 1
     * @param intervallo2 estremo 2
     * @return numero delle persone che hanno l'altezza compresa in un
     * interavallo
     */
    public static int contaAltezzeRange(ArrayList<Persona> lista, double intervallo1, double intervallo2) {

        int conta = 0;
        for (Persona p : lista) {
            if (Truth.checkIntervallo(p.getAltezza(), intervallo1, intervallo2)) {
                conta++;
            }

        }

        return conta;

    }

    /**
     * passato un obj persona la trasforma in una stringa cossì da scriverla su
     * un file
     *
     * @param p obj persona
     * @return stringa formattata per scriverla su un file.null se l'obj è null
     */
    private static String preparaDati(Persona p) {
        if (p == null) {
            return null;
        }
        return p.getCodiceFiscale() + "," + p.getCognome() + "," + p.getNome() + "," + p.getDataNascita() + "," + p.getAltezza() + "," + p.getPeso();
    }

    /**
     * passata una stringa la trasforma in obj persona
     * @param str stringa da trasformare in obj persona
     * @return obj persona corrispondente alla stringa passata.null se va in errore
     */
    private Persona preparaDati(String str) {

        try {
            String[] vettore = str.split(","); //splitto in un vettore
            Persona p = new Persona(vettore[0], vettore[1], vettore[2], LocalDate.parse(vettore[3]), Double.parseDouble(vettore[4]), Double.parseDouble(vettore[5])); //creo obj persona 
            r.setSuccesso(true);
            return p;
        } catch (Exception ex) {
            r.fallito(ex);
            return null;
        }

    }

}
