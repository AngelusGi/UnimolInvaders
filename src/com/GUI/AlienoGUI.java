package GUI;

import Logica.Alieni;
import Logica.Alieno;

import java.awt.*;

public class AlienoGUI {



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
