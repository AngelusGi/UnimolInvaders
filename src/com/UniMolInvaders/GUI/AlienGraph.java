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

    public AlienGraph(int posX, int posY, int speed){
        super(posX, posY, speed);
        setDimX(DIM_X);
        setDimY(DIM_Y);
        image = new ImageIcon(this.getClass().getResource("./Resources/alieno.png")).getImage();
    }

    public void paint(Graphics graphics) {

        //RENDE I BORDI DEI COMPONENTI 2D PIù SMUSSATI
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isAlive()){
//            graphics.setColor(Color.RED);

            Color trasparente = new Color(1f,0f,0f,0f );
            graphics.setColor(trasparente);

            graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());
            graphics.drawImage(this.image, this.getPosX(), this.getPosY(), null);
        }

    }

    public Rectangle getBounds() {

        return new Rectangle(this.getPosX(), this.getPosY(), this.getDimX(), this.getDimY());
    }

    public void run() {
        if (isAlive()) {
            move();
        }
    }

}
