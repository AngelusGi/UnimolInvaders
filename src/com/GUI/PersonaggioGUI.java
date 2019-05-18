package GUI;

import Logic.Personaggio;

import javax.swing.*;
import java.awt.*;

public class PersonaggioGUI extends JPanel implements Runnable {

    private Personaggio giocatore;
    
    public PersonaggioGUI(){
        giocatore = new Personaggio();
    }
    
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Color trasparente = new Color(1f,0f,0f,0f );
        graphics.setColor(trasparente);
//        graphics.setColor(Color.BLACK);


        //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
        graphics.fillRect(giocatore.getPosX(), giocatore.getPosY(), giocatore.getDIM_NAVICELLA_X(), giocatore.getDIM_NAVICELLA_Y());
        graphics.drawImage(giocatore.getImmaginePersonaggio(), giocatore.getPosX(), giocatore.getPosY(), trasparente, null);


    }

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }

}
