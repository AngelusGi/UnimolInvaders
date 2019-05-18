package GUI;

import Logic.AlienoBoss;

import javax.swing.*;
import java.awt.*;

public class AlienoBossGUI extends JPanel implements Runnable {

    private Image immagineBoss;
    private AlienoBoss alienoBoss;

    public AlienoBossGUI() {
        alienoBoss = new AlienoBoss();
        //@todo capire perché non legge l'immagine, forse da ricostruire il png
        immagineBoss = new ImageIcon(this.getClass().getResource("unimolBoss.png")).getImage();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Color trasparente = new Color(1f,0f,0f,0f );
        graphics.setColor(trasparente);

//        graphics.setColor(Color.GREEN);

       //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
        graphics.fillRect(alienoBoss.getPosX(), alienoBoss.getPosY(), alienoBoss.getDimBossX(), alienoBoss.getDimBossY());
        graphics.drawImage(this.immagineBoss, alienoBoss.getPosX(), alienoBoss.getPosY(), trasparente, null);


    }


    @Override
    public void run() {
        while (alienoBoss.isVivo()) {
            alienoBoss.muovi(alienoBoss.getPosX(), alienoBoss.getPosY());
            repaint();
        }
    }


}
