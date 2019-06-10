package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Colpo;
import UniMolInvaders.Logic.Nemico;
import UniMolInvaders.Logic.Personaggio;

import javax.swing.*;
import java.awt.*;

public class ColpoGUI extends Colpo {

    private Image immagineColpo;

    private static final int DIREZIONE_GIOCATORE = -1;
    private static final int DIREZIONE_ALIENO = 1;

    private static final int DIM_COLPO_X = 11;
    private static final int DIM_COLPO_Y = 29;


    public ColpoGUI(Personaggio personaggio){
        super(personaggio.getPosX(), personaggio.getPosY(), DIREZIONE_GIOCATORE);
        immagineColpo = new ImageIcon(this.getClass().getResource("./Resources/colpoUp.png")).getImage();
    }

    public ColpoGUI(Nemico nemico){
        super(nemico.getPosX(), nemico.getPosY(), DIREZIONE_ALIENO);
        immagineColpo = new ImageIcon(this.getClass().getResource("./Resources/colpoDown.png")).getImage();
    }

    public int getDimColpoX() {
        return DIM_COLPO_X;
    }

    public int getDimColpoY() {
        return DIM_COLPO_Y;
    }

    public void paint(Graphics graphics) {

        Color trasparente = new Color(1f,0f,0f,0f );
        graphics.setColor(trasparente);

//        graphics.setColor(Color.GREEN);
//        graphics.fillRect(this.getPosX(), this.getPosY(), this.getDimColpoX(), this.getDimColpoY());

        graphics.drawImage(this.immagineColpo, this.getPosX(), this.getPosY(), trasparente, null);
    }



    public void run() {
        while (this.isSparato()){
            this.muovi(this.getPosY());
        }
    }
}
