/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.games;

/**
 *
 * @author migna
 */
public class Coordinata {

    public double x, y;

    public Coordinata() {
        x = 0;
        y = 0;
    }

    public Coordinata(double x) {
        this.x = x;
        y = 0;
    }

    public Coordinata(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
    
    public Coordinata getCopy(){return new Coordinata(x,y);}

}
