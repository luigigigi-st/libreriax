/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.games;




import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

class Entity {

    protected Image img;
    public Point2D.Double coo, coo1, coo2, coo3; // vertici
    protected final char[] directions = new char[]{'U','L','D','R','0'};
    protected char direction;
    protected double angolo; // in gradi, default 0
    protected double larghezzaCalcolata;
    protected double altezzaCalcolata;

    // ====================
    // COSTRUTTORI
    // ====================
    public Entity(Image img, double x, double y, double larghezza, double altezza) {
        this.img = img;
        coo = new Point2D.Double(x, y);
        direction = directions[4];
        angolo = 0;
        coo1 = new Point2D.Double(coo.x + larghezza, coo.y);
        coo2 = new Point2D.Double(coo.x, coo.y + altezza);
        coo3 = new Point2D.Double(coo.x + larghezza, coo.y + altezza);
        aggiornaDimensioni();
    }

    public Entity(double x, double y, double larghezza, double altezza) {
        this(null, x, y, larghezza, altezza);
    }

    public Entity(Point2D.Double c, Dimension d) {
        this.img = null;
        coo = c;
        direction = directions[4];
        angolo = 0;
        coo1 = new Point2D.Double(coo.x + d.width, coo.y);
        coo2 = new Point2D.Double(coo.x, coo.y + d.height);
        coo3 = new Point2D.Double(coo.x + d.width, coo.y + d.height);
        aggiornaDimensioni();
    }

    public Entity(Entity b) {
        this.img = b.img;
        this.direction = b.direction;
        this.angolo = b.angolo;
        this.coo = new Point2D.Double(b.coo.x, b.coo.y);
        this.coo1 = new Point2D.Double(b.coo1.x, b.coo1.y);
        this.coo2 = new Point2D.Double(b.coo2.x, b.coo2.y);
        this.coo3 = new Point2D.Double(b.coo3.x, b.coo3.y);
        this.larghezzaCalcolata = b.larghezzaCalcolata;
        this.altezzaCalcolata = b.altezzaCalcolata;
    }

    public Entity(Point2D.Double c, Point2D.Double c1, Point2D.Double c2, Point2D.Double c3) {
        this.coo = c;
        this.coo1 = c1;
        this.coo2 = c2;
        this.coo3 = c3;
        this.img = null;
        this.direction = directions[4];
        this.angolo = 0;
        aggiornaDimensioni();
    }

    // ====================
    // GETTER
    // ====================
    public Image getImg() { return this.img; }
    public Dimension getDimension() { return new Dimension(getLarghezzaRealeInt(), getAltezzaRealeInt()); }
    public int getX() { return (int) coo.x; }
    public int getY() { return (int) coo.y; }
    public int getLarghezzaRealeInt() { return (int) Math.round(larghezzaCalcolata); }
    public int getAltezzaRealeInt() { return (int) Math.round(altezzaCalcolata); }
    public char getDirection() { return direction; }
    public double getAngolo() { return angolo; }
    public double getAngoloRAD(){return Math.PI * angolo / 180;}
    public double getBaricentroX() { return (coo.x + coo1.x + coo2.x + coo3.x) / 4.0; }
    public double getBaricentroY() { return (coo.y + coo1.y + coo2.y + coo3.y) / 4.0; }
    public Point2D.Double getBaricentro() { return new Point2D.Double(getBaricentroX(), getBaricentroY()); }
    public ArrayList<Point2D.Double> getVertici() {
        ArrayList<Point2D.Double> lista = new ArrayList<>();
        lista.add(coo);
        lista.add(coo1);
        lista.add(coo2);
        lista.add(coo3);
        return lista;
    }
    public ArrayList<Point2D.Double> getVerticiCopy() {
        ArrayList<Point2D.Double> lista = new ArrayList<>();
        lista.add(new Point2D.Double(coo.x, coo.y));
        lista.add(new Point2D.Double(coo1.x, coo1.y));
        lista.add(new Point2D.Double(coo2.x, coo2.y));
        lista.add(new Point2D.Double(coo3.x, coo3.y));
        return lista;
    }

