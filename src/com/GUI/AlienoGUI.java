package GUI;

/********************************
 *
 *   user:      angel
 *   date:      04/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

import Logica.Alieni;
import Logica.Alieno;

import java.awt.*;

public class AlienoGUI {

    private static int DISTANZA_ALIENI = 10;

    public AlienoGUI(Alieni alieni){

        Alieno[][] matrixAliens = alieni.getMatrixAliens();

    }

    public void paint(Graphics2D graphics2D) {

        //RENDE I BORDI DEI COMPONENTI 2D PIù SMUSSATI
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//        graphics2D.fillRect();

    }

    public Rectangle getBounds() {
        return new Rectangle();
    }

}
