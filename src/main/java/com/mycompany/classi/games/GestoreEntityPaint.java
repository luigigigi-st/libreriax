/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author migna
 */
public class GestoreEntityPaint {

    // ====================
    // DISEGNA OMNINO
    // ====================
    public static void disegna_omino(Graphics2D g2d, Bro b) {
        Shape oldClip = g2d.getClip(); // salva il clip corrente

        int d = b.getLarghezzaRealeInt(), x = b.getX(), y = b.getY();
        int r = d / 2;
        g2d.setColor(Color.red);
        int lStecca = r * 3; // lunghezza stecca
        int collox = x + r, colloy = y + d, culoy = y + d + lStecca;
        g2d.drawLine(collox, colloy, x + r, culoy); // stecca

        g2d.drawLine(collox, colloy + (lStecca / 10), x, colloy + (lStecca * 2 / 3)); // braccio dx
        g2d.drawLine(collox, colloy + (lStecca / 10), x + d, colloy + (lStecca * 2 / 3)); // braccio sx

        g2d.drawLine(collox, culoy, x, culoy + (lStecca * 2 / 3)); // gamba dx
        g2d.drawLine(collox, culoy, x + d, culoy + (lStecca * 2 / 3)); // gamba sx

        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, d, d);
        g2d.setClip(circle);
        g2d.drawImage(b.getImg(), x, y, d, d, null);
        g2d.setClip(oldClip); // reset clip
    }
 
    public static void drawImageByBaricentro(Graphics2D g2d, Image img, Bro b) {
    if (img == null || b == null) return;

    // 1. Recupero dati direttamente tramite i metodi della classe Entity
    Point2D.Double centro = b.getBaricentro();
    double angoloRad = b.getAngoloRAD(); 
    int w = b.getLarghezzaRealeInt();
    int h = b.getAltezzaRealeInt();

    // 2. Salvo il contesto grafico attuale (per ripristinarlo dopo)
    AffineTransform backup = g2d.getTransform();

    // 3. Applico le trasformazioni in ordine:
    
    // A) Sposto l'origine del disegno sul baricentro dell'entità
    g2d.translate(centro.x, centro.y);
    
    // B) Ruoto il foglio (canvas) attorno alla nuova origine
    g2d.rotate(angoloRad);

    // 4. Disegno l'immagine
    // Poiché ora l'origine (0,0) è esattamente al centro dell'entità,
    // per disegnare l'immagine centrata devo partire da (-metà larghezza, -metà altezza)
    g2d.drawImage(img, -w / 2, -h / 2, w, h, null);

    // 5. Ripristino la trasformazione originale
    g2d.setTransform(backup);
}
    
    public static void drawImageByBaricentro(Graphics2D g2d, Image img, Point2D.Double co,int w,int h,double angolo) {
    if (img == null) return;

    // 1. Recupero dati direttamente tramite i metodi della classe Entity
    Point2D.Double centro = co;

    // 2. Salvo il contesto grafico attuale (per ripristinarlo dopo)
    AffineTransform backup = g2d.getTransform();

    // 3. Applico le trasformazioni in ordine:
    
    // A) Sposto l'origine del disegno sul baricentro dell'entità
    g2d.translate(centro.x, centro.y);
    
    // B) Ruoto il foglio (canvas) attorno alla nuova origine
    g2d.rotate(angolo);

    // 4. Disegno l'immagine
    // Poiché ora l'origine (0,0) è esattamente al centro dell'entità,
    // per disegnare l'immagine centrata devo partire da (-metà larghezza, -metà altezza)
    g2d.drawImage(img, -w / 2, -h / 2, w, h, null);

    // 5. Ripristino la trasformazione originale
    g2d.setTransform(backup);
}

}
