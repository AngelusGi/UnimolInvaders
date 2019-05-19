package GUI;

/********************************
 *
 *   user:      angel
 *   date:      04/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


import Logic.Alieni;
import Logic.Alieno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlienoGUI extends JPanel {

    private Image immagineAlieno;
    private ArrayList<Alieno> listaAlieni;

    private Alieni alieni;

    public AlienoGUI(){
        alieni = new Alieni(0);
        listaAlieni = alieni.getListaAlieni();
        immagineAlieno = new ImageIcon(this.getClass().getResource("alieno.png")).getImage();

    }


    public void paint(Graphics graphics) {

        super.paint(graphics);

        Color trasparente = new Color(1f,0f,0f,0f );
        graphics.setColor(trasparente);


        for (int num = 0; num < listaAlieni.size(); num++) {

            //CREA UN RETTANGOLO DI DIM_ALIENIxDIM_ALIENI PER OGNI ALIENO NELLA MATRICE
            graphics.fillRect(listaAlieni.get(num).getPosX(), listaAlieni.get(num).getPosY(), listaAlieni.get(num).getDIM_NEMICO_X(), listaAlieni.get(num).getDIM_NEMICO_Y());
            graphics.drawImage(this.immagineAlieno, listaAlieni.get(num).getPosX(), listaAlieni.get(num).getPosY(), trasparente, null);

        }


    }


}
