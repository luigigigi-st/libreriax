/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dimenticatoio;

import com.mycompany.classi.games.Bro;

/**
 *
 * @author migna
 */
public class Movimentor {

    private double v, t;

    public Movimentor() {
        v = 0;
        t = 1;
    }

    public Movimentor(double v) {
        this.v = v;
        t = 1;
    }

    public Movimentor(double v, double t) {
        System.out.println("vel:"+v);
        this.v = v;
        this.t = t;
    }

    public void rettilinio(Bro p) {
        double x = distanzaRettilinio(p);
        p.setX(x);
    }
    
    public double distanzaRettilinio(Bro p){return v * t;}
    



    
    public double getV(){return v;}
    public double getT(){return t;}
    
    public void setV(double v){this.v=v;}
    public void setT(double t){this.t=t;}
    
    

}
