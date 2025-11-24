/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classi.games;


import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author migna
 */
public class GestoreEntity {

    
    
    // ====================
    // COLLISIONI TRA ENTITY
    // ====================
    public static boolean collisione(Bro a, Bro b) {
        // se entrambi hanno rotazione multiplo di 90°, usa bounding box sugli assi
        if ((a.getAngolo() % 90 == 0) && (b.getAngolo() % 90 == 0)) {
            int aMinX = minX(a), aMaxX = maxX(a);
            int aMinY = minY(a), aMaxY = maxY(a);
            int bMinX = minX(b), bMaxX = maxX(b);
            int bMinY = minY(b), bMaxY = maxY(b);

            boolean overlapX = (aMaxX >= bMinX && aMinX <= bMaxX);
            boolean overlapY = (aMaxY >= bMinY && aMinY <= bMaxY);
            return overlapX && overlapY;
        } else {
            // altrimenti SAT
            return polygonsIntersect(a.getVertici(), b.getVertici());
        }
    }

    public static boolean collisionePunto(Entity a, Point2D.Double p) {
        return pointInPolygon(p, a.getVertici());
    }

    // ====================
    // COLLISIONE CON JCOMPONENT
    // ====================
    public static boolean collisionXJC(JComponent jc, Bro e) {
        return minX(e) < 0 || maxX(e) > jc.getWidth();
    }

    public static boolean collisionYJC(JComponent jc, Bro e) {
        return minY(e) < 0 || maxY(e) > jc.getHeight();
    }

    public static boolean collisionJC(JComponent jc, Bro e) {
        return collisionXJC(jc, e) || collisionYJC(jc, e);
    }



    // ====================
    // FUNZIONI BOUNDING BOX
    // ====================
    private static int minX(Entity e) {
        return (int) Math.round(Math.min(Math.min(e.coo.x, e.coo1.x), Math.min(e.coo2.x, e.coo3.x)));
    }

    private static int maxX(Entity e) {
        return (int) Math.round(Math.max(Math.max(e.coo.x, e.coo1.x), Math.max(e.coo2.x, e.coo3.x)));
    }

    private static int minY(Entity e) {
        return (int) Math.round(Math.min(Math.min(e.coo.y, e.coo1.y), Math.min(e.coo2.y, e.coo3.y)));
    }

    private static int maxY(Entity e) {
        return (int) Math.round(Math.max(Math.max(e.coo.y, e.coo1.y), Math.max(e.coo2.y, e.coo3.y)));
    }

    // ====================
    // FUNZIONI SAT
    // ====================
    private static boolean polygonsIntersect(ArrayList<Point2D.Double> poly1, ArrayList<Point2D.Double> poly2) {
        return !separatingAxisExists(poly1, poly2) && !separatingAxisExists(poly2, poly1);
    }

    private static boolean separatingAxisExists(ArrayList<Point2D.Double> poly1, ArrayList<Point2D.Double> poly2) {
        for (int i = 0; i < poly1.size(); i++) {
            Point2D.Double p1 = poly1.get(i);
            Point2D.Double p2 = poly1.get((i + 1) % poly1.size());
            double normalX = -(p2.y - p1.y);
            double normalY = p2.x - p1.x;
            double[] proj1 = projectPolygon(poly1, normalX, normalY);
            double[] proj2 = projectPolygon(poly2, normalX, normalY);
            if (proj1[1] < proj2[0] || proj2[1] < proj1[0]) return true;
        }
        return false;
    }

    private static double[] projectPolygon(ArrayList<Point2D.Double> poly, double axisX, double axisY) {
        double min = Double.MAX_VALUE, max = -Double.MAX_VALUE;
        for (Point2D.Double p : poly) {
            double proj = (p.x * axisX + p.y * axisY) / (axisX * axisX + axisY * axisY);
            if (proj < min) min = proj;
            if (proj > max) max = proj;
        }
        return new double[]{min, max};
    }

    private static boolean pointInPolygon(Point2D.Double point, ArrayList<Point2D.Double> polygon) {
        boolean result = false;
        int j = polygon.size() - 1;
        for (int i = 0; i < polygon.size(); i++) {
            if ((polygon.get(i).y < point.y && polygon.get(j).y >= point.y ||
                 polygon.get(j).y < point.y && polygon.get(i).y >= point.y) &&
                 (polygon.get(i).x + (point.y - polygon.get(i).y) /
                 (polygon.get(j).y - polygon.get(i).y) * (polygon.get(j).x - polygon.get(i).x) < point.x)) {
                result = !result;
            }
            j = i;
        }
        return result;
    }
    
    

    

    

}
