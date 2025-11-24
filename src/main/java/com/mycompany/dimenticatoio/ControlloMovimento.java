/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dimenticatoio;

import classi.games.Bro;
import classi.games.Coordinata;

/**
 *
 * @author migna
 */
public class ControlloMovimento {

    private boolean check;
    private Coordinata pos;
    private Movimentor movimento;

    public ControlloMovimento(Bro b, Movimentor m) {
        check = false;
       // pos = b.getCoordinateCopy();
        movimento = m;
    }

    public ControlloMovimento(Bro b) {
        check = false;
       // pos = b.getCoordinateCopy();
        movimento = new Movimentor();
    }
    

    public void movimentoRettilinio(Bro p) {
        if (check) {
            movimento.rettilinio(p);
            System.out.println("p:"+p.getX());
            System.out.println("p1:"+pos.x);

            if (p.getX() > pos.x + 60 * movimento.getV()) {
                System.out.println("v:"+movimento.getV());
                System.out.println("distanza:"+(p.getX() - pos.x));
                System.out.println("d:"+movimento.getV()*60);
                System.out.println("stop");
                check = false;
                pos.x=p.getX();
            }

        }
    }

    
    
    public boolean getCheck(){return check;}
    public Coordinata getPos(){return pos;}
    public Movimentor getMovimento(){return movimento;}

    public void setCheck(boolean check){this.check=check;}
    public void setPos(Coordinata pos){this.pos=pos;}
    public void setMovimento(Movimentor m){movimento=m;}

}
