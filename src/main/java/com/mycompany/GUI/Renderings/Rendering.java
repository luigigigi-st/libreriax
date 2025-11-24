/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GUI.Renderings;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author migna
 */
public class Rendering extends Thread {

    private final int FPS = 60;
    private JComponent jp;
    private Updatable u;

    public Rendering(JComponent jp,Updatable u) {
        this.jp = jp;
        this.u=u;
    }
    
        public Rendering(JComponent jp) {
        this.jp = jp;
        this.u=null;
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (!isInterrupted()) {
            if(u != null){u.update();}// chiamiamo il metodo update() del pannello
             
            jp.repaint(); // ridisegniamo il pannello

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
                this.interrupt(); // esce correttamente dal ciclo
            }
        }
    }
}
