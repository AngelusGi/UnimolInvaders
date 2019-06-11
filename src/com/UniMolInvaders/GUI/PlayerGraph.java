package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerGraph extends Player {

    private Image image;

    public PlayerGraph(int posX, int posY){
            super(posX, posY);
            image = new ImageIcon(this.getClass().getResource("./Resources/giocatore.png")).getImage();

        }

    
    public void paint(Graphics graphics) {

        while (isAlive()){
            Color trasparent = new Color(1f,0f,0f,0f );
//            graphics.setColor(trasparent);
            graphics.setColor(Color.BLACK);


            //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
            graphics.fillRect(this.getPosX(), this.getPosY(), this.getDIM_GIOCATORE_X(), this.getDIM_GIOCATORE_Y());
            graphics.drawImage(this.getImage(), this.getPosX(), this.getPosY(), trasparent, null);
        }
    }


    private Image getImage() {
        return image;
    }

}
