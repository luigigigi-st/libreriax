/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.GestoreObjs;

import classi.GestoreObjs.Risultato;

import java.io.File;
import java.util.ArrayList;

import com.mycompany.libreriax.console.FilesTxt;
import com.mycompany.libreriax.console.FileUtils;
import com.mycompany.libreriax.utils.Truth;

/**
 *
 * @author migna
 * @param <T> obj generico
 */
public abstract class GestoreObj<T> {

    protected Risultato r;
    protected File fileObj, fileId;

    /**
     * scruve l'obj passato su un file nella modalità decisa dal parametro boolean passato
     * @param obj obj da scrivere
     * @param append modalità con cui scrivere sul file
     */
    public abstract void write(T obj, boolean append);

    /**
     * scrive la lista passata su un file nella modalità decisa dal parametro boolean passato
     * @param lista lista di obj da scrivere
     * @param append modalità con cui scrivere sul file
     */
    public abstract void write(ArrayList<T> lista, boolean append);

    /**
     * legge un file contenente gli obj
     * @return lista degli obj contenuti nel file
     */
    public abstract ArrayList<T> read();

    /**
     * elimina una riga
     *
     * @param pos
     */
    public void remove(int pos) {

        try {
            FilesTxt.remove_line(fileObj, pos);
            r.setSuccesso(true);
        } catch (Exception ex) {
            r.fallito(ex);
        }

    }

    /**
     * crea i file necessari se non esistono
     */
    public void createFilesIfNotExist() {

        try {
            FileUtils.createIfNotExists(fileObj); //creo il file dell'obj 
            FileUtils.createIfNotExists(fileId); //creo il file dell'id
            r.setSuccesso(true);
        } catch (Exception ex) {
            r.fallito(ex);
        }

    }

    /**
     * data la pos di una riga restituisce l'obj presente
     *
     * @param pos riga in cui prendere l'obj
     * @return
     */
    public T get(int pos) {

        ArrayList<T> lista = read();

        if (r.isSuccesso()) {
            if (Truth.checkPos(lista, pos)) {
                return lista.get(pos);
            }
        }

        return null;

    }

    public boolean isSuccesso() {
        return r.isSuccesso();
    }

    public String getMessage() {
        return r.getMessage();
    }

}
