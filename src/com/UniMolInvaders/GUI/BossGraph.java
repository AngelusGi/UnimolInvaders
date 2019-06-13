package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Boss;

import javax.swing.*;
import java.awt.*;

public class BossGraph extends Boss {

    private Image image;

    private final int DIM_X = 80;
    private final int DIM_Y = 90;

    private ShotGraph shot;

    public BossGraph(int posX, int posY, int speed) {
        //todo scassato
        super(posX, posY, speed);
        image = new ImageIcon(this.getClass().getResource("./Resources/unimolBoss.png")).getImage();
        setDimX(DIM_X);
        setDimY(DIM_Y);
    }


    public void paint(Graphics2D graphics) {

        if (isAlive()) {

            Color trasparent = new Color(1f, 0f, 0f, 0f);
            graphics.setColor(trasparent);

            //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
//            graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());
            graphics.drawImage(this.image, this.getPosX(), this.getPosY(), trasparent, null);
        }

        if (shot != null) {
            shot.paint(graphics);
        }
    }

    public void run() {
        if (isAlive()) {
            move();
            shoot();
            moveShoot();
        }
    }

}
