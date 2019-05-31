import GUI.*;

import javax.swing.*;

/********************************
 *
 *   user:      angel
 *   date:      01/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

class UniMolInvaders {

    private final static String nomeFinestra = "UniMol Invaders";
    private final static int DIM_FINESTRA_X = 1024;
    private final static int DIM_FINESTRA_Y = 768;


    public static void main(String[] args) {

        JFrame finestra = new JFrame(nomeFinestra);
        finestra.setSize(DIM_FINESTRA_X, DIM_FINESTRA_Y);
        finestra.setResizable(false);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuGUI menu = new MenuGUI(finestra);
        finestra.add(menu);
        finestra.setVisible(true);


    }
}
