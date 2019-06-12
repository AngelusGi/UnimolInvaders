package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerGraph extends Player {

    private Image image;

    public PlayerGraph(int posX, int posY) {
        super(posX, posY);
        image = new ImageIcon(this.getClass().getResource("./Resources/giocatore.png")).getImage();

    }


    public void paint(Graphics graphics) {

        if (isAlive()) {
            Color trasparent = new Color(0f, 0f, 0f, 0f);
            graphics.setColor(trasparent);

            //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
            graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());
            graphics.drawImage(this.getImage(), this.getPosX(), this.getPosY(), trasparent, null);
        }
    }


    private Image getImage() {
        return image;
    }

}
