package UniMolInvaders.GUI;

import UniMolInvaders.Logic.AlienoBoss;

import javax.swing.*;
import java.awt.*;

public class AlienoBossGUI extends AlienoBoss {

    private Image immagineBoss;

    public AlienoBossGUI(int posX, int posY, int velocita) {
        super(posX, posY, velocita);
        immagineBoss = new ImageIcon(this.getClass().getResource("./Resources/unimolBoss.png")).getImage();

    }


    public void paint(Graphics graphics) {

        Color trasparente = new Color(1f,0f,0f,0f );
        graphics.setColor(trasparente);

        graphics.setColor(Color.GREEN);

       //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
        graphics.fillRect(this.getPosX(), this.getPosY(), this.getDIM_NEMICO_X(), this.getDIM_NEMICO_Y());
        graphics.drawImage(this.immagineBoss, this.getPosX(), this.getPosY(), trasparente, null);

    }

    public void run() {
        while (isVivo()) {
            muovi();
        }
    }

    public Rectangle getBounds() {

        return new Rectangle(this.getPosX(), this.getPosY(), this.getDIM_NEMICO_X(), this.getDIM_NEMICO_Y());
    }

}
