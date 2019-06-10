package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Personaggio;

import javax.swing.*;
import java.awt.*;

public class PersonaggioGUI extends Personaggio {

    private Image immaginePersonaggio;

    public PersonaggioGUI(int posX, int posY){
            super(posX, posY);
            immaginePersonaggio = new ImageIcon(this.getClass().getResource("./Resources/giocatore.png")).getImage();

        }

    
    public void paint(Graphics graphics) {

        while (isVivo()){
            Color trasparente = new Color(1f,0f,0f,0f );
//        graphics.setColor(trasparente);
            graphics.setColor(Color.BLACK);


            //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
            graphics.fillRect(this.getPosX(), this.getPosY(), this.getDIM_GIOCATORE_X(), this.getDIM_GIOCATORE_Y());
            graphics.drawImage(this.getImmaginePersonaggio(), this.getPosX(), this.getPosY(), trasparente, null);
        }


    }

    private Image getImmaginePersonaggio() {
        return immaginePersonaggio;
    }
}