    // ====================
    // SETTER
    // ====================
    public void setVertici(double x, double y) {
        double lar = larghezzaCalcolata > 0 ? larghezzaCalcolata : coo1.x - coo.x;
        double h = altezzaCalcolata > 0 ? altezzaCalcolata : coo2.y - coo.y;
        coo = new Point2D.Double(x, y);
        coo1 = new Point2D.Double(x + lar, y);
        coo2 = new Point2D.Double(x, y + h);
        coo3 = new Point2D.Double(x + lar, y + h);
        aggiornaDimensioni();
    }
    public void setX(double x) { coo.x = x; aggiornaDimensioni(); }
    public void setY(double y) { coo.y = y; aggiornaDimensioni(); }
    public void setX1(double x) { coo1.x = x; aggiornaDimensioni(); }
    public void setY1(double y) { coo1.y = y; aggiornaDimensioni(); }
    public void setX2(double x) { coo2.x = x; aggiornaDimensioni(); }
    public void setY2(double y) { coo2.y = y; aggiornaDimensioni(); }
    public void setX3(double x) { coo3.x = x; aggiornaDimensioni(); }
    public void setY3(double y) { coo3.y = y; aggiornaDimensioni(); }
    public void setCoordinate(Point2D.Double c) { coo = c; aggiornaDimensioni(); }
    public void setDirection(char direction) { this.direction = direction; }
    public void setDirectionDx() { this.direction = directions[3]; }
    public void setDirectionSx() { this.direction = directions[1]; }
    public void setDirectionUp() { this.direction = directions[0]; }
    public void setDirectionDwn() { this.direction = directions[2]; }
    public void setDirection0() { this.direction = directions[4]; }

    public void setCooByBaricentro(Point2D.Double baricentro) {
        double x = baricentro.x - larghezzaCalcolata/2.0;
        double y = baricentro.y - altezzaCalcolata/2.0;
        setVertici(x, y);
    }

    public void setBaricentroAlCentro(JPanel jp) {
        double x = jp.getWidth()/2.0;
        double y = jp.getHeight()/2.0;
        if (x == 0 && y == 0) {
            x = jp.getPreferredSize().width/2.0;
            y = jp.getPreferredSize().height/2.0;
        }
        setCooByBaricentro(new Point2D.Double(x, y));
    }

    // ====================
    // ROTAZIONE
    // ====================
    public void ruotaAngolo(double gradi) {
        angolo = gradi;
        double t = Math.toRadians(gradi);
        Point2D.Double centro = getBaricentro();
        coo = ruotaPunto(coo, centro, t);
        coo1 = ruotaPunto(coo1, centro, t);
        coo2 = ruotaPunto(coo2, centro, t);
        coo3 = ruotaPunto(coo3, centro, t);
        aggiornaDimensioni();
    }
    
    public void ruota(double gradi) {
        angolo += gradi;
        double t = Math.toRadians(gradi);
        Point2D.Double centro = getBaricentro();
        coo = ruotaPunto(coo, centro, t);
        coo1 = ruotaPunto(coo1, centro, t);
        coo2 = ruotaPunto(coo2, centro, t);
        coo3 = ruotaPunto(coo3, centro, t);
        aggiornaDimensioni();
    }

    private Point2D.Double ruotaPunto(Point2D.Double p, Point2D.Double centro, double rad) {
        double x1 = (p.x - centro.x) * Math.cos(rad) - (p.y - centro.y) * Math.sin(rad) + centro.x;
        double y1 = (p.x - centro.x) * Math.sin(rad) + (p.y - centro.y) * Math.cos(rad) + centro.y;
        return new Point2D.Double(x1, y1);
    }

    public void ruota30() { ruotaAngolo(30); }
    public void ruota45() { ruotaAngolo(45); }
    public void ruota60() { ruotaAngolo(60); }
    public void ruota90() { ruotaAngolo(90); }
    public void ruota180() { ruotaAngolo(180); }

    // ====================
    // AGGIORNA DIMENSIONI USANDO PITAGORA
    // ====================
    public void aggiornaDimensioni() {
        larghezzaCalcolata = distanza(coo, coo1);
        altezzaCalcolata = distanza(coo, coo2);
    }

    private double distanza(Point2D.Double p1, Point2D.Double p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

 

    // ====================
    // toString
    // ====================
    @Override
    public String toString() {
        return coo + "&&";
    }

    // ====================
    // GETTER PIXEL GUI
    // ====================
    public int getXInt() { return (int) Math.round(coo.x); }
    public int getYInt() { return (int) Math.round(coo.y); }
    public int getX1Int() { return (int) Math.round(coo1.x); }
    public int getY1Int() { return (int) Math.round(coo1.y); }
    public int getX2Int() { return (int) Math.round(coo2.x); }
    public int getY2Int() { return (int) Math.round(coo2.y); }
    public int getX3Int() { return (int) Math.round(coo3.x); }
    public int getY3Int() { return (int) Math.round(coo3.y); }
}
