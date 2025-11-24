/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.console;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.libreriax.utils.Truth;

public class FilesTxt {

    /**
     * scrive sul file passato dall'utente l'obj interessato. N.B. fare
     * attenzione a non sovrascrivere.<br>
     * N.B. lo scrive con ObjectOutputStream
     *
     * @param obj obj da scrivere
     * @param file file in cui sono contenuti gli obj
     * @throws java.lang.Exception
     */
    public static void write_obj(Object obj, File file) throws Exception {

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
            writer.writeObject(obj);
        }

    }

    /**
     * scrive l'onj su un file.<br>N.B. lo scrive con ObjectOutputStream
     *
     * @param obj obj da scrivere
     * @param file file in cui sono contenuti gli obj
     * @throws java.lang.Exception
     */
    public static void write_obj_append(Object obj, File file) throws Exception {

        //grzie chat
        try (FileOutputStream out = new FileOutputStream(file, true)) {
            try (ObjectOutputStream writer = (file.length() > 0)
                    ? new AppendableObjectOutputStream(out)
                    : new ObjectOutputStream(out)) {
                writer.writeObject(obj);
            }
        }
    }

    /**
     * legge un file e mette gli obj che sono presenti su una lista. l'obj deve
     * essere stato scritto con ObjectOutputStream
     *
     * @param <T> generic obj
     * @param file file in cui sono contenuti gli obj
     * @return lista con obj del file
     * @throws java.lang.Exception
     */
    public static <T> ArrayList<T> read_obj(File file) throws Exception {

        ArrayList<T> lista = new ArrayList();

        //controllo se il file esesite e se contiene qualcosa
        //read
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    T thing = (T) reader.readObject();
                    lista.add(thing);
                } catch (EOFException ex) {
                    break; // Fine del file
                }
            }

        }

        return lista;

    }

    /**
     * scrive sul file passato un dato passato dall'utente. N.B. non appende
     *
     * @param <T> valore primitivo generico
     * @param valore dato da scrivere sul file
     * @param file file su cui scrivere i dati
     * @throws java.lang.Exception
     */
    public static <T> void write_value(File file, T valore) throws Exception {

        if (checkValue(valore)) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.println(valore);
            }
        }

    }

    /**
     * scrive sul file passato un dato passato dall'utente. N.B. appende
     *
     * @param <T> valore primitivo generico
     * @param valore dato da scrivere sul file
     * @param file file su cui scrivere i dati
     * @throws java.lang.Exception
     */
    public static <T> void write_value_append(File file, T valore) throws Exception {

        if (checkValue(valore)) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                writer.println(valore);
            }
        }

    }

    /**
     * scrive sul file passato un dato passato dall'utente. nel caso si
     * aggiungono dati ad altri dati già prsenti.il dato sarà scritto con il suo
     * valore e una virgola
     *
     *
     * @param <T> valore primitivo generico
     * @param valore dato da scrivere sul file
     * @param file file su cui scrivere i dati
     * @throws java.lang.Exception
     */
    public static <T> void write_value_append_with_comma(File file, T valore) throws Exception {

        if (checkValue(valore)) {

            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                writer.print(valore + ",");
            }

        }
    }

    /**
     * scrive sul file passato un dato passato dall'utente. N.B. appende<br>es:
     * Boolean:true<br>Integer:3<br>
     *
     * @param <T> valore primitivo generico
     * @param valore dato da scrivere sul file
     * @param file file su cui scrivere i dati
     * @throws java.lang.Exception
     */
    public static <T> void write_value_append_with_type(File file, T valore) throws Exception {

        if (checkValue(valore)) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                writer.println(valore.getClass().getSimpleName() + ":" + valore);
            }
        }

    }

    /**
     * ettura di un file contenente dati primitivi.ciascuno è preceduto dal
     * tipo. il parametro type deve essere scritto uguale alla classe del tipo
     * che si vuole:
     * <p>
     * int:Ineger.<br> double:Double.<br> float:Float.<br> boolean:Boolean.
     * <br>String:String.
     * <p>
     *
     *
     * @param <T> dato primitivo generico
     * @param file file da cui leggere i dati
     * @param type tipo del file richiesto (in stringa)
     * @return lista con i dati del tipo richiesto
     * @throws java.lang.Exception
     */
    public static <T> ArrayList read_value_with_type(File file, String type) throws Exception {

        ArrayList lista = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String stringa = reader.readLine();
            while (stringa != null) {
                String[] vettore = stringa.split(":");

                //controllo se la prima parte corrisponde al tipo richiesto
                if (vettore[0].equals(type)) {
                    T valore = null;
                    //in base al tipo che ha richiesto glielo trasformo
                    switch (type) {
                        case "Boolean":
                            valore = (T) Boolean.valueOf(vettore[1]); // Cast per Boolean
                            break;
                        case "Integer":
                            valore = (T) Integer.valueOf(vettore[1]); // Cast per Integer
                            break;
                        case "Double":
                            valore = (T) Double.valueOf(vettore[1]); // Cast per Double
                            break;
                        case "String":
                            valore = (T) vettore[1]; // Assegna direttamente la stringa
                            break;
                        case "Character":
                            if (vettore[1].length() == 1) {
                                valore = (T) Character.valueOf(vettore[1].charAt(0)); // Usa Character.valueOf
                            }
                            break;
                        default:
                            break;
                    }
                    lista.add(valore);

                }

                stringa = reader.readLine();
            }
        }
        return lista;

    }

    /**
     * lettura di un file contenente numeri interi. fa in modo tale che la lista
     * contenga i dati. se il file non esiste restituisce null.
     *
     * @param file file da cui leggere i dati
     * @return file contenente i dati interi contenuti nel file
     * @throws java.lang.Exception
     */
    public static ArrayList<Integer> read_integer(File file) throws Exception {

        ArrayList<Integer> lista = new ArrayList(); //creo la lista in cui conterrà i valori
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //reader 

            //leggo il file
            String stringa = reader.readLine();
            while (stringa != null) {
                //controllo che non si sa mai
                if (Truth.checkInt(stringa)) {
                    int num = Integer.parseInt(stringa);
                    lista.add(num);
                }
                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente numeri double. fa in modo tale che la lista
     * contenga i dati. se il file non esiste restituisce null.
     *
     * @param file file da cui leggere i dati
     * @return file contenente i dati double contenuti nel file
     * @throws java.lang.Exception
     */
    public static ArrayList<Double> read_double(File file) throws Exception {

        ArrayList<Double> lista = new ArrayList();//lista che conterrà i dati
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //reader 

            //leggo
            String stringa = reader.readLine();
            while (stringa != null) {
                //controllo che non si sa mai
                if (Truth.checkDouble(stringa)) {
                    double num = Double.parseDouble(stringa);
                    lista.add(num);
                }
                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente float. fa in modo tale che la lista
     * contenga i dati. se il file non esiste restituisce null.
     *
     * @param file file da cui leggere i dati
     * @return file contenente i dati float contenuti nel file
     * @throws java.lang.Exception
     */
    public static ArrayList<Float> read_float(File file) throws Exception {

        ArrayList<Float> lista = new ArrayList(); //lista che conterrà i dati
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //reader

            //leggo
            String stringa = reader.readLine();
            while (stringa != null) {
                //controllo che non si sa mai
                if (Truth.checkFloat(stringa)) {
                    float num = Float.parseFloat(stringa);
                    lista.add(num);
                }
                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenenteboolean. fa in modo tale che la lista
     * contenga i dati. se il file non esiste restituisce null.
     *
     * @param file file da cui leggere i dati
     * @return file contenente i dati boolean contenuti nel file
     * @throws java.lang.Exception
     */
    public static ArrayList<Boolean> read_boolean(File file) throws Exception {

        ArrayList<Boolean> lista = new ArrayList(); //lista che conterrà i dati
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //reader

            //leggo
            String stringa = reader.readLine();
            while (stringa != null) {
                //controllo che non si sa mai
                if (Truth.checkBoolean(stringa)) {
                    boolean state = Boolean.parseBoolean(stringa);
                    lista.add(state);
                }
                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente boolean. fa in modo tale che la lista
     * contenga i dati.la lista conterrà solo true. se il file non esiste
     * restituisce null.
     *
     * @param file file da cui leggere i dati
     * @return lista contenente solo true
     * @throws java.lang.Exception
     */
    public static ArrayList<Boolean> read_boolean_true(File file) throws Exception {

        ArrayList<Boolean> lista = new ArrayList(); //lista che conterrà i dati
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //reader

            //leggo
            String stringa = reader.readLine();
            while (stringa != null) {
                //controllo che non si sa mai
                if (Truth.checkBoolean(stringa)) {
                    boolean state = Boolean.parseBoolean(stringa);
                    if (state) {
                        lista.add(state);
                    }
                }
                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente boolean. fa in modo tale che la lista
     * contenga i dati.la lista conterrà solo false.se il file non esiste
     * restituisce null.
     *
     * @param file file da cui leggere i dati
     * @return lista contenente solo false
     * @throws java.lang.Exception
     */
    public static ArrayList<Boolean> read_boolean_false(File file) throws Exception {

        ArrayList<Boolean> lista = new ArrayList(); //lista che conterrà i dati
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //reader

            //leggo
            String stringa = reader.readLine();
            while (stringa != null) {
                //controllo che non si sa mai
                if (Truth.checkBoolean(stringa)) {
                    boolean state = Boolean.parseBoolean(stringa);
                    if (!state) {
                        lista.add(state);
                    }
                }
                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente. fa in modo tale che la lista contenga i
     * dati.
     *
     * @param file file da cui leggere i dati
     * @return lista di stringhe contenute nel file
     * @throws java.lang.Exception
     */
    public static ArrayList<String> read_string(File file) throws Exception {

        ArrayList<String> lista = new ArrayList(); //lista che conterrà dati
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //reader 
            //leggo
            String stringa = reader.readLine();
            while (stringa != null) {
                lista.add(stringa);
                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente dati. le righe devono essere fatte di dati
     * boolean e infine una stringa e la stringa rappresenta la parola chiave di
     * ciò che sto lavorando.<br>
     *
     * es. true,true,false,true,false,false,gino;<br>
     *
     * return:{true,true,false,true,false,false}
     *
     *
     * @param file file da cui leggere i dati
     * @param chiave
     * @return lista di dati in base alla parola chiave
     * @throws java.lang.Exception
     */
    public static ArrayList<Boolean> read_lines_with_key_boolean(File file, String chiave) throws Exception {

        ArrayList<Boolean> lista = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String stringa = reader.readLine();

            while (stringa != null) {
                if (stringa.contains(chiave)) {
                    String[] vettore = stringa.split(",");
                    for (int i = 0; i < vettore.length - 1; i++) {
                        lista.add(Boolean.parseBoolean(vettore[i]));
                    }
                    break;

                }

                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente dati. le righe saranno fatte di dati interi
     * e infine una stringa e la stringa rappresenta la parola chiave di ciò che
     * sto lavorando.<br>
     *
     * es. 1,2,3,4,5,2,gino;<br>
     *
     * return:{1,2,3,4,5,2}
     *
     *
     * @param file file da cui leggere i dati
     * @param chiave
     * @return lista di dati in base alla parola chiave
     * @throws java.lang.Exception
     */
    public static ArrayList<Integer> read_lines_with_key_int(File file, String chiave) throws Exception {

        ArrayList<Integer> lista = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String stringa = reader.readLine();

            while (stringa != null) {
                if (stringa.contains(chiave)) {
                    String[] vettore = stringa.split(",");
                    for (int i = 0; i < vettore.length - 1; i++) {
                        lista.add(Integer.parseInt(vettore[i]));
                    }
                    break;

                }

                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * lettura di un file contenente dati. la riga deve contenere il valore da
     * leggere (boolean) e la parola chiave.<br>
     *
     *
     * es. 21,gino;<br>true,gino<br>3,tino<br>chiave:gino,return: {true}
     *
     * @param file file da cui leggere i dati
     * @param chiave parola chiave con la quale si ha l'accesso al dato
     * @return lista di dati in base alla parola chiave
     * @throws java.lang.Exception
     */
    public static ArrayList<Boolean> read_with_key_boolean(File file, String chiave) throws Exception {

        ArrayList lista = read_with_key(file, chiave);
        ArrayList<Boolean> lista1 = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getClass().getSimpleName().equals("Boolean")) {
                lista1.add((Boolean) lista.get(i));
            }
        }

        return lista1;

    }

    /**
     * lettura di un file contenente dati. la riga deve contenere il valore da
     * leggere e la parola chiave. restituisce solo i valori true avente quella
     * parola chiave<br>
     *
     *
     * es. 21,gino;<br>true,gino<br>3,tino<br>chiave:gino,return: [true]
     *
     * @param file file da cui leggere i dati
     * @param chiave parola chiave con la quale si ha l'accesso al dato
     * @return lista di true in base alla parola chiave
     * @throws java.lang.Exception
     */
    public static ArrayList<Boolean> read_with_key_booleans_true(File file, String chiave) throws Exception {

        ArrayList<Boolean> lista = read_with_key_boolean(file, chiave);
        ArrayList<Boolean> lista1 = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i)) {
                lista1.add(lista.get(i));
            }
        }

        return lista1;

    }

    /**
     * lettura di un file contenente dati. la riga deve contenere il valore da
     * leggere e la parola chiave. restituisce solo i valori false avente quella
     * parola chiave<br>
     *
     *
     * es. 21,gino;<br>true,gino<br>3,tino<br>chiave:gino,return: [false]
     *
     * @param file file da cui leggere i dati
     * @param chiave parola chiave con la quale si ha l'accesso al dato
     * @return lista di false in base alla parola chiave
     * @throws java.lang.Exception
     */
    public static ArrayList<Boolean> read_with_key_booleans_false(File file, String chiave) throws Exception {

        ArrayList<Boolean> lista = read_with_key_boolean(file, chiave);
        ArrayList<Boolean> lista1 = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i)) {
                lista1.add(lista.get(i));
            }
        }

        return lista1;

    }

    /**
     * lettura di un file contenente dati. la riga deve contenere il valore da
     * leggere e la parola chiave.
     *
     * <P>
     * es. 21,gino;<br>true,gino<br>3,tino<br>chiave:gino,return: {21}
     * <p>
     * @param file file da cui leggere i dati
     * @param chiave parola chiave con la quale si ha l'accesso al dato
     * @return lista di dati in base alla parola chiave
     * @throws java.lang.Exception
     */
    public static ArrayList<Integer> read_with_key_int(File file, String chiave) throws Exception {
        ArrayList lista = read_with_key(file, chiave);
        ArrayList<Integer> lista1 = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getClass().getSimpleName().equals("Integer")) {
                lista1.add((Integer) lista.get(i));
            }
        }

        return lista1;

    }

    /**
     * lettura di un file contenente dati. la riga deve contenere il valore da
     * leggere e la parola chiave
     *
     * <P>
     * es. 21,gino;<br>ciao,gino<br>3,tino<br>chiave:gino,return: {21,ciao}
     * <p>
     * @param file file da cui leggere i dati
     * @param chiave parola chiave con la quale si ha l'accesso al dato
     * @return lista di dati in base alla parola chiave
     * @throws java.lang.Exception
     */
    public static ArrayList read_with_key(File file, String chiave) throws Exception {

        ArrayList lista = new ArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String stringa = reader.readLine();

            while (stringa != null) {
                if (stringa.contains(chiave)) {

                    String[] vettore = stringa.split(","); //il vettore sarà di due posti
                    lista.add(parseValue(vettore[0])); //aggiungo alla lista

                }

                stringa = reader.readLine();
            }

        }
        return lista;

    }

    /**
     * scrivo sul file il dato.il dato precede la virgola e la parola chiave con
     * cui si può avere accesso alla riga
     *
     * @param <T> tipo generico
     * @param file file su cui scrivere il dato
     * @param thing valore generico
     * @param chiave parola con cui si può accedere al dato
     * @throws java.lang.Exception
     */
    public static <T> void write_value_with_key_append(File file, T thing, String chiave) throws Exception {

        if (checkValue(thing)) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                writer.println(thing.toString() + "," + chiave);
            }
        }
    }

    /**
     * trasforma una stringa nel valore corrispondente
     *
     * @param <T> valore generico
     * @param parola stringa
     * @return valore della stringa
     */
    private static <T> T parseValue(String parola) {
        if (Truth.checkInt(parola)) {
            return (T) Integer.valueOf(parola);
        } else if (Truth.checkBoolean(parola)) {
            return (T) Boolean.valueOf(parola);
        } else if (Truth.checkDouble(parola)) {
            return (T) Double.valueOf(parola);
        } else {
            return (T) parola;
        }
    }

    /**
     * verifica se il dato è un dato primitivo/String o no
     *
     * @param <T> dato generico
     * @param thing dato da verificare
     * @return true se è primitivo/String,false se no
     */
    private static <T> boolean checkValue(T thing) {
        return thing instanceof Integer || thing instanceof Double || thing instanceof Float || thing instanceof Character || thing instanceof Boolean || thing instanceof String;
    }

    /**
     * veirfica se all'interno di un file è presente la stringa passata.
     *
     * @param file file in cui trovare la str
     * @param stringa str da trovare
     * @return true se è prsente,faòse se no
     * @throws java.lang.Exception
     */
    public static boolean contains_string(File file, String stringa) throws Exception {

        ArrayList<String> lista = FilesTxt.read_string(file);

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(stringa)) {
                return true;
            }
        }

        return false;

    }

    /**
     * legge un file
     *
     * @param file file da cui leggere
     * @return lista contente tutte le righe del file
     * @throws Exception
     */
    public static ArrayList read_values(File file) throws Exception {

        //controllo che il file esista
        ArrayList lista = new ArrayList(); //creo la lista in cui salvare i dati
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String stringa = reader.readLine();
            while (stringa != null) {

                if (Truth.checkInt(stringa)) {
                    int str = Integer.parseInt(stringa);
                    lista.add(str);
                } else if (Truth.checkBoolean(stringa)) {
                    boolean str = Boolean.parseBoolean(stringa);
                    lista.add(str);
                } else if (Truth.checkDouble(stringa)) {
                    double str = Double.parseDouble(stringa);
                    lista.add(str);
                } else {
                    lista.add(stringa);
                }

                stringa = reader.readLine();
            }
        }

        return lista;

    }

    /**
     * scrive il dato se non è presente nel file
     *
     * @param file file in cui scrivre
     * @param stringa str da scrivere
     * @throws java.lang.Exception
     */
    public static void write_ifNotPresent_append_String(File file, String stringa) throws Exception {

        if (!contains_string(file, stringa)) {
            FilesTxt.write_value_append(file, stringa);
        }

    }

    /**
     * verifica se in un file è contenuto il valore passato
     *
     * @param <T> valore generico
     * @param file file in cui controllare
     * @param value valore da controllare
     * @return true se è presente,false se non lo è
     * @throws java.lang.Exception
     */
    public static <T> boolean contains(File file, T value) throws Exception {
        return contains_string(file, value.toString()); //trasformo il mio valore in un stringa e verifico se è presente
    }

    /**
     * scrive il dato se non è presente nel file
     *
     * @param <T> valore generico
     * @param file file in cui scrivre
     * @param value valore da scrivere
     * @throws java.lang.Exception
     */
    public static <T> void write_value_ifNotPresent_append(File file, T value) throws Exception {

        if (checkValue(value) && !contains(file, value)) {
            FilesTxt.write_value_append(file, value);
        }

    }

    /**
     * scrive il dato se non è presente nel file
     *
     * @param <T> valore generico
     * @param file file in cui scrivre
     * @param value valore da scrivere
     * @throws java.lang.Exception
     */
    public static <T> void write_value_ifNotPresent(File file, T value) throws Exception {

        if (checkValue(value) && !contains(file, value)) {
            FilesTxt.write_value(file, value);
        }

    }

    /**
     * pulisco il file di testo
     *
     * @param file file da pulire
     */
    public static void clear(File file) {

        if (file.exists() && file.length() != 0) {

            try (FileWriter w = new FileWriter(file)) {
                w.write("");
            } catch (Exception ex) {
            }
        }

    }

    /**
     * restiuisce e aggiorna l'id in un file
     *
     * @param file file contenente il conteggio degli id
     * @return nuovo valore generato
     * @throws Exception
     */
    public static int getId(File file) throws Exception {

        int id = 0; //valore iniziale

        //controllo se il file esiste
        if (file.exists()) {

            //nel caso esistesse verifico se è vuoto o no
            //se non è vuoto vedo che id è segnato e lo salvo
            if (file.length() != 0) {

                try (BufferedReader r = new BufferedReader(new FileReader(file))) {

                    id = Integer.parseInt(r.readLine()); //salvo il valore
                    r.close();

                }

            }

        } else {
            file.createNewFile();
        }

        id++; //incremento 

        //aggiorno sul file l'id
        try (PrintWriter w = new PrintWriter(new FileWriter(file))) {
            w.print(id);
            w.close();
        }
        return id;
    }

    /**
     * restiuisce e aggiorna l'id in un file
     *
     * @param NOMEFILE percorso del file
     * @return nuovo valore generato
     * @throws Exception
     */
    public static int getId(String NOMEFILE) throws Exception {
        File file = new File(NOMEFILE);
        int id = 0; //valore iniziale

        //controllo se il file esiste
        if (file.exists()) {

            //nel caso esistesse verifico se è vuoto o no
            //se non è vuoto vedo che id è segnato e lo salvo
            if (file.length() != 0) {

                try (BufferedReader r = new BufferedReader(new FileReader(file))) {

                    id = Integer.parseInt(r.readLine()); //salvo il valore
                    r.close();

                }

            }

        } else {
            file.createNewFile();
        }

        id++; //incremento 

        //aggiorno sul file l'id
        try (PrintWriter w = new PrintWriter(new FileWriter(file))) {
            w.print(id);
            w.close();
        }
        return id;
    }

    /**
     * scrive una lista di valori generici sovrascrivvendo il file
     *
     * @param <T> valore generico
     * @param file file in cui scrivere
     * @param lista lista di valori da scrivere
     * @throws Exception
     */
    public static <T> void write_values(File file, ArrayList<T> lista) throws Exception {

        clear(file); //pulisco il file e successivamente scrivo

        for (T t : lista) {
            write_value_append(file, t);
        }

    }

    /**
     * scrive una lista di valori generici aggiungendo al contenuto già presente
     * nel file
     *
     * @param <T> valore generico
     * @param file file in cui scrivere
     * @param lista lista di valori da scrivere
     * @throws Exception
     */
    public static <T> void write_values_append(File file, ArrayList<T> lista) throws Exception {

        for (T t : lista) {
            write_value_append(file, t);
        }

    }

    /**
     * r imuove una riga data la posizione
     *
     * @param file file di testo in cui eliminare la riga
     * @param pos numero della riga da eliminare (indice da 0)
     * @throws Exception
     */
    public static void remove_line(File file, int pos) throws Exception {
        //chat dice che è efficiente :)
        if (file.length() == 0) {
            return;
        }//se è vuoto è inutile che svolgo le istruzioni

        File temp = new File(file.getAbsolutePath() + ".tmp"); //temp

        //svolgero un'azione di lettura e di scrittura contempraneamente
        try (BufferedReader r = new BufferedReader(new FileReader(file)); PrintWriter w = new PrintWriter(new FileWriter(temp))) {

            String str = r.readLine(); //leggo la prima linea
            int conta = 0; //contatore delle righe
            while (str != null) {
                //scrivo sul file tutte le righe che non siano quella richiesta
                if (conta != pos) {
                    w.println(str);
                }
                conta++; //incremento il contatore
                str = r.readLine(); //e continuo la lettura
            }
        }

        file.delete(); //primo elimino il file 
        temp.renameTo(file); //per poi rinominare il temp con lo stesso nome dell'orignale
    }

    public static void set_line(File file, String stringa, int pos) throws Exception {
        if (file.length() == 0) {
            return;
        }//se è vuoto è inutile che svolgo le istruzioni

        File temp = new File(file.getAbsolutePath() + ".tmp"); //temp

        //svolgero un'azione di lettura e di scrittura contempraneamente
        try (BufferedReader r = new BufferedReader(new FileReader(file)); PrintWriter w = new PrintWriter(new FileWriter(temp))) {

            String str = r.readLine(); //leggo la prima linea
            int conta = 0; //contatore delle righe
            while (str != null) {
                //scrivo sul file tutte le righe che non siano quella richiesta
                if (conta == pos) {
                    w.println(stringa);
                } else {
                    w.println(str);
                }
                conta++; //incremento il contatore
                str = r.readLine(); //e continuo la lettura
            }
        }

        file.delete(); //primo elimino il file 
        temp.renameTo(file); //per poi rinominare il temp con lo stesso nome dell'orignale

    }

    /**
     * legge un file in cui i dati sono separati da una virgola<br></br>
     * <br></br>
     * es. 1,2,3,4,5 <br></br>
     * 6,ciao,tri,d <br></br>
     * hg,jh <br></br><br></br>
     * return { <br></br>
     * {1,2,3,4,5 } <br></br>
     * {6,ciao,tri,d}<br></br>
     * {hg,jh}<br></br>
     *
     * }
     *
     * @param file file in cui leggere
     * @return lista di liste conteneti i dati di ogni riga
     * @throws Exception
     */
    public static ArrayList<ArrayList<String>> read_comma(File file) throws Exception {

        ArrayList<String> lista = FilesTxt.read_string(file); //mi cavo le righe sotto forma di stringhe
        ArrayList<ArrayList<String>> l = new ArrayList<>(); //lista da restituire

        //ciclo le str,le splitto e salvo il tutto
        for (String s : lista) {
            ArrayList<String> l1 = new ArrayList<>();
            String[] v = s.split(",");

            l1.addAll(Arrays.asList(v)); //aggiungo tutti gli elementi al vettore alla lista

            l.add(l1); //agigungo la riga alla lista da restituir           
        }

        return l;

    }

    /**
     * legge un file in cui i dati sono separati da una virgola.<br></br>
     * N.B. legge solo int <br></br>
     * <br></br>
     * es. 1,2,3,4,5 <br></br>
     * 6,ciao,tri,d <br></br>
     * hg,jh <br></br><br></br>
     * return { <br></br>
     * {1,2,3,4,5 } <br></br>
     * {6}<br></br>
     * {}<br></br>
     *
     * }
     *
     * @param file file in cui leggere
     * @return lista di liste conteneti i dati di ogni riga
     * @throws Exception
     */
    public static ArrayList<ArrayList<Integer>> read_int_comma(File file) throws Exception {
        ArrayList<ArrayList<String>> lista = read_comma(file); //leggo il file
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); //lista in cui mi salvo i valori interi

        //ciclo le righe del file
        for (ArrayList<String> l : lista) {
            ArrayList<Integer> l1 = new ArrayList<>(); //lista in cui mi salvo i valori interi della riga
            //ciclo i dati della riga
            for (String str : l) {
                if (Truth.checkInt(str)) {
                    l1.add(Integer.parseInt(str)); //se int lo aggiungo
                }

            }

            list.add(l1); //aggiungo i dati int delal riga alla lista

        }

        return list;

    }

    public static int contaRigaPiùLunga(File file) throws Exception {
        ArrayList<String> lista = FilesTxt.read_string(file);

        int max = Integer.MIN_VALUE;

        for (String str : lista) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        return max;

    }

    
    /**
     * clona un file.copia i dati e li porta su un nuovo file che avra lo stesso nome+1
     * <br></br><br></br>
     * es->nomw:"file.txt"<br></br>
     * risultato:"file1.txt"
     * @param file
     * @throws Exception 
     */
    public static void clone(File file) throws Exception {

        if (file.length() == 0) {
            return;
        }//se è vuoto è inutile che svolgo le istruzioni

        String nomeFile = file.getName(); 
        String nuovoNome;

        String[] parti = nomeFile.split("\\.");
        if (parti.length == 2) {
            if(parti[0].equals(nomeFile+"1")){return;}
            nuovoNome = parti[0] + "1." + parti[1]; 
        } else {
            nuovoNome = nomeFile + "1";
        }

        File temp = new File(file.getParent(), nuovoNome);

        //svolgero un'azione di lettura e di scrittura contempraneamente
        try (BufferedReader r = new BufferedReader(new FileReader(file)); PrintWriter w = new PrintWriter(new FileWriter(temp))) {

            String str = r.readLine(); //leggo la prima linea
            while (str != null) {
                w.println(str);
                str = r.readLine(); //e continuo la lettura
            }
        }

    }
    
    
    
   
    
    
    
    
    
    
    
    

}
