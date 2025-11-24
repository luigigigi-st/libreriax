/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.games;

import com.mycompany.dimenticatoio.Movimentor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.geom.Point2D;

/**
 *
 * @author migna
 */
public class Bro extends Entity {
    

    public int vel;

    // ====================
    // COSTRUTTORI BASE CON int (vel = 0)
    // ====================
    public Bro(Image img, int x, int y, int larghezza, int altezza) {
        super(img, (double)x, (double)y, (double)larghezza, (double)altezza);
        this.vel = 0;
    }

    public Bro(int x, int y, int larghezza, int altezza) {
        super((double)x, (double)y, (double)larghezza, (double)altezza);
        this.vel = 0;
    }

    public Bro(int larghezza, int altezza) {
        super(0.0, 0.0, (double)larghezza, (double)altezza);
        this.vel = 0;
    }

    public Bro(Image img, Point2D.Double c, Dimension d) {
        super(c, d);
        this.img = img;
        this.vel = 0;
    }

    public Bro(Point2D.Double c, Dimension d) {
        super(c, d);
        this.vel = 0;
    }

    // ====================
    // COSTRUTTORI BASE CON double (vel = 0)
    // ====================
    public Bro(Image img, double x, double y, double larghezza, double altezza) {
        super(img, x, y, larghezza, altezza);
        this.vel = 0;
    }

    public Bro(double x, double y, double larghezza, double altezza) {
        super(x, y, larghezza, altezza);
        this.vel = 0;
    }

    public Bro(double larghezza, double altezza) {
        super(0.0, 0.0, larghezza, altezza);
        this.vel = 0;
    }

    // ====================
    // COSTRUTTORI CON VELOCITÀ int
    // ====================
    public Bro(Image img, int x, int y, int larghezza, int altezza, int vel) {
        super(img, (double)x, (double)y, (double)larghezza, (double)altezza);
        this.vel = vel;
    }

    public Bro(int x, int y, int larghezza, int altezza, int vel) {
        super((double)x, (double)y, (double)larghezza, (double)altezza);
        this.vel = vel;
    }

    public Bro(int larghezza, int altezza, int vel) {
        super(0.0, 0.0, (double)larghezza, (double)altezza);
        this.vel = vel;
    }

    // ====================
    // COSTRUTTORI CON VELOCITÀ double
    // ====================
    public Bro(Image img, double x, double y, double larghezza, double altezza, int vel) {
        super(img, x, y, larghezza, altezza);
        this.vel = vel;
    }

    public Bro(double x, double y, double larghezza, double altezza, int vel) {
        super(x, y, larghezza, altezza);
        this.vel = vel;
    }

    public Bro(double larghezza, double altezza, int vel) {
        super(0.0, 0.0, larghezza, altezza);
        this.vel = vel;
    }

    public Bro(Image img, Point2D.Double c, Dimension d, int vel) {
        super(c, d);
        this.img = img;
        this.vel = vel;
    }

    public Bro(Point2D.Double c, Dimension d, int vel) {
        super(c, d);
        this.vel = vel;
    }
    
    
    public void sx() {
       this.direction = this.directions[1];
       Movimentor m = new Movimentor(vel);
       this.coo.x -= m.distanzaRettilinio(this);
       this.coo1.x -= m.distanzaRettilinio(this);
       this.coo2.x -= m.distanzaRettilinio(this);
       this.coo3.x -= m.distanzaRettilinio(this);
    }

    public void dx() {
        if(vel == 0)return;
        this.direction = this.directions[3];
        Movimentor m = new Movimentor(vel);
        this.coo.x+=m.distanzaRettilinio(this);
        this.coo1.x+=m.distanzaRettilinio(this);
        this.coo2.x+=m.distanzaRettilinio(this);
        this.coo3.x+=m.distanzaRettilinio(this);
    }

    public void up() {
        if(vel == 0)return;
        this.direction = this.directions[0];
        Movimentor m = new Movimentor(vel);
        this.coo.y-=m.distanzaRettilinio(this);
        this.coo1.y-=m.distanzaRettilinio(this);
        this.coo2.y-=m.distanzaRettilinio(this);
        this.coo3.y-=m.distanzaRettilinio(this);
    }

    public void dwn() {
        if(vel == 0)return;
        this.direction = this.directions[2];
        Movimentor m = new Movimentor(vel);
        this.coo.y+=m.distanzaRettilinio(this);
        this.coo1.y+=m.distanzaRettilinio(this);
        this.coo2.y+=m.distanzaRettilinio(this);
        this.coo3.y+=m.distanzaRettilinio(this);
    }
    
    
    public void sx(int x) {
        if(x<=0)return;
        this.direction = this.directions[1];
        Movimentor m = new Movimentor(x);
        this.coo.x -= m.distanzaRettilinio(this);
        this.coo1.x -= m.distanzaRettilinio(this);
        this.coo2.x -= m.distanzaRettilinio(this);
        this.coo3.x -= m.distanzaRettilinio(this);

    }

    public void dx(int x) {
        if(x<=0)return;
        this.direction = this.directions[3];
        Movimentor m = new Movimentor(x);
        this.coo.x+=m.distanzaRettilinio(this);
        this.coo1.x+=m.distanzaRettilinio(this);
        this.coo2.x+=m.distanzaRettilinio(this);
        this.coo3.x+=m.distanzaRettilinio(this);
    }

    public void up(int y) {
        if(y<=0)return;
        this.direction = this.directions[0];
        Movimentor m = new Movimentor(y);
        this.coo.y-=m.distanzaRettilinio(this);
        this.coo1.y-=m.distanzaRettilinio(this);
        this.coo2.y-=m.distanzaRettilinio(this);
        this.coo3.y-=m.distanzaRettilinio(this);
    }

    public void dwn(int y) {
        if(y<=0)return;
        this.direction = this.directions[2];
        Movimentor m = new Movimentor(y);
        this.coo.y+=m.distanzaRettilinio(this);
        this.coo1.y+=m.distanzaRettilinio(this);
        this.coo2.y+=m.distanzaRettilinio(this);
        this.coo3.y+=m.distanzaRettilinio(this);
    }
   
    public void ferma(){if(vel!=0)vel = 0; this.setDirection0(); System.out.println("fermato");}
    
    public String toString(){
    return coo + "\t\t" + this.getDimension();
    }
    

}
