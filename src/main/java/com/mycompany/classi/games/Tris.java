/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.games;



import com.mycompany.libreriax.console.input;

import java.util.Scanner;



    public class Tris {

    private char[][] matrice;

    public Tris() {
        matrice = new char[3][3];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                matrice[i][j] = ' ';
            }
        }
    }

    public Tris(char[][] matrice) {
        if (matrice.length == 3 && matrice[0].length == 3) {
            this.matrice = matrice;
        }
    }
    
    public char [][] getTris(){return matrice;}
    public void setTris(char[][] matrice){this.matrice=matrice;}
    public void setCells(int [] coordinate,char carattere){if(getDisponibilità()[coordinate[0]][coordinate[1]]){matrice[coordinate[0]][coordinate[1]]=carattere;}}
    public void setCells(int x,int y ,char carattere){if(getDisponibilità()[x][y]){matrice[x][y]=carattere;}}
    
    /**
     * restituisce una matrice le cui celle corrispono a quelle del tris.ad ogni cella corrisponde la disponibilità della cella stessa
     * <p>
     * es.: X |   | X 
           ---+---+---
            O |   |  
           ---+---+---
              | X | O 
     * 
     *     disponilità:
     * 
     *      false |  true | false 
           -------+-------+--------
            true  |  true | true
           -------+-------+--------
            true  | false | true
     * <p>
     * questo è un esempio del funzionamento
     * @return 
     */
    public boolean[][] getDisponibilitàX() {
        //inizializzo la matrice in cui controllo la disponibilità. tutte le caselle sare false e andro a mettere true quelle disponibili
        boolean[][] free = new boolean[3][3];
        char [][] matrice=getTrisX();
        
        //controollo e modifico
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == ' ') {
                    free[i][j]=true;
                }
            }
        }
        
        return free;

    }
    
    
    /**
     * restituisce la griglia di tris contendo solo le X
     * 
     * es.  X |   | O
           ---+---+---
            X |   |  
           ---+---+---
              | X | O
    * 
    * 
    *       X |   | 
           ---+---+---
            X |   |  
           ---+---+---
              | X | 
     * @return matrice contenente solo le X
     */
        public char[][] getTrisX() {
            char[][] matrice = new char[3][3];

            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[0].length; j++) {
                    if (this.matrice[i][j] == 'X') {
                        matrice[i][j] = 'X';
                    } else {
                        matrice[i][j] = ' ';
                    }
                }
            }

            return matrice;

        }

        /**
         * controllo in quali posizioni la X può vincere
         *
         * @return coordinate dello spazio vuoto con cui può vincere la X
         */
        public int[] checkTryVittoriaX() {
            //controllo le righe
            for (int i = 0; i < 3; i++) {
                if (matrice[i][0] == 'X' && matrice[i][1] == 'X' && matrice[i][2] == ' ') {
                    return new int[]{i, 2};
                }
                if (matrice[i][0] == 'X' && matrice[i][2] == 'X' && matrice[i][1] == ' ') {
                    return new int[]{i, 1};
                }
                if (matrice[i][1] == 'X' && matrice[i][2] == 'X' && matrice[i][0] == ' ') {
                    return new int[]{i, 0};
                }
            }

            // Controlla le colonne
            for (int j = 0; j < 3; j++) {
                if (matrice[0][j] == 'X' && matrice[1][j] == 'X' && matrice[2][j] == ' ') {
                    return new int[]{2, j};
                }
                if (matrice[0][j] == 'X' && matrice[2][j] == 'X' && matrice[1][j] == ' ') {
                    return new int[]{1, j};
                }
                if (matrice[1][j] == 'X' && matrice[2][j] == 'X' && matrice[0][j] == ' ') {
                    return new int[]{0, j};
                }
            }

            // Controlla la diagonale principale
            if (matrice[0][0] == 'X' && matrice[1][1] == 'X' && matrice[2][2] == ' ') {
                return new int[]{2, 2};
            }
            if (matrice[0][0] == 'X' && matrice[2][2] == 'X' && matrice[1][1] == ' ') {
                return new int[]{1, 1};
            }
            if (matrice[1][1] == 'X' && matrice[2][2] == 'X' && matrice[0][0] == ' ') {
                return new int[]{0, 0};
            }

            // Controlla la diagonale secondaria
            if (matrice[0][2] == 'X' && matrice[1][1] == 'X' && matrice[2][0] == ' ') {
                return new int[]{2, 0};
            }
            if (matrice[0][2] == 'X' && matrice[2][0] == 'X' && matrice[1][1] == ' ') {
                return new int[]{1, 1};
            }
            if (matrice[1][1] == 'X' && matrice[2][0] == 'X' && matrice[0][2] == ' ') {
                return new int[]{0, 2};
            }

            // Nessun blocco trovato
            return null;

        }
        
        
    /**
    * controllo in quali posizioni la X può vincere
    * @return coordinate dello spazio vuoto con cui può vincere la X
    */
        public boolean checkVittoriaX(){
        //controllo le righe
        for (int i = 0; i < 3; i++) {
            if (matrice[i][0] == 'X' && matrice[i][1] == 'X' && matrice[i][2] == 'X') return true;
            if (matrice[i][0] == 'X' && matrice[i][2] == 'X' && matrice[i][1] == 'X') return true;
            if (matrice[i][1] == 'X' && matrice[i][2] == 'X' && matrice[i][0] == 'X') return true;
        }

        // Controlla le colonne
        for (int j = 0; j < 3; j++) {
            if (matrice[0][j] == 'X' && matrice[1][j] == 'X' && matrice[2][j] == 'X') return true;
            if (matrice[0][j] == 'X' && matrice[2][j] == 'X' && matrice[1][j] == 'X') return true;
            if (matrice[1][j] == 'X' && matrice[2][j] == 'X' && matrice[0][j] == 'X') return true;
        }

        // Controlla la diagonale principale
        if (matrice[0][0] == 'X' && matrice[1][1] == 'X' && matrice[2][2] == 'X') return true;
        if (matrice[0][0] == 'X' && matrice[2][2] == 'X' && matrice[1][1] == 'X') return true;
        if (matrice[1][1] == 'X' && matrice[2][2] == 'X' && matrice[0][0] == 'X') return true;

        // Controlla la diagonale secondaria
        if (matrice[0][2] == 'X' && matrice[1][1] == 'X' && matrice[2][0] == 'X') return true;
        if (matrice[0][2] == 'X' && matrice[2][0] == 'X' && matrice[1][1] == 'X') return true;
        if (matrice[1][1] == 'X' && matrice[2][0] == 'X' && matrice[0][2] == 'X') return true;

        // Nessun blocco trovato
        return false;

        }
        
        
        
        
        
        
        
        /**
         * controllo in quali posizioni la O può vincere
         * @return coordinate dello spazio vuoto con cui può vincere la O
         */
        public int[] checkTryVittoriaO() {
        // Controlla le righe
        for (int i = 0; i < 3; i++) {
            if (matrice[i][0] == 'O' && matrice[i][1] == 'O' && matrice[i][2] == ' ') return new int[]{i, 2};
            if (matrice[i][0] == 'O' && matrice[i][2] == 'O' && matrice[i][1] == ' ') return new int[]{i, 1};
            if (matrice[i][1] == 'O' && matrice[i][2] == 'O' && matrice[i][0] == ' ') return new int[]{i, 0};
        }

        // Controlla le colonne
        for (int j = 0; j < 3; j++) {
            if (matrice[0][j] == 'O' && matrice[1][j] == 'O' && matrice[2][j] == ' ') return new int[]{2, j};
            if (matrice[0][j] == 'O' && matrice[2][j] == 'O' && matrice[1][j] == ' ') return new int[]{1, j};
            if (matrice[1][j] == 'O' && matrice[2][j] == 'O' && matrice[0][j] == ' ') return new int[]{0, j};
        }

            // Controlla la diagonale principale
            if (matrice[0][0] == 'O' && matrice[1][1] == 'O' && matrice[2][2] == ' ') return new int[]{2, 2};
            if (matrice[0][0] == 'O' && matrice[2][2] == 'O' && matrice[1][1] == ' ') return new int[]{1, 1};
            if (matrice[1][1] == 'O' && matrice[2][2] == 'O' && matrice[0][0] == ' ') return new int[]{0, 0};

            // Controlla la diagonale secondaria
            if (matrice[0][2] == 'O' && matrice[1][1] == 'O' && matrice[2][0] == ' ') return new int[]{2, 0};
            if (matrice[0][2] == 'O' && matrice[2][0] == 'O' && matrice[1][1] == ' ') return new int[]{1, 1};
            if (matrice[1][1] == 'O' && matrice[2][0] == 'O' && matrice[0][2] == ' ') return new int[]{0, 2};

        // Nessuna vittoria trovata
        return null;
        }
        
        /**
         * controllo in quali posizioni la X può vincere
         * @return coordinate dello spazio vuoto con cui può vincere la X
         */
        public boolean checkVittoriaO(){
        //controllo le righe
        for (int i = 0; i < 3; i++) {
            if (matrice[i][0] == 'O' && matrice[i][1] == 'O' && matrice[i][2] == 'O') return true;
            if (matrice[i][0] == 'O' && matrice[i][2] == 'O' && matrice[i][1] == 'O') return true;
            if (matrice[i][1] == 'O' && matrice[i][2] == 'O' && matrice[i][0] == 'O') return true;
        }

        // Controlla le colonne
        for (int j = 0; j < 3; j++) {
            if (matrice[0][j] == 'O' && matrice[1][j] == 'O' && matrice[2][j] == 'O') return true;
            if (matrice[0][j] == 'O' && matrice[2][j] == 'O' && matrice[1][j] == 'O') return true;
            if (matrice[1][j] == 'O' && matrice[2][j] == 'O' && matrice[0][j] == 'O') return true;
        }

        // Controlla la diagonale principale
        if (matrice[0][0] == 'O' && matrice[1][1] == 'O' && matrice[2][2] == 'O') return true;
        if (matrice[0][0] == 'O' && matrice[2][2] == 'O' && matrice[1][1] == 'O') return true;
        if (matrice[1][1] == 'O' && matrice[2][2] == 'O' && matrice[0][0] == 'O') return true;

        // Controlla la diagonale secondaria
        if (matrice[0][2] == 'O' && matrice[1][1] == 'O' && matrice[2][0] == 'O') return true;
        if (matrice[0][2] == 'O' && matrice[2][0] == 'O' && matrice[1][1] == 'O') return true;
        if (matrice[1][1] == 'O' && matrice[2][0] == 'O' && matrice[0][2] == 'O') return true;

        // Nessun blocco trovato
        return false;

        }
        
        
        /**
     * restituisce una matrice le cui celle corrispono a quelle del tris.ad ogni cella corrisponde la disponibilità della cella stessa
     * 
     * es.: X |   | X 
           ---+---+---
            O |   |  
           ---+---+---
              | X | O 
     * 
     *     disponilità:
     * 
     *      true  |  true | true 
           -------+-------+--------
            false |  true | true
           -------+-------+--------
            true  | true  | false
     * 
     * questo è un esempio del funzionamento
     * @return 
     */
    public boolean[][] getDisponibilitàO() {
        //inizializzo la matrice in cui controllo la disponibilità. tutte le caselle sare false e andro a mettere true quelle disponibili
        boolean[][] free = new boolean[3][3];
        char [][] matrice=getTrisO();
        
        //controollo e modifico
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == ' ') {
                    free[i][j]=true;
                }
            }
        }
        
        return free;

    }
        
        public boolean checkPareggio() {
            boolean[][] free = getDisponibilità();

            int conta = 0;

            for (int i = 0; i < free.length; i++) {
                for (int j = 0; j < free[0].length; j++) {
                    if (free[i][j]) {
                        conta++;
                    }
                }

            }

            return conta == 1 || conta==0 ;

        }

    
    
    /**
     * restituisce una matrice le cui celle corrispono a quelle del tris.ad ogni cella corrisponde la disponibilità della cella stessa
     * 
     * es.: 1 |   | 3 
           ---+---+---
            4 |   |  
           ---+---+---
              | 8 | 9 
     * 
     *     disponilità:
     * 
     *      false |  true | false 
           -------+-------+--------
            false |  true | true
           -------+-------+--------
            true  |  true | false
     * 
     * questo è un esempio del funzionamento
     * @return 
     */
    public boolean[][] getDisponibilità() {
        //inizializzo la matrice in cui controllo la disponibilità. tutte le caselle sare false e andro a mettere true quelle disponibili
        boolean[][] free = new boolean[3][3];
        
        //controollo e modifico
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == ' ') {
                    free[i][j]=true;
                }
            }
        }
        
        return free;

    }
    
    /**
     * verifica che il tris è pieno o no
     * @return true se è pieno,false se non lo è
     */
        public boolean checkFull() {
            boolean[][] free = getDisponibilità();

            int conta = 0;

            
            for (int i = 0; i < free.length; i++) {
                for (int j = 0; j < free[0].length; j++) {
                    if (!free[i][j]) {
                        conta++;
                    }
                }

            }
            return conta == 9;
        }

    
   
    
    
    
    /**
     * restituisce la griglia di tris contendo solo le X
     * 
     * es.  X |   | O
           ---+---+---
            X |   |  
           ---+---+---
              | X | O
    * 
    *
    * return:
    *         |   | O
           ---+---+---
              |   |  
           ---+---+---
              |   | O
     * @return matrice contenente solo le O
     */
        public char[][] getTrisO() {
            char[][] matrice = new char[3][3];

            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[0].length; j++) {
                    if (this.matrice[i][j] == 'O') {
                        matrice[i][j] = 'O';
                    } else {
                        matrice[i][j] = ' ';
                    }
                }
            }

            return matrice;

        }

   /**
     * restituisce la disponibilità di una cella della griglia data la pos (non le coordinate)
     * 
     *                      1 | 2 | 3 
                           ---+---+---
                            4 | 5 | 6 
                           ---+---+---
                            7 | 8 | 9 
                            
     * le coordinate seguono la griglia sopra citata
     * la matrice data come parametro deve avere tutte le celle = false
     * @param pos pos che corrisponde alla griglia
     * @return ture se la pos va bene,false no
     */
    public  boolean checkPos(int pos) {
        boolean [][] matrice=getDisponibilità();
        
        if (pos == 1 && matrice[0][0]) {
            this.matrice[0][0]='X';
            return true;
        } else if (pos == 2 && matrice[0][1]) {
            this.matrice[0][1]='X';
            return true;
        } else if (pos == 3 && matrice[0][2]) {
            this.matrice[0][2]='X';
            return true;
        } else if (pos == 4 && matrice[1][0]) {
            this.matrice[1][0]='X';
            return true;
        } else if (pos == 5 && matrice[1][1]) {
            this.matrice[1][1]='X';
            return true;
        } else if (pos == 6 && matrice[1][2]) {
            this.matrice[1][2]='X';
            return true;
        } else if (pos == 7 && matrice[2][0]) {
            this.matrice[2][0]='X';
            return true;
        } else if (pos == 8 && matrice[2][1]) {
            this.matrice[2][1]='X';
            return true;
        } else if (pos == 9 && matrice[2][2]) {
            this.matrice[2][2]='X';
            return true;
        } else {
            return false;
        }

    }
    
    
    

    
    /**
     * restituisce una pos valida per l'inserimento della mossa dell'utente
     * @return pos del X
     */
    public int inputPosTris() {
        Scanner isa = new Scanner(System.in);

        int pos = input.IntPositivo("Inserire il numero della casella per inserirle una X:", "devi inserire un numero adeguato,reinserisci"); //input pos

        //verifico se la pos sia valida o che sia disponibile
        while (!checkPos(pos)) {
            pos = input.IntPositivo("pos non valida o non libera,reinserisci:", "devi inserire un numero adeguato,reinserisci");
        }

        return pos;

    }
    
     /**
     * output del tris
     */
    @Override
    public String toString() {
        String stringa = "";

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (j != matrice[0].length - 1) {
                    stringa = stringa + matrice[i][j] + " | ";
                } else {
                    stringa = stringa + matrice[i][j] + "\n";
                }

            }

            if (i != matrice.length - 1) {
                stringa = stringa + "--+---+---\n";
            }
        }

        return stringa;

    }
    
    
    
    
    
}
