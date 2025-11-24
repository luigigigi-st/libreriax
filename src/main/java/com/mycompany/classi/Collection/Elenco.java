/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.Collection;

import java.util.ArrayList;

public class Elenco<T> {

    protected ArrayList<T> lista;

    public Elenco() {
        lista = new ArrayList();
    }

    public Elenco(ArrayList<T> lista) {
        this.lista = lista;
    }

    private boolean checkPos(int pos){return pos<lista.size() && pos>=0;}
    
    /**
     * aggiunta di un contatto in rubrica
     * @param c contatto da aggiungere
     */
    public void add(T c){if(!lista.contains(c)) lista.add(c);} 
    
     /**
     * aggiunta di un contatto in rubrica
     * @param c contatto da aggiungere
     * @param pos pos in cui deve essere aggiunto un obj
     */
    public void add(T c,int pos){if(!lista.contains(c) && checkPos(pos)) lista.add(pos,c);} 
    
    /**
     * rimozione di un contatto in rubrica
     * @param c contatto da rimuovere
     */
    public void remove(T c){if(lista.contains(c)) lista.remove(c);}
    /**
     * rimozione di un contatto in rubrica
     * @param pos pos del contatto da eliminare
     */
    public void remove(int pos){if(checkPos(pos)) lista.remove(pos);}
    
    /**
     * rimuove tutti i contatti dalla rubrica
     */
    public void removeAll(){lista.clear();}
  
    public int size(){return lista.size();}
    /**
     * restituisce l'elemento che si trova nella pos data.se la pos non è valida returna null
     * @param pos pos dell'elemento da restituire
     * @return elemento che si trova nella pos data.se la pos non è valida returna null
     */
    public T get(int pos){if(checkPos(pos))return lista.get(pos);else return null;}
    
    
    public ArrayList<T> getLista(){return lista;}
    public void setLista(ArrayList<T> lista){this.lista=lista;}
    
    
    
}
