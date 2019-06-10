package UniMolInvaders.GUI;

/********************************
 *
 *   user:      angel
 *   date:      04/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


import UniMolInvaders.Logic.Alieno;

import javax.swing.*;
import java.awt.*;


public class AlienoGUI extends Alieno {

    private final int DIM_ALIENO_X = 37;
    private final int DIM_ALIENO_Y = 50;

    private Image immagineAlieno;

    public AlienoGUI(int posX, int posY, int velocita){
        super(posX, posY, velocita);
        setDIM_NEMICO_X(DIM_ALIENO_X);
        setDIM_NEMICO_Y(DIM_ALIENO_Y);
        immagineAlieno = new ImageIcon(this.getClass().getResource("./Resources/alieno.png")).getImage();
    }

    public void paint(Graphics graphics) {

        //RENDE I BORDI DEI COMPONENTI 2D PIù SMUSSATI
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        if (isVivo()){
            graphics.setColor(Color.RED);

//            Color trasparente = new Color(1f,0f,0f,0f );
//            graphics.setColor(trasparente);

            graphics.fillRect(this.getPosX(), this.getPosY(), this.getDIM_NEMICO_X(), this.getDIM_NEMICO_Y());
            graphics.drawImage(this.immagineAlieno, this.getPosX(), this.getPosY(), null);
        }

    }

    public Rectangle getBounds() {

        return new Rectangle(this.getPosX(), this.getPosY(), this.getDIM_NEMICO_X(), this.getDIM_NEMICO_Y());
    }

    public void run() {
        while (isVivo()) {
            muovi();
        }
    }

}
