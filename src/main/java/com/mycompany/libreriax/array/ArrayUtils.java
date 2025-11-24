/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author migna
 */
public class ArrayUtils {

    /**
     * prende una colonna di una lista di liste data il numero di
     * essa<br></br><br></br>
     * es:{<br></br>
     * {2,4,gino}<br></br>
     * {tino,2,5}<br></br>
     * {tynu,78}<br></br>
     * }<br></br><br></br>
     * col:3<br></br>
     * return:{gino,5}
     *
     * @param <T> genric type
     * @param lista lista da cui prendere i dati
     * @param col numero della colonna della lista da cui prendere i dati
     * @return colonna della lista
     */
    public static <T> ArrayList<T> getColonna(ArrayList<ArrayList<T>> lista, int col) {

        ArrayList<T> list = new ArrayList<T>();

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).size(); j++) {
                if (j == col) {
                    list.add(lista.get(i).get(j));
                }
            }
        }

        return list;

    }

    /**
     * prende una colonna di una lista di liste data il numero di
     * essa<br></br><br></br>
     * es:{<br></br>
     * {2,4,gino}<br></br>
     * {tino,2,5}<br></br>
     * {tynu,78}<br></br>
     * }<br></br><br></br>
     * col:3<br></br>
     * return:{gino,5}
     *
     * @param lista lista da cui prendere i dati
     * @param col numero della colonna della lista da cui prendere i dati
     * @return colonna della lista
     */
    public static ArrayList getColonnaALL(ArrayList<ArrayList> lista, int col) {

        ArrayList list = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).size(); j++) {
                if (j == col) {
                    list.add(lista.get(i).get(j));
                }
            }
        }

        return list;

    }

    /**
     * data un hashmap e parte della chiave restituisce tutti i valori che hanno
     * chiavi che contenogo quella parte
     *
     * @param hm hashmap su cui fare la ricerca
     * @param chiave_contenuta parte della chiave.pezzo di stringa contenuta
     * nella chiave da cercare
     * @return hashmpa con chiavi che contengono la stringa passata
     */
    public static HashMap<String, Object> getByContains(HashMap<String, Object> hm, String chiave_contenuta) {

        HashMap<String, Object> hm1 = new HashMap<>();

        hm.forEach((chiave, ent) -> {

            if (chiave.contains(chiave_contenuta)) {
                hm1.put(chiave, ent);
            }

        });

        return hm1;

    }

    /**
     * data un hashmap e parte della chiave restituisce il primo valore che ha
     * chiavi che contenogo quella parte
     *
     * @param hm hashmap su cui fare la ricerca
     * @param chiave_contenuta parte della chiave.pezzo di stringa contenuta
     * nella chiave da cercare
     * @return array lungo 2 contenente [0]:chiave,[1]:valore
     */
    public static Object[] getByContainsFirst(HashMap<String, Object> hm, String chiave_contenuta) {

        Object[] vett = new Object[2];

        hm.forEach((chiave, ent) -> {

            if (chiave.contains(chiave_contenuta) && vett[0] == null) {
                vett[0] = chiave;
                vett[1] = ent;
            }

        });

        return vett;

    }

    
    /**
     * verifica se all'interno dell'array è presente almeno un valore null
     * @param <T> tipo generico
     * @param vett vettore di valori
     * @return true se è presente almeno un valore null,false se no
     */
    public static <T> boolean isNULL(T[] vett) {
        for (T t : vett) {
            if (t == null) {
                return false;
            }
        }
        
        return true;
    }
    
    
    /**
     * trasfroma la lista passata in una lista di stringhe
     * @param lista lista da trasformare
     * @return lista di stringhe contentente gli stessi dati
     */
    public static ArrayList<String> intoString(ArrayList lista) {

        ArrayList<String> l = new ArrayList<>();

        for (Object o : lista) {
            l.add(o.toString());
            System.out.println("bum");
        }

        return l;

    }


    
    
    
    
    

}
