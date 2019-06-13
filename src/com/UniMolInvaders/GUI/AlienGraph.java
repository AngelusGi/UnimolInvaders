package UniMolInvaders.GUI;

/********************************
 *
 *   user:      angel
 *   date:      04/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


import UniMolInvaders.Logic.Alien;

import javax.swing.*;
import java.awt.*;


public class AlienGraph extends Alien {

    private final int DIM_X = 37;
    private final int DIM_Y = 50;

    private Image image;
    private ShotGraph shot;

    public AlienGraph(int posX, int posY, int speed) {
        super(posX, posY, speed);
        setDimX(DIM_X);
        setDimY(DIM_Y);
        image = new ImageIcon(this.getClass().getResource("./Resources/alieno.png")).getImage();
    }

    public void paint(Graphics2D graphics) {

        //RENDE I BORDI DEI COMPONENTI 2D PIù SMUSSATI
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isAlive()) {

            Color trasparente = new Color(1f, 0f, 0f, 0f);
            graphics.setColor(trasparente);

//            graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());
            graphics.drawImage(this.image, this.getPosX(), this.getPosY(), null);
        }

    }

    public void shoot() {

        if (shot == null) {

            shot = new ShotGraph(this.getPosX() + this.DIM_X / 2, this.getPosY() + this.DIM_Y, ShotGraph.ENEMY_DIRECTION);
            if (shot.isShooted()) {
                shot.setShooted(false);
            }
        }

    }

}
