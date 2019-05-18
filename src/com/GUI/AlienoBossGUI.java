package GUI;

import Logic.AlienoBoss;

import javax.swing.*;
import java.awt.*;

public class AlienoBossGUI extends JPanel implements Runnable {

    private AlienoBoss alienoBoss;

    public AlienoBossGUI() {
        alienoBoss = new AlienoBoss();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Color trasparente = new Color(1f,0f,0f,0f );
        graphics.setColor(trasparente);
        graphics.setColor(Color.BLACK);


       //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
//        graphics.fillRect(alienoBoss.getPosX(), alienoBoss.getPosY(), alienoBoss.getDimBossX(), alienoBoss.getDimBossY());
        graphics.drawImage(alienoBoss.getImmagineBoss(), alienoBoss.getPosX(), alienoBoss.getPosY(), trasparente, null);


    }

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }
}
