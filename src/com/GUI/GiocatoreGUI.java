package GUI;

import Logic.Personaggio;

import javax.swing.*;
import java.awt.*;

public class GiocatoreGUI extends Personaggio {

    private Image immaginePersonaggio;

    public GiocatoreGUI(){
        super();
        immaginePersonaggio = new ImageIcon(this.getClass().getResource("giocatore.png")).getImage();

    }

    public void paint(Graphics graphics) {

        while (isVivo()){
            Color trasparente = new Color(1f,0f,0f,0f );
//        graphics.setColor(trasparente);
            graphics.setColor(Color.BLACK);


            //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
            graphics.fillRect(getPosX(), getPosY(), getDIM_GIOCATORE_X(), getDIM_GIOCATORE_Y());
            graphics.drawImage(this.getImmaginePersonaggio(), getPosX(), getPosY(), trasparente, null);
        }



    }

    private Image getImmaginePersonaggio() {
        return immaginePersonaggio;
    }
}
