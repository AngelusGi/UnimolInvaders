package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Boss;

import javax.swing.*;
import java.awt.*;

public class BossGraph extends Boss {

    private Image image;

    public BossGraph(int posX, int posY, int speed) {
        super(posX, posY, speed);
        image = new ImageIcon(this.getClass().getResource("./Resources/unimolBoss.png")).getImage();

    }


    public void paint(Graphics graphics) {

        Color trasparent = new Color(1f, 0f, 0f, 0f);
//        graphics.setColor(trasparent);

        graphics.setColor(Color.GREEN);

        graphics.fillRect(300, 150, 80, 50);

        //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
//        graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());
//        graphics.drawImage(this.image, this.getPosX(), this.getPosY(), trasparent, null);

    }

    public void run() {
        if (isAlive()) {
            move();
        }
    }

    public Rectangle getBounds() {

        return new Rectangle(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());
    }

}
