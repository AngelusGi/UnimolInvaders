package GUI;

/********************************
 *
 *   user:      angel
 *   date:      04/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


import Logic.Alieni;
import Logic.Alieno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlienoGUI extends JPanel implements Runnable {

    private Image immagineAlieno;
    private ArrayList<Alieno> listaAlieni;

    private Alieni alieni;

    public AlienoGUI(){
        alieni = new Alieni(0);
        listaAlieni = alieni.getListaAlieni();
        immagineAlieno = new ImageIcon(this.getClass().getResource("alieno.png")).getImage();
    }

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }

    public void paint(Graphics graphics) {

        super.paint(graphics);

        Color trasparente = new Color(1f,0f,0f,0f );
//        graphics.setColor(Color.RED);
        graphics.setColor(trasparente);


        for (int num = 0; num < listaAlieni.size(); num++) {

            //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
            graphics.fillRect(listaAlieni.get(num).getPosX(), listaAlieni.get(num).getPosY(), Alieno.getDimAlienoX(), Alieno.getDimAlienoY());
            graphics.drawImage(this.immagineAlieno, listaAlieni.get(num).getPosX(), listaAlieni.get(num).getPosY(), trasparente, null);

        }

        //stampa punteggio nel game over
//        graphics.setColor(Color.GRAY);
//        graphics.setFont(new Font("Verdana", Font.BOLD, 30));
////        graphics.drawString(String.valueOf(getPunteggio()), 10, 30);
//        graphics.drawString("PROVA STRINGA", 10, 30);
    }


//    public void paint(Graphics2D graphics2D) {
//
//        //RENDE I BORDI DEI COMPONENTI 2D PIù SMUSSATI
//        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
////        graphics2D.fillRect();
//
//    }

    public Rectangle getBounds() {
        return new Rectangle();
    }

}
