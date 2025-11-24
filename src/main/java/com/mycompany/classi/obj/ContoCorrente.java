package classi.obj;

import com.mycompany.classi.obj.Persona;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class ContoCorrente implements Serializable {

    //caratterustiche dell'oggetto
    //metto private per quesitone di "protezione dei dati",per poi andare a prendere questi dati nel main non andremo a scrivere obj.caratteristica ma chiameremo una funzione apposita (obj.getCaratteristica)
    private Persona persona;
    private String iban;
    private ArrayList<Movimento> importi;

    //creo l'oggetto
    //this indica che ti stai riferendo alla variabile dichiarata in QUESTA classe
    public ContoCorrente(String iban, String cf, String nome, String cognome) {
        this.importi = new ArrayList();
        persona = new Persona(nome, cognome, cf);
        this.iban = iban;
    }

    public ContoCorrente(String iban, String cf) {
        this.importi = new ArrayList();
        persona = new Persona(cf);
        this.iban = iban;
    }

    public ContoCorrente(String iban, String cf, ArrayList<Movimento> importi) {
        this.importi = importi;
        persona = new Persona(cf);
        this.iban = iban;

    }

    public ContoCorrente(String iban, String cf, String nome, String cognome, ArrayList<Movimento> importi) {
        this.importi = importi;
        persona = new Persona(nome, cognome, cf);
        this.iban = iban;
    }

    /**
     * crea l'oggetto con un al cui interno sono presenti gli attributi
     * dell'oggetto(nome,cognome,cf,iban)
     *
     * @param vettore vettore
     */
    public ContoCorrente(String[] vettore) {
        persona = new Persona(vettore[0], vettore[1], vettore[2]);
        this.iban = vettore[3];
        this.importi = new ArrayList();
    }

    /**
     * crea l'oggetto con un al cui interno sono presenti gli attributi
     * dell'oggetto(nome,cognome,cf,iban)
     *
     * @param vettore vettore di attributi dell'obj
     * @param importi lista di importi
     */
    public ContoCorrente(String[] vettore, ArrayList<Movimento> importi) {
        persona = new Persona(vettore[0], vettore[1], vettore[2]);
        this.iban = vettore[3];
        this.importi = importi;
    }

    /**
     * crea l'oggetto con un al cui interno sono presenti gli attributi
     * dell'oggetto(nome,cognome,cf,iban)
     *
     * @param persona proprietario del conto
     * @param iban iban del conto
     * @param importi lista di importi
     */
    public ContoCorrente(Persona persona, String iban, ArrayList<Movimento> importi) {
        this.persona = persona;
        this.iban = iban;
        this.importi = importi;
    }

    //getter e setter (accenato prima)
    //metto sempre i getter e i setters per convenzione e per utilità
    //getters
    //il get saldo serve per il punto 4
    public Persona getProprietario() {
        return persona.copy();
    }

    public String getNome() {
        return persona.getNome();
    }

    public String getCognome() {
        return persona.getCognome();
    }

    public String getCodiceFiscale() {
        return persona.getCodiceFiscale();
    }

    public String getIban() {
        return this.iban;
    }

    //setters //saranno void poichè andiamo a modificare le variabili e non c'è alcun tipo di return
    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setImporti(ArrayList<Movimento> lista) {
        this.importi = lista;
    }

    public ArrayList<Movimento> getMovimenti() {
        ArrayList<Movimento> lista = new ArrayList();
        for (int i = 0; i < importi.size(); i++) {
            lista.add(importi.get(i).getCopy());
        }
        return lista;
    }

    public ArrayList<Float> getPrelievi() {
        ArrayList<Float> lista = new ArrayList();
        for (Movimento m : importi) {
            if (m.getImporto() < 0) {
                lista.add(m.getImporto());
            }

        }
        return lista;

    }

    public ArrayList<Float> getVersamenti() {
        ArrayList<Float> lista = new ArrayList();
        for (Movimento m : importi) {
            if (m.getImporto() > 0) {
                lista.add(m.getImporto());
            }

        }
        return lista;

    }

    public ArrayList<Movimento> get_prelievi_movimento() {
        ArrayList<Movimento> lista = new ArrayList();
        for (Movimento m : importi) {
            if (m.getImporto() < 0) {
                lista.add(m);
            }

        }
        return lista;

    }

    public ArrayList<Movimento> get_versamenti_movimento() {
        ArrayList<Movimento> lista = new ArrayList();
        for (Movimento m : importi) {
            if (m.getImporto() > 0) {
                lista.add(m);
            }
        }
        return lista;

    }

    //azioni del conto
    /**
     * versa dei soldi nel conto corrente
     *
     * @param soldi soldi da versare
     */
    public void versa(float soldi) {
        if (soldi > 0) {
            importi.add(new Movimento(soldi));
        }
    }

    /**
     * versa dei soldi nel conto corrente in una precisa data con causale
     * sconosciuta
     *
     * @param soldi soldi da versare
     * @param data data dell'importo
     */
    public void versa(float soldi, LocalDate data) {
        if (soldi > 0 && (data.isBefore(LocalDate.now()) || data.isEqual(LocalDate.now()))) {
            importi.add(new Movimento(soldi, data));
        }
    }

    /**
     * versa dei soldi nel conto corrente in una precisa data con causale
     * conosciuta
     *
     * @param soldi importo,soldi da versare
     * @param data data dell'importo
     * @param causale causale dell'importo
     */
    public void versa(float soldi, LocalDate data, String causale) {
        if (soldi > 0 && (data.isBefore(LocalDate.now()) || data.isEqual(LocalDate.now()))) {
            importi.add(new Movimento(soldi, data, causale));
        }
    }

    /**
     * versa dei soldi nel conto corrente in una precisa data con causale
     * conosciuta
     *
     * @param movi
     *
     */
    public void versa(Movimento movi) {
        if (movi.getImporto() > 0 && (movi.getData().isBefore(LocalDate.now()) || movi.getData().isEqual(LocalDate.now()))) {
            this.importi.add(movi);
        }
    }

    /**
     * versa dei soldi nel conto corrente in una precisa data con causale
     * conosciuta
     *
     * @param soldi importo,soldi da versare
     * @param causale causale dell'importo
     */
    public void versa(float soldi, String causale) {
        if (soldi > 0) {
            importi.add(new Movimento(soldi, causale));
        }
    }

    /**
     * calcola il salso del conto corrente
     *
     * @return returna il saldo del conto
     */
    public float getSaldo() {
        float somma = 0;
        for (Movimento e : importi) {
            somma += e.getImporto();
        }
        return somma;
    }

    /**
     * verifico se il prelievo si può fare. ovviamente se la cifra è più grande
     * di quella che già c'è non si può.
     *
     * @param prelievo soldi da prelevare
     * @return true se si può,false se non si può
     */
    public boolean checkPrelievo(double prelievo) {
        return getSaldo() - prelievo >= 0 && prelievo > 0;
    }

    /**
     * verifico se il prelievo si può fare. ovviamente se la cifra è più grande
     * di quella che già c'è non si può e deve essere fatto in una data
     * realistica
     *
     * @param prelievo soldi da prelevare
     * @param data data del prelievo
     * @return true se si può,false se non si può
     */
    public boolean checkPrelievo(double prelievo, LocalDate data) {
        return getSaldo() - prelievo >= 0 && (data.isBefore(LocalDate.now()) || data.isEqual(LocalDate.now())) && prelievo > 0;
    }

    /**
     * prelievo dal conto della data di oggi con causale sconosciuta
     *
     * @param prelievo soldi da prelevare
     */
    public void prelievo(float prelievo) {
        if (checkPrelievo(prelievo, LocalDate.now())) {
            importi.add(new Movimento(prelievo * -1));
        }
    }

    /**
     * prelievo dal conto in una data specifica con causale sconosciuta
     *
     * @param prelievo soldi da prelevare
     * @param data data dell'importo
     */
    public void prelievo(float prelievo, LocalDate data) {

        if (checkPrelievo(prelievo, data)) {
            importi.add(new Movimento(prelievo * -1, data));
        }

    }

    /**
     * prelievo dal conto in una data specifica con causale conosciuta
     *
     * @param prelievo soldi da prelevare
     * @param data data dell'importo
     * @param causale causale dell'importo
     */
    public void prelievo(float prelievo, LocalDate data, String causale) {

        if (checkPrelievo(prelievo, data)) {
            importi.add(new Movimento(prelievo * -1, data, causale));
        }

    }

    /**
     * prelievo dal conto in una data specifica con causale conosciuta
     *
     * @param prelievo soldi da prelevare
     * @param causale causale dell'importo
     */
    public void prelievo(float prelievo, String causale) {

        if (checkPrelievo(prelievo)) {
            importi.add(new Movimento(prelievo * -1, causale));
        }

    }

    /**
     * versa dei soldi nel conto corrente in una precisa data con causale
     * conosciuta
     *
     * @param movi obj movimento
     */
    public void prelievo(Movimento movi) {
        if (movi.getImporto() < 0) {
            this.importi.add(movi);
        }
    }

    public String elencoMovimenti() {
        String stringa = "";

        for (Movimento m : importi) {
            stringa = stringa + m + "\n";
        }
        return stringa;

    }

    /**
     * verifica se l'importo è positivo così da formare una stringa di tutti i
     * veramenti del conto
     *
     * @return stringa con tutti i versamneti del conto
     */
    public String elencoVersamenti() {
        String stringa = "";

        for (Movimento m : importi) {
            if (m.getImporto() > 0) {
                stringa = stringa + m + "\n";
            }

        }
        return stringa;
    }

    /**
     * verifica se l'importo è negativo così da formare una stringa di tutti i
     * prelievi del conto
     *
     * @return stringa con tutti i prelievi del conto
     */
    public String elencoPrelievi() {
        String stringa = "";

        for (Movimento m : importi) {
            if (m.getImporto() < 0) {
                stringa = stringa + m + "\n";
            }

        }
        return stringa;
    }

    //metodo toString() è già presente di default tra i metodi di un obj,serve per 
    //sparare in output le caratteristiche dell'oggetto. per farlo funzionare lo 
    //dobbiamo andare a sovrascrivvvere semplicemente scirvendo la funzione a mano
    @Override
    public String toString() {
        return "nome:" + persona.getNome() + "\ncognome:" + persona.getCognome() + "\ncodice fiscale:" + persona.getCodiceFiscale() + "\niban:" + this.iban + "\nsaldo:" + getSaldo();
    }

}
