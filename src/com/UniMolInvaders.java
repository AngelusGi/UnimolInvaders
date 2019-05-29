import GUI.*;
import Logic.Alieni;
import Logic.FinePartita;

import javax.swing.*;

/********************************
 *
 *   user:      angel
 *   date:      01/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class UniMolInvaders {

    protected final static String nomeFinestra = "UniMol Invaders";
    private final static int DIM_FINESTRA_X = 1024;
    private final static int DIM_FINESTRA_Y = 768;


    public static void main(String[] args) {

        JFrame finestra = new JFrame(nomeFinestra);
        finestra.setSize(DIM_FINESTRA_X, DIM_FINESTRA_Y);
        finestra.setResizable(false);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        MenuGUI menu = new MenuGUI(finestra);
//        finestra.add(menu);
//        finestra.setVisible(true);

        IntroGUI intro = new IntroGUI(finestra);


//        GamePanel gioco = new GamePanel();
//        finestra.add(gioco);
//        finestra.setVisible(true);

    }
}
