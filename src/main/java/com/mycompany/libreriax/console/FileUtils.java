/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libreriax.console;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    /**
     * crea una lista di file in una direcotry.<br>N.B. il percorso dei file
     * deve essere corretto(quindi indicae che è contenuto in una cartella)
     * <br>es. path file: files/nomeFile ---> path dir: files <br>
     * path file:prova/files/nomeFile ----> path dir:prova/files
     *
     *
     * @param Pathdrc path dela directory
     * @param lista lista di file da andare a creare nel caso non esistessero
     * @return true se va a buon fine,false se no
     */
    public static boolean createFiles(String Pathdrc, ArrayList<File> lista) {

        File dir = new File(Pathdrc); //creo il l'obj file per creare la directory

        dir.mkdirs(); //nel caso non esistesse creo la directory
        try {
            //scorro la lista e creo i file
            for (File file : lista) {
                //controllo se la direcotry in cui si trova il file corrisponde a quella in cui voglia crearla 
                if (file.getParent().equals(dir.getPath())) {
                    file.createNewFile();
                }

            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * crea un file in una direcotry.<br>N.B. il percorso dei file deve essere
     * corretto(quindi indicae che è contenuto in una cartella)
     * <br>es. path file: files/nomeFile ---> path dir: files <br>
     * path file:prova/files/nomeFile ----> path dir:prova/files
     *
     *
     * @param Pathdrc path dela directory
     * @param file file da creare
     */
    public static void createFile(String Pathdrc, File file) {

        File dir = new File(Pathdrc); //creo il l'obj file per creare la directory

        dir.mkdirs(); //nel caso non esistesse creo la directory
        try {
            //scorro la lista e creo i file

            //controllo se la direcotry in cui si trova il file corrisponde a quella in cui voglia crearla 
            if (file.getParent().equals(dir.getPath())) {
                file.createNewFile();
            }

        } catch (IOException e) {
        }

    }

    /**
     * cancella l'obj file passato se è vuoto
     *
     * @param file file da cancellare
     */
    public static void deleteIfEmpty(File file) {

        if (file.exists()) {
            if (file.isFile() && file.length() == 0 || file.isDirectory() && file.list().length == 0) {
                file.delete();
            }

        }

    }

    /**
     * crea un file con lo stesso nome NON FUNZIONANTW
     *
     * @param file
     */
    public static void clone(File file) {

        if (file.exists()) {
            System.out.println("nome file:" + file.getName());
            String[] vett = file.getName().split(".");

            String nome = vett[0] + "(*)" + vett[1];
            String path = file.getPath() + "\\" + nome;
            System.out.println("path:" + path);
            try {
                new File(path).createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * crea un file se non esiste
     *
     * @param file file da creare nel caso non esistesse
     * @throws Exception
     */
    public static void createIfNotExists(File file) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * crea un file se non esiste
     *
     * @param PATH path del file da creare nel caso non esistesse
     * @throws Exception
     */
    public static void createIfNotExists(String PATH) throws Exception {
        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    // Funzione per ridimensionare un'immagine
    public static BufferedImage resizeImage(Image originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return resizedImage;
    }

}
